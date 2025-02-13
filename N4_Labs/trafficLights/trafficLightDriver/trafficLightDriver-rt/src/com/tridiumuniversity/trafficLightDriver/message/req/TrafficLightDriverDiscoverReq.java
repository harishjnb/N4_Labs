/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;

import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.makeDiscoverRequest;

public class TrafficLightDriverDiscoverReq extends NMessage
{
    public TrafficLightDriverDiscoverReq(BIpAddress address)
    {
        super(address);
    }

    @Override
    public boolean toOutputStream(OutputStream out)
            throws Exception
    {
        String request = makeDiscoverRequest();

        out.write(request.getBytes());
        out.flush();

        // no fragmentation
        return false;
    }

    @Override
    public int validateResponse(NMessage message)
    {
        // Assume successful and let response handle failure
        return SUCCESS_RESPONSE;
    }

    @Override
    public String toTraceString()
    {
        return "discover device request";
    }
}
