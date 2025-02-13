/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver.message.req;

import java.io.OutputStream;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridiumuniversity.devTrafficLights.BTrafficLightState;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.makeSetTrafficLightRequest;

public class TrafficLightDriverSetLightReq extends NMessage
{
    public TrafficLightDriverSetLightReq(BIpAddress address, String intersection, String lightId, BTrafficLightState state)
    {
        super(address);
        this.intersectionId = intersection;
        this.lightId = lightId;
        this.state = state;
    }

    @Override
    public boolean toOutputStream(OutputStream out)
            throws Exception
    {
        String request = makeSetTrafficLightRequest(intersectionId, lightId, state);

        out.write(request.getBytes());
        out.flush();

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set light request: ");

        if (intersectionId != null && !intersectionId.isEmpty())
        {
            stringBuilder.append("intersectionId = ").append(intersectionId).append(",");
        }
        if (lightId != null && !lightId.isEmpty())
        {
            stringBuilder.append("lightId = ").append(lightId).append(",");
        }
        if (state != null)
        {
            stringBuilder.append("state = ").append(state);
        }

        return stringBuilder.toString();
    }

    private final String intersectionId;
    private final String lightId;
    private final BTrafficLightState state;
}
