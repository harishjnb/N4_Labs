/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;

import java.io.IOException;
import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedSetLightResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulSetLightResponse;


public class TrafficLightServerSetLightResp
  extends NMessage
{
  public TrafficLightServerSetLightResp(BAddress address, TrafficLightProtocol.SetLightRequestInfo setLightRequestInfo, boolean success)
  {
    super(address);
    this.setLightRequestInfo = setLightRequestInfo;
    this.success = success;
  }

  @Override
  public boolean toOutputStream(OutputStream outputStream)
    throws IOException
  {
    String response = success ? makeSuccessfulSetLightResponse(setLightRequestInfo) : makeFailedSetLightResponse();
    outputStream.write(response.getBytes());
    return false;
  }

  @Override
  public boolean isResponse()
  {
    return true;
  }

  private final TrafficLightProtocol.SetLightRequestInfo setLightRequestInfo;
  private final boolean success;
}
