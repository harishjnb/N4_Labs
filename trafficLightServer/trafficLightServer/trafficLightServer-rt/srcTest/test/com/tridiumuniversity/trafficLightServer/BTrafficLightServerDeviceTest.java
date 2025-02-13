/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer;

import javax.baja.control.BEnumWritable;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice;
import com.tridiumuniversity.trafficLightServer.point.BTrafficLightServerProxyExt;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BTrafficLightServerDeviceTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.BTrafficLightServerDeviceTest(2979906276)1.0$ @*/
/* Generated Tue Jan 02 15:19:32 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerDeviceTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void cannotGetMissingPoint()
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    Assert.assertFalse(device.getPoint("n").isPresent(), "A missing point should not be found by getPoint");
  }

  public void canGetPointWhenPresent()
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    BEnumWritable point = new BEnumWritable();
    point.set("proxyExt", new BTrafficLightServerProxyExt());
    device.getPoints().add("n", point);

    Assert.assertTrue(device.getPoint("n").isPresent(), "An existing point should be found by getPoint");
    Assert.assertEquals(device.getPoint("n").get(), point, "The point found by getPoint should be the same as the point that was added");
  }

  public void getPointIsCaseInsensitive()
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    BEnumWritable point = new BEnumWritable();
    point.set("proxyExt", new BTrafficLightServerProxyExt());
    device.getPoints().add("n", point);

    Assert.assertTrue(device.getPoint("N").isPresent(), "An existing point should be found by getPoint");
    Assert.assertEquals(device.getPoint("N").get(), point, "The point found by getPoint should be the same as the point that was added");
  }

  public void canGetMultiplePoints()
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    BEnumWritable point1 = new BEnumWritable();
    BEnumWritable point2 = new BEnumWritable();
    BEnumWritable point3 = new BEnumWritable();

    point1.set("proxyExt", new BTrafficLightServerProxyExt());
    point2.set("proxyExt", new BTrafficLightServerProxyExt());
    point3.set("proxyExt", new BTrafficLightServerProxyExt());

    device.getPoints().add("n", point1);
    device.getPoints().add("s", point2);
    device.getPoints().add("e", point3);

    Assert.assertTrue(device.getPoint("n").isPresent(), "getPoint should be able to get all points");
    Assert.assertTrue(device.getPoint("s").isPresent(), "getPoint should be able to get all points");
    Assert.assertTrue(device.getPoint("e").isPresent(), "getPoint should be able to get all points");
  }
}
