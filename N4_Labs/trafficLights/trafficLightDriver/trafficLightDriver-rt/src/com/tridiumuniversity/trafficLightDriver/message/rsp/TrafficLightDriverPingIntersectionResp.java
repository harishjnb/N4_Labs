/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;

import java.io.InputStream;
import java.util.Optional;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isPingIntersectionErrorResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.parsePingIntersectionResponse;

public class TrafficLightDriverPingIntersectionResp extends NMessage
{
    @Override
    public void fromInputStream(InputStream inputStream)
    {
        TypedInputStream typedInputStream = (TypedInputStream)inputStream;
        String responseString = typedInputStream.readString();
        if (!isPingIntersectionResponse(responseString) || isPingIntersectionErrorResponse(responseString))
        {
            pingSuccessful = false;
            return;
        }

        intersectionId = parsePingIntersectionResponse(responseString);
        pingSuccessful = true;
    }

    @Override
    public boolean isResponse()
    {
        return true;
    }

    @Override
    public String toTraceString()
    {
        return String.format("ping intersection %s response: %s",
                intersectionId == null ? "" : intersectionId,
                pingSuccessful ? "success" : "failure"
        );
    }

    public boolean getPingSuccessful()
    {
        return pingSuccessful;
    }

    public String getIntersectionId()
    {
        return intersectionId;
    }

    private boolean pingSuccessful = false;
    private String intersectionId;
}
