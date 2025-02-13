/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingIntersectionResponse;

public class TrafficLightServerPingIntersectionResp extends NMessage
{
  public TrafficLightServerPingIntersectionResp(BAddress address, String intersectionId, boolean success)
  {
    super(address);
    this.intersectionId = intersectionId;
    this.success = success;
  }

  @Override
  public boolean toOutputStream(OutputStream outputStream)
    throws Exception
  {
    String response = success ? makeSuccessfulPingIntersectionResponse(intersectionId) : makeFailedPingIntersectionResponse(intersectionId);
    outputStream.write(response.getBytes());
    return false;
  }

  @Override
  public boolean isResponse()
  {
    return true;
  }

  private final String intersectionId;
  private final boolean success;
}
