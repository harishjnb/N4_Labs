/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulGetIntersectionResponse;

public class TrafficLightServerGetIntersectionResp
  extends NMessage
{
  public TrafficLightServerGetIntersectionResp(BAddress address, Map<String, BTrafficLightState> lightStates, boolean success)
  {
    super(address);
    this.lightStates = lightStates;
    this.success = success;
  }

  @Override
  public boolean toOutputStream(OutputStream outputStream)
    throws IOException
  {
    String response = success ? makeSuccessfulGetIntersectionResponse(lightStates) : makeFailedGetIntersectionResponse();
    outputStream.write(response.getBytes());
    return false;
  }

  @Override
  public boolean isResponse()
  {
    return true;
  }

  private final Map<String, BTrafficLightState> lightStates;
  private final boolean success;
}
