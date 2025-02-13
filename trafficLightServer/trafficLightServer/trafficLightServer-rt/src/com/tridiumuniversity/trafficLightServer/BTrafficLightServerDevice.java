/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;
import com.tridiumuniversity.trafficLightServer.point.BTrafficLightServerPointDeviceExt;

import javax.baja.control.BEnumWritable;
import javax.baja.driver.util.BPollFrequency;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import java.util.Optional;

/**
 * BTrafficLightServerDevice models a single device
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
@NiagaraType
@NiagaraProperty(
  name = "pollFrequency",
  type = "BPollFrequency",
  defaultValue = "BPollFrequency.normal"
)
// Add facet to include following in auto manager view
@NiagaraProperty(
  name = "status",
  type = "BStatus",
  defaultValue = "BStatus.ok",
  flags = Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE,
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT_READONLY)"),
  override = true
)
@NiagaraProperty(
  name = "points",
  type = "BTrafficLightServerPointDeviceExt",
  defaultValue = "new BTrafficLightServerPointDeviceExt()"
)
@NiagaraProperty(
  name = "intersectionId",
  type = "String",
  defaultValue = ""
)
public class BTrafficLightServerDevice
  extends BNDevice
  implements BINPollable
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice(1072852304)1.0$ @*/
/* Generated Fri Aug 25 11:19:18 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "pollFrequency"

  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);

  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }

  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

  //endregion Property "pollFrequency"

  //region Property "status"

  /**
   * Slot for the {@code status} property.
   *  Add facet to include following in auto manager view
   * @see #getStatus
   * @see #setStatus
   */
  public static final Property status = newProperty(Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

  //endregion Property "status"

  //region Property "points"

  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BTrafficLightServerPointDeviceExt(), null);

  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BTrafficLightServerPointDeviceExt getPoints() { return (BTrafficLightServerPointDeviceExt)get(points); }

  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BTrafficLightServerPointDeviceExt v) { set(points, v, null); }

  //endregion Property "points"

  //region Property "intersectionId"

  /**
   * Slot for the {@code intersectionId} property.
   * @see #getIntersectionId
   * @see #setIntersectionId
   */
  public static final Property intersectionId = newProperty(0, "", null);

  /**
   * Get the {@code intersectionId} property.
   * @see #intersectionId
   */
  public String getIntersectionId() { return getString(intersectionId); }

  /**
   * Set the {@code intersectionId} property.
   * @see #intersectionId
   */
  public void setIntersectionId(String v) { setString(intersectionId, v, null); }

  //endregion Property "intersectionId"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerDevice.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////

  /**
   * Returns the network type that the device runs on.
   *
   * @return Type object representing the network
   */
  @Override
  public Type getNetworkType()
  {
    return BTrafficLightServerNetwork.TYPE;
  }

////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////

  /**
   *
   */
  public void doPing()
  {
    // TODO - add ping implementation
    // if()
    pingOk();
    // else
    //  pingFail("not receiving response from device ");
  }


////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {
    // TODO add poll support
  }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrafficLightServerNetwork.
   *
   * @return network as a BTrafficLightServerNetwork.
   */
  public final BTrafficLightServerNetwork getTrafficLightServerNetwork()
  {
    return (BTrafficLightServerNetwork) getNetwork();
  }

  public Optional<BEnumWritable> getPoint(String lightId)
  {
    BTrafficLightServerPointDeviceExt points = getPoints();

    // lightIds are case-insensitive
    BEnumWritable point = (BEnumWritable)points.get(lightId.toLowerCase());
    if (point != null)
    {
      return Optional.of(point);
    }
    return Optional.ofNullable((BEnumWritable)points.get(lightId.toUpperCase()));
  }
}
