/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;

import java.io.InputStream;
import java.util.Optional;
import java.util.logging.Logger;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.parseSetLightRequest;

public class TrafficLightServerSetLightReq extends NMessage
{
  public TrafficLightServerSetLightReq(BAddress address)
  {
    super(address);
  }

  @Override
  public void fromInputStream(InputStream in)
  {
    TypedInputStream typedInputStream = (TypedInputStream)in;
    String request = typedInputStream.readString();
    Optional<TrafficLightProtocol.SetLightRequestInfo> infoOpt = parseSetLightRequest(request);
    if (!infoOpt.isPresent())
    {
      log.warning("Unable to parse set light request " + request);
      lightRequestInfo = null;
      return;
    }

    lightRequestInfo = infoOpt.get();
  }

  public TrafficLightProtocol.SetLightRequestInfo getLightRequestInfo()
  {
    return lightRequestInfo;
  }

  ////////////////////////////////////////////////////////////////
//  Attributes
////////////////////////////////////////////////////////////////

  private TrafficLightProtocol.SetLightRequestInfo lightRequestInfo;
  private static final Logger log = Logger.getLogger("trafficLightServer");
}
