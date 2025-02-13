/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.point;

import javax.baja.control.BControlPoint;
import javax.baja.driver.point.BReadWriteMode;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.status.*;
import javax.baja.sys.*;

import com.tridium.driver.util.DrUtil;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.point.BNProxyExt;

import com.tridiumuniversity.devTrafficLights.BTrafficLightState;
import com.tridiumuniversity.trafficLightDriver.*;
import com.tridiumuniversity.trafficLightDriver.message.req.TrafficLightDriverSetLightReq;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BTrafficLightDriverProxyExt
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
@NiagaraProperty(
        name="lightId",
        type="String",
        defaultValue="N"
)
/*
Override ProxyExt default status to clear stale state if needed
@NiagaraProperty(
  name = "status",
  type = "BStatus",
  defaultValue = "BStatus.ok",
  flags = Flags.READONLY | Flags.TRANSIENT,
  override = true
)
*/
public class BTrafficLightDriverProxyExt
  extends BNProxyExt
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.point.BTrafficLightDriverProxyExt(1146634663)1.0$ @*/
/* Generated Wed Feb 12 15:07:48 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "lightId"

  /**
   * Slot for the {@code lightId} property.
   * @see #getLightId
   * @see #setLightId
   */
  public static final Property lightId = newProperty(0, "N", null);

  /**
   * Get the {@code lightId} property.
   * @see #lightId
   */
  public String getLightId() { return getString(lightId); }

  /**
   * Set the {@code lightId} property.
   * @see #lightId
   */
  public void setLightId(String v) { setString(lightId, v, null); }

  //endregion Property "lightId"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverProxyExt.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrafficLightDriverNetwork.
   */
  public final BTrafficLightDriverNetwork getTrafficLightDriverNetwork()
  {
    return (BTrafficLightDriverNetwork) getNetwork();
  }

  /**
   * Get the device cast to a BTrafficLightDriverDevice.
   */
  public final BTrafficLightDriverDevice getBTrafficLightDriverDevice()
  {
    return (BTrafficLightDriverDevice) DrUtil.getParent(this, BTrafficLightDriverDevice.TYPE);
  }

  /**
   * Get the point device ext cast to a BTrafficLightDriverPointDeviceExt.
   */
  public final BTrafficLightDriverPointDeviceExt getTrafficLightDriverPointDeviceExt()
  {
    return (BTrafficLightDriverPointDeviceExt) getDeviceExt();
  }

////////////////////////////////////////////////////////////////
// ProxyExt
////////////////////////////////////////////////////////////////
@Override
public void readSubscribed(Context cx)
{
  ((BTrafficLightDriverDevice)getDevice()).pointSubscribed(this);
}

  @Override
  public void readUnsubscribed(Context cx)
  {
    ((BTrafficLightDriverDevice)getDevice()).pointUnsubscribed(this);
  }

  @Override
  public boolean write(Context cx)
  {
    BControlPoint point = getParentPoint();
    if (!point.isWritablePoint())
    {
      return false;
    }

    // if our value status is null, we have nothing to write
    BStatusValue statusValue = getWriteValue();
    if(statusValue.getStatus().isNull())
    {
      return false;
    }

    BTrafficLightState state = null;
    if (isEnum())
    {
      BDynamicEnum value = ((BStatusEnum) statusValue).getValue();
      state = BTrafficLightState.make(value.getOrdinal());
    }
    else if (isNumeric())
    {
      int value = (int)((BStatusNumeric) statusValue).getValue();
      state = BTrafficLightState.make(value);
    }
    else if (isString())
    {
      String value = ((BStatusString) statusValue).getValue();
      state = BTrafficLightState.make(value);
    }

    // create our write request
    BIpAddress ipAddress = getTrafficLightDriverNetwork().getIpAddress();
    String intersectionId = getBTrafficLightDriverDevice().getIntersectionId();
    TrafficLightDriverSetLightReq request =
            new TrafficLightDriverSetLightReq(ipAddress, intersectionId, getLightId(), state);

    NMessage response;
    try
    {
      response = getTrafficLightDriverNetwork().tcomm().sendRequest(request);
    }
    catch (Exception ex)
    {
      log.log(Level.WARNING,
              "Write to point " + getLightId() + " on device " + intersectionId + " at " + ipAddress + " failed", ex);
      writeFail(ex.getMessage());
      return false;
    }

    if (!(response instanceof com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverSetLightResp))
    {
      log.warning("Write response from point " + getLightId() + " on device " + intersectionId + " at " + ipAddress + " has unexpected type");
      writeFail("Response has unexpected type");
      return false;
    }

    com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverSetLightResp setLightResp = (com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverSetLightResp)response;
    if(setLightResp.responseErrorOccurred())
    {
      writeFail("Write failed");
    }
    else
    {
      writeOk((BStatusValue) statusValue.newCopy());
    }

    //no writes pending, so return false
    return false;
  }


  /**
   * Return the device type.
   */
  public Type getDeviceExtType()
  {
    return BTrafficLightDriverPointDeviceExt.TYPE;
  }

  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO
    return BReadWriteMode.readWrite;
  }

  private static final Logger log = Logger.getLogger("trafficLightDriver");

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
}
