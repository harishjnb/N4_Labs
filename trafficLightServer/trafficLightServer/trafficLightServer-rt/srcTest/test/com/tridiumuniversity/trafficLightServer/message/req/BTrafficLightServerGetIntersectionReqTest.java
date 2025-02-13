/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message.req;

import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.nullTerminate;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerGetIntersectionReq;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.datatypes.BAddress;
import com.tridium.ndriver.io.TypedInputStream;

@NiagaraType
@Test
public class BTrafficLightServerGetIntersectionReqTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.req.BTrafficLightServerGetIntersectionReqTest(2979906276)1.0$ @*/
/* Generated Wed Jan 03 15:07:49 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerGetIntersectionReqTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void fromInputStreamParsesBadGetIntersectionRequest()
  {
    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    request.fromInputStream(new TypedInputStream(nullTerminate("something weird").getBytes()));
    Assert.assertNull(request.getIntersectionId(), "bad get intersection request should not set intersection id");
  }

  public void fromInputStreamParsesGoodGetIntersectionRequest()
  {
    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    request.fromInputStream(new TypedInputStream(nullTerminate("get a").getBytes()));
    Assert.assertEquals(request.getIntersectionId(), "a", "good get intersection request should set intersection id");
  }
}
