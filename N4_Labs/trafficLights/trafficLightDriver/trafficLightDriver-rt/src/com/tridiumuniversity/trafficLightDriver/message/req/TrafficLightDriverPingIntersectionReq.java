package com.tridiumuniversity.trafficLightDriver.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;

import java.io.IOException;
import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.makePingIntersectionRequest;

public class TrafficLightDriverPingIntersectionReq extends NMessage {

    public  TrafficLightDriverPingIntersectionReq(BIpAddress address)
    {
        this(address,null);
    }

    public TrafficLightDriverPingIntersectionReq(BIpAddress address, String intersectionId)
    {
        super(address);
        this.intersectionId = intersectionId;
    }

    @Override
    public boolean toOutputStream(OutputStream out) throws IOException
    {
        String request = makePingIntersectionRequest(intersectionId);
        out.write(request.getBytes());
        out.flush();
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
        String traceString = "ping intersection request";
        if (intersectionId != null && ! intersectionId.isEmpty())
        {
            return traceString + ": " + intersectionId;
        }
        return traceString;
    }

    public String getIntersectionId()
    {
        return intersectionId;
    }

    private final String intersectionId;
}
