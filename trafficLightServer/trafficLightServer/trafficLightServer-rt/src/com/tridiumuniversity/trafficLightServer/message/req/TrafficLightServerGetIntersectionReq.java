/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;

import java.io.InputStream;
import java.util.Optional;
import java.util.logging.Logger;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.parseGetIntersectionRequest;

public class TrafficLightServerGetIntersectionReq extends NMessage
{
  public TrafficLightServerGetIntersectionReq(BAddress address)
  {
    super(address);
  }

  @Override
  public void fromInputStream(InputStream in)
  {
    TypedInputStream typedInputStream = (TypedInputStream)in;
    String request = typedInputStream.readString();
    Optional<String> intersectionIdOpt = parseGetIntersectionRequest(request);
    if (!intersectionIdOpt.isPresent())
    {
      log.warning("Unable to parse get intersection request " + request);
      intersectionId = null;
      return;
    }

    intersectionId = intersectionIdOpt.get();
  }

  public String getIntersectionId()
  {
    return intersectionId;
  }

  private String intersectionId;
  private static final Logger log = Logger.getLogger("trafficLightServer");
}
