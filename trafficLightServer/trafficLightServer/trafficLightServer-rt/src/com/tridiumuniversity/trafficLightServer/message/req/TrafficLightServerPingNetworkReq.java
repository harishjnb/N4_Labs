/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

import java.io.InputStream;

public class TrafficLightServerPingNetworkReq extends NMessage
{
  public TrafficLightServerPingNetworkReq(BAddress address)
  {
    super(address);
  }

  @Override
  public void fromInputStream(InputStream in)
  {
  }
}
