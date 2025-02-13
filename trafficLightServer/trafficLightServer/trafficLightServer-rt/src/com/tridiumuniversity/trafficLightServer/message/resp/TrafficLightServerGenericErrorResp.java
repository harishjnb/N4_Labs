/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

import java.io.IOException;
import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeGenericErrorResponse;

public class TrafficLightServerGenericErrorResp
  extends NMessage
{
  public TrafficLightServerGenericErrorResp(BAddress address)
  {
    super(address);
  }

  @Override
  public boolean toOutputStream(OutputStream outputStream)
    throws IOException
  {
    outputStream.write(makeGenericErrorResponse().getBytes());
    return false;
  }

  @Override
  public boolean isResponse()
  {
    return true;
  }
}
