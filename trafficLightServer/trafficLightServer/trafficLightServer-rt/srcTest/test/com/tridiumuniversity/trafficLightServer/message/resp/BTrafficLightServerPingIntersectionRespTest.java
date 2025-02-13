/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.resp;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingIntersectionResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerPingIntersectionResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerPingIntersectionRespTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.resp.BTrafficLightServerPingIntersectionRespTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 09:44:59 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerPingIntersectionRespTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testFailedPingIntersectionResponse()
    throws Exception
  {
    TrafficLightServerPingIntersectionResp response = new TrafficLightServerPingIntersectionResp(new BAddress(), "a", false);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeFailedPingIntersectionResponse("a"),
      "failed ping intersection response should write failed message to output stream"
    );
  }

  public void testSuccessfulPingIntersectionResponse()
    throws Exception
  {
    TrafficLightServerPingIntersectionResp response = new TrafficLightServerPingIntersectionResp(new BAddress(), "a", true);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeSuccessfulPingIntersectionResponse("a"),
      "successful ping intersection response should write successful message to output stream"
    );
  }

  public void isResponse()
  {
    TrafficLightServerPingIntersectionResp response = new TrafficLightServerPingIntersectionResp(new BAddress(), null, true);
    Assert.assertTrue(response.isResponse(), "ping intersection response should override isResponse method and return true");
  }
}
