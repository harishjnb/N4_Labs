package com.tridiumuniversity.trafficLightDriver.message.req;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;

import java.io.OutputStream;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.makeGetIntersectionRequest;

public class TrafficLightDriverGetIntersectionReq extends NMessage
{

    public  TrafficLightDriverGetIntersectionReq(BIpAddress address, String intersectionId)
    {
        super(address);
        this.id=intersectionId;
    }

    @Override
    public boolean toOutputStream(OutputStream out) throws Exception
    {
        String request = makeGetIntersectionRequest(id);
        out.write(request.getBytes());
        out.flush();
        return false;
    }

    @Override
    public int validateResponse(NMessage message)
    {
        return SUCCESS_RESPONSE;
    }

    @Override
    public String toTraceString()
    {
        String traceString = "get intersection request";
        if(id!=null && !id.isEmpty())
        {
            return traceString + ": " + id;
        }
        return traceString;
    }

    private final String id;
}
