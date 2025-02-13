/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.resp;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeGenericErrorResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerGenericErrorResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerGenericErrorRespTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.resp.BTrafficLightServerGenericErrorRespTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 09:28:42 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerGenericErrorRespTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testGenericErrorResponse()
    throws Exception
  {
    TrafficLightServerGenericErrorResp response = new TrafficLightServerGenericErrorResp(new BAddress());
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeGenericErrorResponse(),
      "generic error response should write expected string to output stream"
    );
  }

  public void isResponse()
  {
    TrafficLightServerGenericErrorResp response = new TrafficLightServerGenericErrorResp(new BAddress());
    Assert.assertTrue(response.isResponse(), "generic error response should override isResponse method and return true");
  }
}
