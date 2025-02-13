/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.resp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;

import java.io.InputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isSetTrafficLightErrorResponse;
import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.isSetTrafficLightResponse;

public class TrafficLightDriverSetLightResp extends NMessage
{
    @Override
    public void fromInputStream(InputStream inputStream)
    {
        TypedInputStream typedInputStream = (TypedInputStream)inputStream;
        String responseString = typedInputStream.readString();

        responseErrorOccurred = !isSetTrafficLightResponse(responseString) || isSetTrafficLightErrorResponse(responseString);
    }

    @Override
    public boolean isResponse()
    {
        return true;
    }

    @Override
    public String toTraceString()
    {
        return "set light response: " + (responseErrorOccurred ? "success" : "failure");
    }

    public boolean responseErrorOccurred()
    {
        return responseErrorOccurred;
    }

    private boolean responseErrorOccurred;
}
