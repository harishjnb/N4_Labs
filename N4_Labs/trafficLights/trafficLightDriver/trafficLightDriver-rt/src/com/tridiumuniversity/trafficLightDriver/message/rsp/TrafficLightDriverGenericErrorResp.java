package com.tridiumuniversity.trafficLightDriver.message.resp;

import java.io.InputStream;

import com.tridium.ndriver.comm.NMessage;

public class TrafficLightDriverGenericErrorResp extends NMessage
{
    @Override
    public void fromInputStream(InputStream in)
    {
    }

    @Override
    public boolean isResponse()
    {
        return true;
    }

    @Override
    public String toTraceString()
    {
        return "generic error response";
    }
}
