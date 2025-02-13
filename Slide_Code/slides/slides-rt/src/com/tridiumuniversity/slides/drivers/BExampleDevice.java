/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.drivers;

import static com.tridium.ndriver.util.SfUtil.MGR_UNSEEN;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

/**
 * This class won't do much good outside of a driver
 */
@NiagaraType
@NiagaraProperty(
  name = "deviceId",
  type = "int",
  defaultValue = "0",
  facets = {
    @Facet("SfUtil.incl()")
  }
)
@NiagaraProperty(
  name = "deviceDetails",
  type = "String",
  defaultValue = "",
  facets = {
    @Facet("SfUtil.incl(MGR_UNSEEN)")
  }
)
public class BExampleDevice
  extends BNDevice implements BINPollable
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.drivers.BExampleDevice(4189466365)1.0$ @*/
/* Generated Tue Oct 10 13:34:48 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "deviceId"

  /**
   * Slot for the {@code deviceId} property.
   * @see #getDeviceId
   * @see #setDeviceId
   */
  public static final Property deviceId = newProperty(0, 0, SfUtil.incl());

  /**
   * Get the {@code deviceId} property.
   * @see #deviceId
   */
  public int getDeviceId() { return getInt(deviceId); }

  /**
   * Set the {@code deviceId} property.
   * @see #deviceId
   */
  public void setDeviceId(int v) { setInt(deviceId, v, null); }

  //endregion Property "deviceId"

  //region Property "deviceDetails"

  /**
   * Slot for the {@code deviceDetails} property.
   * @see #getDeviceDetails
   * @see #setDeviceDetails
   */
  public static final Property deviceDetails = newProperty(0, "", SfUtil.incl(MGR_UNSEEN));

  /**
   * Get the {@code deviceDetails} property.
   * @see #deviceDetails
   */
  public String getDeviceDetails() { return getString(deviceDetails); }

  /**
   * Set the {@code deviceDetails} property.
   * @see #deviceDetails
   */
  public void setDeviceDetails(String v) { setString(deviceDetails, v, null); }

  //endregion Property "deviceDetails"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BExampleDevice.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public Type getNetworkType()
  {
    return null;
  }

  @Override
  public void doPing() throws Exception
  {
  }

  @Override
  public void doPoll()
  {
  }

  @Override
  public BPollFrequency getPollFrequency()
  {
    return null;
  }
}
