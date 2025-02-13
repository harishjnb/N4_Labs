/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.resp;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedSetLightResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulSetLightResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerSetLightResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerSetLightRespTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.resp.BTrafficLightServerSetLightRespTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 09:53:36 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerSetLightRespTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testFailedSetLightResponse()
    throws Exception
  {
    TrafficLightServerSetLightResp response = new TrafficLightServerSetLightResp(new BAddress(), null, false);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeFailedSetLightResponse(),
      "failed set light response should write failed message to output stream"
    );
  }

  public void testSuccessfulSetLightResponse()
    throws Exception
  {
    TrafficLightProtocol.SetLightRequestInfo setLightRequestInfo =
      new TrafficLightProtocol.SetLightRequestInfo("a", "n", BTrafficLightState.green);
    TrafficLightServerSetLightResp response = new TrafficLightServerSetLightResp(new BAddress(), setLightRequestInfo, true);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeSuccessfulSetLightResponse(setLightRequestInfo),
      "successful set light response should write successful message to output stream"
    );
  }

  public void isResponse()
  {
    TrafficLightServerSetLightResp response = new TrafficLightServerSetLightResp(new BAddress(), null, true);
    Assert.assertTrue(response.isResponse(), "set light response should override isResponse method and return true");
  }
}
