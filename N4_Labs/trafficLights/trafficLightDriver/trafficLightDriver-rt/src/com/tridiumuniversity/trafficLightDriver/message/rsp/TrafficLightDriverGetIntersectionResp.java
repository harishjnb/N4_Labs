/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;
import com.tridiumuniversity.devTrafficLights.BTrafficLightState;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isGetIntersectionErrorResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.parseGetIntersectionResponse;

public class TrafficLightDriverGetIntersectionResp extends NMessage
{
    @Override
    public void fromInputStream(InputStream inputStream)
    {
        TypedInputStream typedInputStream = (TypedInputStream)inputStream;
        responseString = typedInputStream.readString();

        if (!isGetIntersectionResponse(responseString) || isGetIntersectionErrorResponse(responseString))
        {
            responseErrorOccurred = true;
            return;
        }

        lightStates = parseGetIntersectionResponse(responseString);
    }

    @Override
    public boolean isResponse()
    {
        return true;
    }

    @Override
    public String toTraceString()
    {
        String traceString = "get intersection response";
        if (responseString != null && !responseString.isEmpty())
        {
            return traceString + ": " + responseString;
        }
        if (lightStates != null && ! lightStates.isEmpty())
        {
            return traceString + ": " + lightStates;
        }
        return traceString;
    }

    public boolean responseErrorOccurred()
    {
        return responseErrorOccurred;
    }

    public Map<String, BTrafficLightState> getLightStates()
    {
        return Collections.unmodifiableMap(lightStates);
    }

    private String responseString;
    private boolean responseErrorOccurred;
    private Map<String, BTrafficLightState> lightStates;
}
