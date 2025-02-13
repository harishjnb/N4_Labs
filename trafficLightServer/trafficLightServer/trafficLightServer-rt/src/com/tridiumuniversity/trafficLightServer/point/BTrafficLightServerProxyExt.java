/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.point;

import javax.baja.control.BEnumWritable;
import javax.baja.driver.point.BReadWriteMode;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice;
import com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetwork;

import com.tridium.driver.util.DrUtil;
import com.tridium.ndriver.point.BNProxyExt;

/**
 * BTrafficLightServerProxyExt
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
@NiagaraType
public class BTrafficLightServerProxyExt
  extends BNProxyExt
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.point.BTrafficLightServerProxyExt(2979906276)1.0$ @*/
/* Generated Fri Aug 25 11:08:21 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerProxyExt.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrafficLightServerNetwork.
   */
  public final BTrafficLightServerNetwork getTrafficLightServerNetwork()
  {
    return (BTrafficLightServerNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BTrafficLightServerDevice.
   */
  public final BTrafficLightServerDevice getBTrafficLightServerDevice()
  {
    return (BTrafficLightServerDevice)DrUtil.getParent(this, BTrafficLightServerDevice.TYPE);
  }

  /**
   * Get the point device ext cast to a BTrafficLightServerPointDeviceExt.
   */
  public final BTrafficLightServerPointDeviceExt getTrafficLightServerPointDeviceExt()
  {
    return (BTrafficLightServerPointDeviceExt)getDeviceExt();
  }

  ////////////////////////////////////////////////////////////////
// ProxyExt
////////////////////////////////////////////////////////////////
  public void readSubscribed(Context cx)
    throws Exception
  {
    // These "proxy" points are simulated only, so we don't need to handle subscription
    readOk(new BStatusEnum(((BEnumWritable)getParentPoint()).getOut().getEnum(), BStatus.ok));
  }

  public void readUnsubscribed(Context cx)
    throws Exception
  {
    // These "proxy" points are simulated only, so we don't need to handle subscription
  }

  public boolean write(Context cx)
    throws Exception
  {
    // These "proxy" points are simulated only, so we don't need to handle writing
    writeOk(getWriteValue());
    return false;
  }

  /**
   * Return the device type.
   */
  public Type getDeviceExtType()
  {
    return BTrafficLightServerPointDeviceExt.TYPE;
  }

  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    return BReadWriteMode.readWrite;
  }

  public boolean isBoolean()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusBoolean;
  }

  public boolean isNumeric()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusNumeric;
  }

  public boolean isString()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusString;
  }

  public boolean isEnum()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusEnum;
  }

  @Override
  public void changed(Property p, Context cx)
  {
    if (!isRunning())
    {
      return;
    }

    // Simulate reading in a value after it's been written
    if (writeValue.equals(p))
    {
      readOk(getWriteValue());
    }
  }
}
