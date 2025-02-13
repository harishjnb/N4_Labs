/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.learn;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.registry.TypeInfo;
import javax.baja.sys.BComponent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.discover.BNDiscoveryLeaf;

import com.tridium.ndriver.util.SfUtil;
import com.tridiumuniversity.trafficLightDriver.BTrafficLightDriverDevice;
import javax.baja.sys.Property;

/**
 * BTrafficLightDriverDeviceDiscoveryLeaf is container class for Device elements to display in
 * Device discovery pane and pass to new Device callback.
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
@NiagaraProperty(
        name="intersectionId",
        type="String",
        defaultValue="\"\"",
        facets=@Facet("SfUtil.incl()")
)
public class BTrafficLightDriverDeviceDiscoveryLeaf
  extends BNDiscoveryLeaf
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.learn.BTrafficLightDriverDeviceDiscoveryLeaf(4032158471)1.0$ @*/
/* Generated Thu Feb 13 14:40:21 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "intersectionId"

  /**
   * Slot for the {@code intersectionId} property.
   * @see #getIntersectionId
   * @see #setIntersectionId
   */
  public static final Property intersectionId = newProperty(0, "", SfUtil.incl());

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
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverDeviceDiscoveryLeaf.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public BTrafficLightDriverDeviceDiscoveryLeaf()
{
}

  public BTrafficLightDriverDeviceDiscoveryLeaf(String intersectionId)
  {
    setIntersectionId(intersectionId);
  }

  /* Called when adding new object based on this discovery leaf.   */
  public TypeInfo[] getValidDatabaseTypes()
  {
    return new TypeInfo[] { BTrafficLightDriverDevice.TYPE.getTypeInfo() };
  }

  /**
   * Override to specify the default name when adding this discovery object
   * to the station.
   */
  public String getDiscoveryName()
  {
    return "Device " + getIntersectionId();
  }

  /* Called when adding new object based on this discovery leaf.   */
  public void updateTarget(BComponent target)
  {
    BTrafficLightDriverDevice device = (BTrafficLightDriverDevice)target;
    device.setIntersectionId(getIntersectionId());
  }

  /**
   * Return true if the specified component is an existing representation
   * of this discovery object.
   */
  public boolean isExisting(BComponent target)
  {
    if (!(target instanceof BTrafficLightDriverDevice))
    {
      return false;
    }

    BTrafficLightDriverDevice device = (BTrafficLightDriverDevice)target;
    return device.getIntersectionId().equalsIgnoreCase(getIntersectionId());
  }
}
