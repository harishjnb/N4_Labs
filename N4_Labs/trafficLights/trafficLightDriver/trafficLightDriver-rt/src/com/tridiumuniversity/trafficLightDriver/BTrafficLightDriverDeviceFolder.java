/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BTrafficLightDriverDeviceFolder is a folder for BTrafficLightDriverDevice.
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
public class BTrafficLightDriverDeviceFolder
  extends BNDeviceFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.BTrafficLightDriverDeviceFolder(2979906276)1.0$ @*/
/* Generated Wed Feb 12 11:41:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverDeviceFolder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrafficLightDriverNetwork.
   *
   * @return network as a BTrafficLightDriverNetwork.
   */
  public final BTrafficLightDriverNetwork getTrafficLightDriverNetwork()
  {
    return (BTrafficLightDriverNetwork) getNetwork();
  }

  /**
   * @return true if parent is BTrafficLightDriverNetwork or BTrafficLightDriverDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BTrafficLightDriverNetwork ||
           parent instanceof BTrafficLightDriverDeviceFolder;
  }
}
