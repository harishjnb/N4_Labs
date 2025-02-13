/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.resp;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulGetIntersectionResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.makeMap;

import java.util.Map;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerGetIntersectionResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerGetIntersectionRespTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.resp.BTrafficLightServerGetIntersectionRespTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 09:37:33 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerGetIntersectionRespTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testFailedGetIntersectionResp()
    throws Exception
  {
    TrafficLightServerGetIntersectionResp response = new TrafficLightServerGetIntersectionResp(new BAddress(), null, false);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeFailedGetIntersectionResponse(),
      "failed get intersection response should write failed message to output stream"
    );
  }

  public void testSuccessfulGetIntersectionResp()
    throws Exception
  {
    Map<String, BTrafficLightState> lightStates = makeMap(
      new String[]{ "n", "s", "e" },
      new BTrafficLightState[]{ BTrafficLightState.red, BTrafficLightState.yellow, BTrafficLightState.green }
    );
    TrafficLightServerGetIntersectionResp response = new TrafficLightServerGetIntersectionResp(new BAddress(), lightStates, true);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeSuccessfulGetIntersectionResponse(lightStates),
      "successful get intersection response should write successful message to output stream"
    );
  }

  public void isResponse()
  {
    TrafficLightServerGetIntersectionResp response = new TrafficLightServerGetIntersectionResp(new BAddress(), null, true);
    Assert.assertTrue(response.isResponse(), "get intersection response should override isResponse method and return true");
  }
}
