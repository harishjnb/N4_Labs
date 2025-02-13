package com.tridiumuniversity.trafficLightDriver.message.rsp;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.tridiumuniversity.trafficLightDriver.message.TrafficLightProtocol.*;

public class TrafficLightDriverDiscoverResp extends NMessage {
    @Override
    public void fromInputStream(InputStream inputStream)
    {
        TypedInputStream typedInputStream = (TypedInputStream)inputStream;
        responseString = typedInputStream.readString();

        if (!isDiscoverResponse(responseString) || isDiscoverErrorResponse(responseString))
        {
            responseErrorOccurred = true;
            return;
        }

        intersectionLightMap = parseDiscoverResponse(responseString);
    }

    @Override
    public boolean isResponse()
    {
        return true;
    }

    @Override
    public String toTraceString()
    {
        String traceString = "discover response";
        if (responseString != null && !responseString.isEmpty())
        {
            return traceString + ": " + responseString;
        }
        if (intersectionLightMap != null && ! intersectionLightMap.isEmpty())
        {
            return traceString + ": " + intersectionLightMap;
        }
        return traceString;
    }

    public boolean responseErrorOccurred()
    {
        return responseErrorOccurred;
    }

    public Map<String, List<String>> getIntersectionLightMap()
    {
        return Collections.unmodifiableMap(intersectionLightMap);
    }

    private String responseString;
    private boolean responseErrorOccurred;
    private Map<String, List<String>> intersectionLightMap;
}
