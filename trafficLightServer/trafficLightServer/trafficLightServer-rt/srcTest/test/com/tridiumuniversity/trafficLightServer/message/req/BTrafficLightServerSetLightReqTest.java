/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.req;

import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.nullTerminate;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerSetLightReq;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;

@NiagaraType
@Test
public class BTrafficLightServerSetLightReqTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.req.BTrafficLightServerSetLightReqTest(2979906276)1.0$ @*/
/* Generated Wed Jan 03 15:43:38 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerSetLightReqTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public void fromInputStreamParsesBadSetLightRequest()
{
  TrafficLightServerSetLightReq request = new TrafficLightServerSetLightReq(new BAddress());
  request.fromInputStream(new TypedInputStream(nullTerminate("something weird").getBytes()));
  Assert.assertNull(request.getLightRequestInfo(), "bad set light request should not set light request info");
}

  public void fromInputStreamParsesGoodSetLightRequest()
  {
    TrafficLightServerSetLightReq request = new TrafficLightServerSetLightReq(new BAddress());
    request.fromInputStream(new TypedInputStream(nullTerminate("set a n green").getBytes()));
    Assert.assertEquals(request.getLightRequestInfo(), new TrafficLightProtocol.SetLightRequestInfo("a", "n", BTrafficLightState.green),
      "good set light request should set light request info"
    );
  }
}
