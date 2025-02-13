/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.rsp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;

import java.io.InputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isPingNetworkErrorResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isPingNetworkResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.parsePingNetworkResponse;

public class TrafficLightDriverPingNetworkResp extends NMessage
{
    @Override
    public void fromInputStream(InputStream inputStream)
    {
        TypedInputStream typedInputStream = (TypedInputStream)inputStream;
        String responseString = typedInputStream.readString();
        if (!isPingNetworkResponse(responseString) || isPingNetworkErrorResponse(responseString))
        {
            pingSuccessful = false;
            return;
        }

        pingSuccessful = parsePingNetworkResponse(responseString);
    }

    @Override
    public boolean isResponse()
    {
        return true;
    }

    @Override
    public String toTraceString()
    {
        return "ping network response: " + (pingSuccessful ? "success" : "failure");
    }

    public boolean getPingSuccessful()
    {
        return pingSuccessful;
    }

    private boolean pingSuccessful = false;
}
