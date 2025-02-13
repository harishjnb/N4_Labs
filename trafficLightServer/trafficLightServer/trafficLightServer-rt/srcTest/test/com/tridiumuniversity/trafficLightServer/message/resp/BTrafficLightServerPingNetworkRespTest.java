/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.resp;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingNetworkResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingNetworkResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerPingNetworkResp;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerPingNetworkRespTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.resp.BTrafficLightServerPingNetworkRespTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 09:50:46 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerPingNetworkRespTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testFailedPingNetworkResponse()
    throws Exception
  {
    TrafficLightServerPingNetworkResp response = new TrafficLightServerPingNetworkResp(new BAddress(), false);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeFailedPingNetworkResponse(),
      "failed ping network response should write failed message to output stream"
    );
  }

  public void testSuccessfulPingNetworkResponse()
    throws Exception
  {
    TrafficLightServerPingNetworkResp response = new TrafficLightServerPingNetworkResp(new BAddress(), true);
    String responseString = getMessageAsString(response);
    Assert.assertEquals(responseString, makeSuccessfulPingNetworkResponse(),
      "successful ping network response should write successful message to output stream"
    );
  }

  public void isResponse()
  {
    TrafficLightServerPingNetworkResp response = new TrafficLightServerPingNetworkResp(new BAddress(), true);
    Assert.assertTrue(response.isResponse(), "ping network response should override isResponse method and return true");
  }
}
