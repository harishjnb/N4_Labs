/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.learn;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.registry.TypeInfo;
import javax.baja.sys.BComponent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.discover.BNDiscoveryLeaf;

import com.tridiumuniversity.trafficLightDriver.BTrafficLightDriverDevice;

/**
 * BTrafficLightDriverDeviceDiscoveryLeaf is container class for Device elements to display in
 * Device discovery pane and pass to new Device callback.
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
public class BTrafficLightDriverDeviceDiscoveryLeaf
  extends BNDiscoveryLeaf
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.learn.BTrafficLightDriverDeviceDiscoveryLeaf(2979906276)1.0$ @*/
/* Generated Wed Feb 12 11:41:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

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
    //
    // TODO - specify the default name for discovery entry
    //
    return null;
  }


  /* Called when adding new object based on this discovery leaf.   */
  public void updateTarget(BComponent target)
  {
    //
    // TODO - initialize values in new Device
    //
  }

  /**
   * Return true if the specified component is an existing representation
   * of this discovery object.
   */
  public boolean isExisting(BComponent target)
  {
    //
    // TODO - return true if specified component represents this leaf
    //

    return false;
  }
}
