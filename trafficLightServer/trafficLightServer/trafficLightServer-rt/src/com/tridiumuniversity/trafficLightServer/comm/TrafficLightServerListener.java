/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.comm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.baja.control.BControlPoint;
import javax.baja.control.BEnumWritable;
import javax.baja.driver.BDevice;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusEnum;
import javax.baja.sys.BEnum;

import com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice;
import com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetwork;
import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerDiscoverReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerGetIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingNetworkReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerSetLightReq;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerDiscoverResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerGenericErrorResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerGetIntersectionResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerPingIntersectionResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerPingNetworkResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerSetLightResp;

import com.tridium.ndriver.comm.ICommListener;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BCommConfig;

/**
 * TrafficLightServerListener processes unsolicited messages.
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
public class TrafficLightServerListener
  implements ICommListener
{
  /**
   * Constructor
   */
  public TrafficLightServerListener(BCommConfig config)
  {
    network = (BTrafficLightServerNetwork)config.getParent();
  }

  /**
   * Customized to process the unsolicited message for this driver.
   *
   * @param message message received from device
   */
  @Override
  public void receiveMessage(NMessage message)
  {
    NMessage response;
    if (message instanceof TrafficLightServerPingNetworkReq)
    {
      response = handlePingNetworkRequest((TrafficLightServerPingNetworkReq)message);
    }
    else if (message instanceof TrafficLightServerPingIntersectionReq)
    {
      response = handlePingIntersectionRequest((TrafficLightServerPingIntersectionReq)message);
    }
    else if (message instanceof TrafficLightServerGetIntersectionReq)
    {
      response = handleGetIntersectionRequest((TrafficLightServerGetIntersectionReq)message);
    }
    else if (message instanceof TrafficLightServerSetLightReq)
    {
      response = handleSetLightRequest((TrafficLightServerSetLightReq)message);
    }
    else if (message instanceof TrafficLightServerDiscoverReq)
    {
      response = handleDiscoverRequest((TrafficLightServerDiscoverReq)message);
    }
    else
    {
      log.config("Creating generic error response: unrecognized request type");
      response = new TrafficLightServerGenericErrorResp(message.getAddress());
    }

    try
    {
      network.sendMessage(response);
    }
    catch (Exception ex)
    {
      log.log(Level.WARNING, "Unable to send response to received request", log.isLoggable(Level.FINE) ? ex : null);
    }
  }

  private NMessage handlePingNetworkRequest(TrafficLightServerPingNetworkReq request)
  {
    boolean networkUp = network.getEnabled() && network.getStatus().isOk();

    if (networkUp)
    {
      log.config("Creating successful ping network response");
    }
    else
    {
      log.warning("Creating failed ping network response: network is down");
    }
    return new TrafficLightServerPingNetworkResp(request.getAddress(), networkUp);
  }

  private NMessage handlePingIntersectionRequest(TrafficLightServerPingIntersectionReq request)
  {
    String intersectionId = request.getIntersectionId();
    if (intersectionId == null)
    {
      log.warning("Creating generic error response: cannot retrieve intersection id");
      return new TrafficLightServerGenericErrorResp(request.getAddress());
    }

    boolean deviceIsUp = network.deviceIsUp(intersectionId);
    if (deviceIsUp && log.isLoggable(Level.CONFIG))
    {
      log.config("Creating successful ping intersection response with intersection id " + intersectionId);
    }
    else if (!deviceIsUp)
    {
      log.warning(String.format("Creating failed ping intersection response with intersection id %s: no device with provided id or device is down", intersectionId));
    }

    log.config("Creating successful ping intersection response with intersection id " + intersectionId);
    return new TrafficLightServerPingIntersectionResp(request.getAddress(), intersectionId, deviceIsUp);
  }

  private NMessage handleGetIntersectionRequest(TrafficLightServerGetIntersectionReq request)
  {
    String intersectionId = request.getIntersectionId();
    if (intersectionId == null)
    {
      log.warning("Creating generic error response: cannot retrieve intersection id");
      return new TrafficLightServerGenericErrorResp(request.getAddress());
    }

    Optional<BTrafficLightServerDevice> deviceOpt = network.getDevice(intersectionId);
    if (!deviceOpt.isPresent())
    {
      log.warning(String.format("Creating failed get intersection response for intersection id %s: no device with provided id", intersectionId));
      return new TrafficLightServerGetIntersectionResp(request.getAddress(), null, false);
    }

    BTrafficLightServerDevice device = deviceOpt.get();
    if (!network.deviceIsUp(device))
    {
      log.warning(String.format("Creating failed get intersection response for intersection id %s: device is not up", intersectionId));
      return new TrafficLightServerGetIntersectionResp(request.getAddress(), null, false);
    }

    Map<String, BTrafficLightState> lightStates =
      Arrays.stream(device.getPoints().getPoints())
        .collect(Collectors.toMap(
          point -> point.getName(),
          point -> BTrafficLightState.make(point.getOutStatusValue().getValueValue().as(BEnum.class).getOrdinal())
        ));

    log.config("Creating successful get intersection response with light states " + lightStates);
    return new TrafficLightServerGetIntersectionResp(request.getAddress(), lightStates, true);
  }

  private NMessage handleSetLightRequest(TrafficLightServerSetLightReq request)
  {
    TrafficLightProtocol.SetLightRequestInfo setLightRequestInfo = request.getLightRequestInfo();
    if (setLightRequestInfo == null)
    {
      log.warning("Creating generic error response: cannot retrieve light request information");
      return new TrafficLightServerGenericErrorResp(request.getAddress());
    }

    Optional<BTrafficLightServerDevice> deviceOpt = network.getDevice(setLightRequestInfo.getIntersectionId());
    if (!deviceOpt.isPresent())
    {
      log.warning(String.format("Creating failed set light response for intersection id %s and light id %s: no device with provided id", setLightRequestInfo.getIntersectionId(), setLightRequestInfo.getLightId()));
      return new TrafficLightServerSetLightResp(request.getAddress(), null, false);
    }
    BTrafficLightServerDevice device = deviceOpt.get();

    if (!network.deviceIsUp(device))
    {
      log.warning(String.format("Creating failed set light response for intersection id %s and light id %s: device with provided id is down", setLightRequestInfo.getIntersectionId(), setLightRequestInfo.getLightId()));
      return new TrafficLightServerSetLightResp(request.getAddress(), null, false);
    }

    Optional<BEnumWritable> pointOpt = device.getPoint(setLightRequestInfo.getLightId());
    if (!pointOpt.isPresent())
    {
      log.warning(String.format("Creating failed set intersection response for intersection id %s and light id %s: no light with provided id", setLightRequestInfo.getIntersectionId(), setLightRequestInfo.getLightId()));
      return new TrafficLightServerSetLightResp(request.getAddress(), null, false);
    }
    BEnumWritable point = pointOpt.get();

    log.config(String.format("Creating successful set light response with info " + setLightRequestInfo));
    point.setFallback(new BStatusEnum(setLightRequestInfo.getState(), BStatus.ok));
    return new TrafficLightServerSetLightResp(request.getAddress(), setLightRequestInfo, true);
  }

  private NMessage handleDiscoverRequest(TrafficLightServerDiscoverReq request)
  {
    Map<String, List<String>> intersectionIdsToLightIdsMap = new HashMap<>();
    List<BDevice> devices = network.getBDeviceList();
    for (BDevice device : devices)
    {
      if (!(device instanceof BTrafficLightServerDevice))
      {
        continue;
      }

      BTrafficLightServerDevice trafficLightServerDevice = (BTrafficLightServerDevice)device;
      BControlPoint[] points = trafficLightServerDevice.getPoints().getPoints();
      List<String> lightIds = Arrays.stream(points)
        .map(point -> point.getName())
        .collect(Collectors.toList());

      intersectionIdsToLightIdsMap.put(trafficLightServerDevice.getIntersectionId(), lightIds);
    }

    log.config("Creating successful discover response");
    return new TrafficLightServerDiscoverResp(request.getAddress(), intersectionIdsToLightIdsMap, true);
  }

  private final BTrafficLightServerNetwork network;
  private static final Logger log = Logger.getLogger("trafficLightServer");
}
