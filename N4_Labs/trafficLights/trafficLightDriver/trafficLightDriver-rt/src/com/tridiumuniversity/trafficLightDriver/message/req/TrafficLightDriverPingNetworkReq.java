/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;

import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.makePingNetworkRequest;

public class TrafficLightDriverPingNetworkReq extends NMessage
{
    public TrafficLightDriverPingNetworkReq(BIpAddress address)
    {
        super(address);
    }

    @Override
    public boolean toOutputStream(OutputStream outputStream)
            throws Exception
    {
        String request = makePingNetworkRequest();
        outputStream.write(request.getBytes());

        // no fragmentation
        return false;
    }

    @Override
    public int validateResponse(NMessage message)
    {
        // Assume successful and let response handle ping failure
        return SUCCESS_RESPONSE;
    }

    @Override
    public String toTraceString()
    {
        return "ping network request";
    }
}
