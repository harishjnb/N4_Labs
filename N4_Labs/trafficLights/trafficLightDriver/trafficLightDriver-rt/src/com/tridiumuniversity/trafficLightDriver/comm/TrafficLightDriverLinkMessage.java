/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.comm;

import java.io.InputStream;
import java.io.OutputStream;

import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedOutputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.END_BYTE;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.START_BYTE;

/**
 * TrafficLightDriverLinkMessage streams data to and from a byte array representation.
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
public class TrafficLightDriverLinkMessage
  extends LinkMessage
{
  public TrafficLightDriverLinkMessage(int maxLen)
  {
    super(maxLen);
  }

  /**
   * Get byte data from inputStream.
   * @return true if complete message received
   */
  public boolean receive(InputStream in)
    throws Exception
  {
    int state = IDLE;

    while (state != FINISHED)
    {
      int charIn = in.read();
      if (charIn < 0)
      {
        return false;
      }

      // Always start/restart if START_BYTE encounterd
      if (charIn == START_BYTE)
      {
        //start adding data to beginning of byte array and put ourselves in READ state
        dataIdx = 0;
        state = READ_DATA;
      }
      else if (charIn == END_BYTE)
      {
        state = FINISHED;
      }
      else
      {
        buffer[dataIdx++] = (byte)charIn;
      }
    }

    return true;
  }

////////////////////////////////////////////////////////////////
// Handle outgoing messages
////////////////////////////////////////////////////////////////

  @Override
  public boolean setMessage(NMessage msg)
          throws Exception
  {
    //set the destination address of our message
    address = msg.getAddress();

    //translate the message to the output stream
    TypedOutputStream bos = new TypedOutputStream(MAX_DATA_LENGTH);
    msg.toOutputStream(bos);
    byte[] mdata = bos.toByteArray();

    OutputStream os = getOutputStream();
    os.write(START_BYTE);
    os.write(mdata);
    os.write(END_BYTE);
    os.flush();

    //no fragmentation supported
    return false;
  }

  private static final int IDLE         = 0;
  private static final int READ_DATA    = 1;
  private static final int FINISHED     = 2;

  private static final int MAX_DATA_LENGTH = 256;
  private int dataIdx = 0;
}
