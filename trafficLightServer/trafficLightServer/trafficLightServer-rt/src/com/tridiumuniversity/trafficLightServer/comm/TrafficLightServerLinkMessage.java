/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.comm;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.END_BYTE;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.START_BYTE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;

/**
 * TrafficLightServerLinkMessage streams data to and from a byte array representation.
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
public class TrafficLightServerLinkMessage
  extends LinkMessage
{
  public TrafficLightServerLinkMessage(int maxLen)
  {
    super(maxLen);
  }

  public boolean receive(InputStream in)
    throws IOException
  {
    OutputStream os = getOutputStream();
    int state = IDLE;

    while (state != FINISHED)
    {
      if (getLength() >= buffer.length)
      {
        return false;
      }

      int charIn = in.read();
      if (charIn < 0)
      {
        return false;
      }

      if (charIn == START_BYTE)
      {
        if (state == READ_DATA)
        {
          return false;
        }
        state = READ_DATA;
      }
      else if (charIn == END_BYTE)
      {
        if (state != READ_DATA)
        {
          return false;
        }
        state = FINISHED;
      }
      else
      {
        os.write(charIn);
      }
    }

    return true;
  }

  @Override
  public boolean setMessage(NMessage msg)
    throws Exception
  {
    //set the destination address of our message
    address = msg.getAddress();

    //translate the message to the output stream
    ByteArrayOutputStream msgBytes = new ByteArrayOutputStream(MAX_DATA_LENGTH);
    msg.toOutputStream(msgBytes);
    byte[] mdata = msgBytes.toByteArray();

    OutputStream os = getOutputStream();
    os.write(START_BYTE);
    os.write(mdata);
    os.write(END_BYTE);
    os.flush();

    //no fragmentation supported
    return false;
  }


  private static final int IDLE = 0;
  private static final int READ_DATA = 1;
  private static final int FINISHED = 2;

  private static final int MAX_DATA_LENGTH = 256;
  private int dataIdx = 0;
}
