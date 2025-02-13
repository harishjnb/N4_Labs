/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer;

import com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice;
import com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetwork;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import java.util.Optional;

@NiagaraType
@Test
public class BTrafficLightServerNetworkTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetworkTest(2979906276)1.0$ @*/
/* Generated Tue Jan 02 14:51:46 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerNetworkTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public void missingDeviceIsNotUp()
{
  BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
  Assert.assertFalse(network.deviceIsUp("a"), "A missing device should not be up");
}

  public void disabledDeviceIsNotUp()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    device.setEnabled(false);
    network.add("device", device);

    Assert.assertFalse(network.deviceIsUp("a"), "A disabled device should not be up");
  }

  public void nonOkStatusDeviceIsNotUp()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    device.setStatus(BStatus.down);
    network.add("device", device);

    Assert.assertFalse(network.deviceIsUp("a"), "A device whose status is not ok whould not be up");
  }

  public void enabledDeviceWithOkStatusIsUp()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    Assert.assertTrue(network.deviceIsUp("a"), "An enabled device with an ok status should be up");
  }

  public void deviceIsUpCheckIsCaseInsensitive()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    Assert.assertTrue(network.deviceIsUp("A"), "deviceIsUp check for intersectionId should be case-insensitive");
  }

  public void cannotGetMissingDevice()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    Assert.assertFalse(network.getDevice("a").isPresent(), "A missing device should not be found by getDevice");
  }

  public void canGetDeviceWhenPresent()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    Optional<BTrafficLightServerDevice> deviceOpt = network.getDevice("a");
    Assert.assertTrue(deviceOpt.isPresent(), "An existing device should be found by getDevice");
    Assert.assertEquals(deviceOpt.get(), device, "The device found by getDevice should be the same as the device that was added");
  }

  public void getDeviceIsCaseInsensitive()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    Optional<BTrafficLightServerDevice> deviceOpt = network.getDevice("A");
    Assert.assertTrue(deviceOpt.isPresent(), "getDevice should perform case-insensitive intersectionId check");
    Assert.assertEquals(deviceOpt.get(), device, "The device found by getDevice should be the same as the device that was added");
  }

  public void canGetMultipleDevices()
  {
    BTrafficLightServerNetwork network = new BTrafficLightServerNetwork();

    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    BTrafficLightServerDevice device1 = new BTrafficLightServerDevice();
    BTrafficLightServerDevice device2 = new BTrafficLightServerDevice();

    device.setIntersectionId("a");
    device1.setIntersectionId("b");
    device2.setIntersectionId("c");

    network.add("device", device);
    network.add("device1", device1);
    network.add("device2", device2);

    Assert.assertTrue(network.getDevice("a").isPresent(), "getDevice should be able to get all devices");
    Assert.assertTrue(network.getDevice("b").isPresent(), "getDevice should be able to get all devices");
    Assert.assertTrue(network.getDevice("c").isPresent(), "getDevice should be able to get all devices");
  }
}
