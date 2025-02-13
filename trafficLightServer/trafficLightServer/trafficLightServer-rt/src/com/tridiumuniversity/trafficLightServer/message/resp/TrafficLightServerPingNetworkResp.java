/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingNetworkResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingNetworkResponse;

public class TrafficLightServerPingNetworkResp
  extends NMessage
{
  public TrafficLightServerPingNetworkResp(BAddress address, boolean success)
  {
    super(address);
    this.success = success;
  }

  @Override
  public boolean toOutputStream(OutputStream outputStream)
    throws Exception
  {
    String response = success ? makeSuccessfulPingNetworkResponse() : makeFailedPingNetworkResponse();
    outputStream.write(response.getBytes());
    return false;
  }

  @Override
  public boolean isResponse()
  {
    return true;
  }

  private final boolean success;
}
