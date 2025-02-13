/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerDiscoverReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerGetIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingNetworkReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerSetLightReq;

import java.util.logging.Logger;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.*;

/**
 * TrafficLightServerMessageFactory implementation of IMessageFactory.
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
public class TrafficLightServerMessageFactory
  implements IMessageFactory
{
  public TrafficLightServerMessageFactory()
  {
  }

  public NMessage makeMessage(LinkMessage lm)
    throws Exception
  {
    TypedInputStream inputStream = new TypedInputStream(lm.getByteArray());
    String messageContents = inputStream.readString();
    log.info("Received message: " + messageContents);

    NMessage message;
    if (isPingNetworkRequest(messageContents))
    {
      log.config("Interpreting message as ping network request");
      message = new TrafficLightServerPingNetworkReq((BAddress)lm.address);
    }
    else if (isPingIntersectionRequest(messageContents))
    {
      log.config("Interpreting message as ping intersection request");
      message = new TrafficLightServerPingIntersectionReq((BAddress)lm.address);
    }
    else if (isGetIntersectionRequest(messageContents))
    {
      log.config("Interpreting message as get intersection request");
      message = new TrafficLightServerGetIntersectionReq((BAddress)lm.address);
    }
    else if (isSetLightRequest(messageContents))
    {
      log.config("Interpreting message as set light request");
      message = new TrafficLightServerSetLightReq((BAddress)lm.address);
    }
    else if (isDiscoverRequest(messageContents))
    {
      log.config("Interpreting message as discover request");
      message = new TrafficLightServerDiscoverReq((BAddress)lm.address);
    }
    else
    {
      log.warning("Unrecognized message type: " + messageContents);
      return null;
    }

    // reset inputStream since we used it to pick a response message type
    inputStream.reset();

    message.fromInputStream(inputStream);
    return message;
  }

  private static final Logger log = Logger.getLogger("trafficLightServer");
}
