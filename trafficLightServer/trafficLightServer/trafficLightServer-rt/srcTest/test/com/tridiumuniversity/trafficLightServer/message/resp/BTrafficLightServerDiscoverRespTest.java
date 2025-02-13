/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.resp;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedDiscoverResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulDiscoverResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.makeMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerDiscoverResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerDiscoverRespTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.resp.BTrafficLightServerDiscoverRespTest(2979906276)1.0$ @*/
/* Generated Wed Jan 03 15:43:38 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerDiscoverRespTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testFailedDiscoverResponse()
    throws Exception
  {
    TrafficLightServerDiscoverResp response = new TrafficLightServerDiscoverResp(new BAddress(), null, false);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeFailedDiscoverResponse(),
      "failed discover response should write failed message to output stream"
    );
  }

  public void testSuccessfulDiscoverResponse()
    throws Exception
  {
    @SuppressWarnings("unchecked")
    Map<String, List<String>> intersectionIdsToLightIdsMap = makeMap(
      new String[]{ "a", "b", "c" },
      new List[]{ Arrays.asList("n", "s"), Arrays.asList("n", "s", "e", "w"), Arrays.asList("e", "w") }
    );
    TrafficLightServerDiscoverResp response = new TrafficLightServerDiscoverResp(new BAddress(), intersectionIdsToLightIdsMap, true);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeSuccessfulDiscoverResponse(intersectionIdsToLightIdsMap),
      "successful discover response should write successful message to output stream"
    );
  }

  public void isResponse()
  {
    TrafficLightServerDiscoverResp response = new TrafficLightServerDiscoverResp(new BAddress(), null, true);
    Assert.assertTrue(response.isResponse(), "discover response should override isResponse method and return true");
  }
}
