/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public final class TrafficLightProtocol
{

  public static String makeGenericErrorResponse()
  {
    return ERROR;
  }

//region ping network

  public static boolean isPingNetworkRequest(String request)
  {
    return PING_PREFIX.equals(request);
  }

  public static String makeSuccessfulPingNetworkResponse()
  {
    return String.format("%s %s", PING_PREFIX, OK);
  }

  public static String makeFailedPingNetworkResponse()
  {
    return String.format("%s %s", PING_PREFIX, ERROR);
  }

//endregion ping
//region ping intersection

  public static boolean isPingIntersectionRequest(String request)
  {
    return request.startsWith(PING_PREFIX) && !request.equals(PING_PREFIX);
  }

  public static Optional<String> parsePingIntersectionRequest(String request)
  {
    if (!isPingIntersectionRequest(request))
    {
      return Optional.empty();
    }
    return Optional.of(request.substring((PING_PREFIX + " ").length()).toLowerCase());
  }

  public static String makeSuccessfulPingIntersectionResponse(String intersectionId)
  {
    return String.format("%s %s %s", PING_PREFIX, intersectionId, OK);
  }

  public static String makeFailedPingIntersectionResponse(String intersectionId)
  {
    // intersectionId should always be non-null and non-empty since we create a generic error response if the
    // intersectionId was not provided
    return String.format("%s %s %s", PING_PREFIX, intersectionId, ERROR);
  }

//endregion ping intersection
//region get intersection

  public static boolean isGetIntersectionRequest(String request)
  {
    return request.startsWith(GET_PREFIX);
  }

  public static Optional<String> parseGetIntersectionRequest(String request)
  {
    if (!isGetIntersectionRequest(request))
    {
      return Optional.empty();
    }
    return Optional.of(request.substring((GET_PREFIX + " ").length()).toLowerCase());
  }

  public static String makeSuccessfulGetIntersectionResponse(Map<String, BTrafficLightState> lightStates)
  {
    String lightStatesString = lightStates
      .entrySet()
      .stream()
      .map(entry -> entry.getKey() + " " + entry.getValue().getTag())
      .collect(Collectors.joining("\t"));
    return String.format("%s %s", GET_PREFIX, lightStatesString.toLowerCase());
  }

  public static String makeFailedGetIntersectionResponse()
  {
    return String.format("%s %s", GET_PREFIX, ERROR);
  }

//endregion
//region set traffic light

  public static boolean isSetLightRequest(String request)
  {
    return request.startsWith(SET_PREFIX);
  }

  public static Optional<SetLightRequestInfo> parseSetLightRequest(String request)
  {
    if (!isSetLightRequest(request))
    {
      return Optional.empty();
    }

    String[] values = request.substring((SET_PREFIX + " ").length()).split(" ");
    if (values.length != 3)
    {
      return Optional.empty();
    }

    return Optional.of(new SetLightRequestInfo(values[0].toLowerCase(), values[1].toLowerCase(), BTrafficLightState.make(values[2].toLowerCase())));
  }

  public static String makeSuccessfulSetLightResponse(SetLightRequestInfo info)
  {
    return String.format("%s %s %s %s %s", SET_PREFIX, info.intersectionId, info.lightId, info.state.getTag(), OK);
  }

  public static String makeFailedSetLightResponse()
  {
    return String.format("%s %s", SET_PREFIX, ERROR);
  }

  public static final class SetLightRequestInfo
  {
    public SetLightRequestInfo(String intersectionId, String lightId, BTrafficLightState state)
    {
      this.intersectionId = intersectionId;
      this.lightId = lightId;
      this.state = state;
    }

    public String getIntersectionId()
    {
      return intersectionId;
    }

    public String getLightId()
    {
      return lightId;
    }

    public BTrafficLightState getState()
    {
      return state;
    }

    @Override
    public String toString()
    {
      return String.format("[intersectionId=%s, lightId=%s, state=%s]", intersectionId, lightId, state.getTag());
    }

    @Override
    public boolean equals(Object other)
    {
      if (!(other instanceof SetLightRequestInfo))
      {
        return false;
      }
      SetLightRequestInfo otherInfo = (SetLightRequestInfo)other;

      return intersectionId.equals(otherInfo.getIntersectionId())
        && lightId.equals(otherInfo.getLightId())
        && state == otherInfo.getState();
    }

    private final String intersectionId;
    private final String lightId;
    private final BTrafficLightState state;
  }

//endregion
//region discovery

  public static boolean isDiscoverRequest(String response)
  {
    return DISCOVER_PREFIX.equals(response);
  }

  public static String makeSuccessfulDiscoverResponse(Map<String, List<String>> intersectionIdToLightIdsMap)
  {
    String intersectionsAndLightsString = intersectionIdToLightIdsMap
      .entrySet()
      .stream()
      .map(entry -> {
        String intersectionId = entry.getKey();
        List<String> lightIds = entry.getValue();
        return lightIds
          .stream()
          .map(lightId -> intersectionId + " " + lightId)
          .collect(Collectors.joining("\t"));
      })
      .collect(Collectors.joining("\t"));
    return String.format("%s %s", DISCOVER_PREFIX, intersectionsAndLightsString.toLowerCase());
  }

  public static String makeFailedDiscoverResponse()
  {
    return String.format("%s %s", DISCOVER_PREFIX, ERROR);
  }

//endregion
//region constants

  public static final char START_BYTE = 0;
  public static final char END_BYTE = 23;
  private static final String PING_PREFIX = "ping";
  private static final String GET_PREFIX = "get";
  private static final String SET_PREFIX = "set";
  private static final String OK = "ok";
  private static final String ERROR = "error";
  private static final String DISCOVER_PREFIX = "discover";

//endregion
}
