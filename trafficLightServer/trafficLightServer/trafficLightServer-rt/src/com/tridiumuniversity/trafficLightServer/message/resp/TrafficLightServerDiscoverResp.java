/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedDiscoverResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulDiscoverResponse;

public class TrafficLightServerDiscoverResp
  extends NMessage
{
  public TrafficLightServerDiscoverResp(BAddress address, Map<String, List<String>> intersectionIdsToLightIdsMap, boolean success)
  {
    super(address);
    this.intersectionIdsToLightIdsMap = intersectionIdsToLightIdsMap;
    this.success = success;
  }

  @Override
  public boolean toOutputStream(OutputStream outputStream)
    throws IOException
  {
    String response = success ? makeSuccessfulDiscoverResponse(intersectionIdsToLightIdsMap) : makeFailedDiscoverResponse();
    outputStream.write(response.getBytes());
    return false;
  }

  @Override
  public boolean isResponse()
  {
    return true;
  }

  private final Map<String, List<String>> intersectionIdsToLightIdsMap;
  private final boolean success;
}
