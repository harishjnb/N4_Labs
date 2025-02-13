/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message;

import com.tridiumuniversity.devTrafficLights.BTrafficLightState;

import java.util.HashMap;
import java.util.Map;

public final class TrafficLightProtocol
{

    public static boolean isGenericErrorResponse(String response)
    {
        return ERROR.equals(response);
    }

//region ping network

    public static String makePingNetworkRequest()
    {
        return PING_PREFIX;
    }

    public static boolean isPingNetworkResponse(String response)
    {
        return PING_NETWORK_SUCCESS.equals(response) || PING_NETWORK_ERROR.equals(response);
    }

    public static boolean isPingNetworkErrorResponse(String response)
    {
        return PING_NETWORK_ERROR.equals(response);
    }

    public static boolean parsePingNetworkResponse(String response)
    {
        return PING_NETWORK_SUCCESS.equals(response);
    }

//endregion ping network
//region ping intersection

    public static String makePingIntersectionRequest(String intersectionId)
    {
        return PING_PREFIX + " " + intersectionId;
    }

    public static boolean isPingIntersectionResponse(String response)
    {
        return response.startsWith(PING_PREFIX) && !isPingNetworkResponse(response);
    }

    public static boolean isPingIntersectionErrorResponse(String response)
    {
        return isPingIntersectionResponse(response) && response.contains(ERROR);
    }

    public static String parsePingIntersectionResponse(String response)
    {
        String[] tokens = response.split(" ");
        return tokens[1];
    }

//endregion ping intersection
//region get intersection

    public static String makeGetIntersectionRequest(String intersectionId)
    {
        return GET_PREFIX + " " + intersectionId;
    }

    public static boolean isGetIntersectionResponse(String response)
    {
        return response.startsWith(GET_PREFIX);
    }

    public static boolean isGetIntersectionErrorResponse(String response)
    {
        return response.contains(GET_ERROR);
    }

    public static Map<String, BTrafficLightState> parseGetIntersectionResponse(String response)
    {
        Map<String, BTrafficLightState> lightValues = new HashMap<>();

        response = response.substring((GET_PREFIX + " ").length());

        String[] lightValuePairs = response.split("\t");
        for (String lightValuePair : lightValuePairs)
        {
            String[] lightAndValue = lightValuePair.split(" ");
            lightValues.put(lightAndValue[0].toLowerCase(), BTrafficLightState.make(lightAndValue[1].toLowerCase()));
        }
        return lightValues;
    }

//endregion get intersection
//region set traffic light

    public static String makeSetTrafficLightRequest(String intersectionId, String lightId, BTrafficLightState state)
    {
        return String.format("%s %s %s %s", SET_PREFIX, intersectionId, lightId, state);
    }

    public static boolean isSetTrafficLightResponse(String response)
    {
        return response.startsWith(SET_PREFIX);
    }

    public static boolean isSetTrafficLightErrorResponse(String response)
    {
        return response.contains(SET_ERROR);
    }

//endregion set traffic light

    public static final char START_BYTE = 0;
    public static final char END_BYTE = 23;
    private static final String OK = "ok";
    private static final String ERROR = "error";
    private static final String PING_PREFIX = "ping";
    private static final String PING_NETWORK_SUCCESS = String.format("%s %s", PING_PREFIX, OK);
    private static final String PING_NETWORK_ERROR = String.format("%s %s", PING_PREFIX, ERROR);
    private static final String GET_PREFIX = "get";
    private static final String GET_ERROR = String.format("%s %s", GET_PREFIX, ERROR);
    private static final String SET_PREFIX = "set";
    private static final String SET_ERROR = String.format("%s %s", SET_PREFIX, ERROR);
}
