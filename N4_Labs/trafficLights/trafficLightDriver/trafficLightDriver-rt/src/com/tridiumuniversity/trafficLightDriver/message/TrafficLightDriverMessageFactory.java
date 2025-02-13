/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverGenericErrorResp;
import com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverGetIntersectionResp;
import com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverPingIntersectionResp;
import com.tridiumuniversity.trafficLightDriver.message.rsp.TrafficLightDriverPingNetworkResp;
import com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverSetLightResp;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.*;

/**
 * TrafficLightDriverMessageFactory implementation of IMessageFactory.
 */
public class TrafficLightDriverMessageFactory
        implements IMessageFactory
{
  public TrafficLightDriverMessageFactory()
  {
  }

  @Override
  public NMessage makeMessage(LinkMessage lm)
  {
    TypedInputStream typedInputStream = new TypedInputStream(lm.getByteArray());
    String responseString = typedInputStream.readString();

    log.info("Received message: " + responseString);

    NMessage responseMessage;
    if (isPingNetworkResponse(responseString))
    {
      log.config("Interpreting message as ping network response");
      responseMessage = new TrafficLightDriverPingNetworkResp();
    }
    else if (isPingIntersectionResponse(responseString))
    {
      log.config("Interpreting message as ping intersection response");
      responseMessage = new TrafficLightDriverPingIntersectionResp();
    }
    else if (isGetIntersectionResponse(responseString))
    {
      log.config("Interpreting message as get intersection response");
      responseMessage = new TrafficLightDriverGetIntersectionResp();
    }
    else if (isSetTrafficLightResponse(responseString))
    {
      log.config("Interpreting message as set traffic light response");
      responseMessage = new TrafficLightDriverSetLightResp();
    }
    else if (isGenericErrorResponse(responseString))
    {
      log.config("Interpreting message as generic error response");
      responseMessage = new TrafficLightDriverGenericErrorResp();
    }
    else
    {
      log.warning("Unrecognized message type: " + responseString);
      return null;
    }

    // reset inputStream since we used it to pick a response message type
    typedInputStream.reset();

    try
    {
      responseMessage.fromInputStream(typedInputStream);
    }
    catch(Exception ex)
    {
      log.log(Level.WARNING, "Unable to build response " + (log.isLoggable(Level.CONFIG) ? " for " + responseString : "") + " from " + lm.address, ex);
      return null;
    }

    return responseMessage;
  }

  private static final Logger log = Logger.getLogger("trafficLightDriver");
}
