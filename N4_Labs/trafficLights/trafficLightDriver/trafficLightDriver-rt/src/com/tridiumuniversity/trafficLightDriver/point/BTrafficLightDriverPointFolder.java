/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.point;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.point.BNPointFolder;

import com.tridiumuniversity.trafficLightDriver.*;

/**
 * BTrafficLightDriverPointFolder
 *
 * @author   tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
public class BTrafficLightDriverPointFolder
  extends BNPointFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.point.BTrafficLightDriverPointFolder(2979906276)1.0$ @*/
/* Generated Wed Feb 12 11:41:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverPointFolder.class);

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
   * Get the device cast to a BTrafficLightDriverDevice.
   *
   * @return device as a BTrafficLightDriverDevice.
   */
  public final BTrafficLightDriverDevice getTrafficLightDriverDevice()
  {
    return (BTrafficLightDriverDevice) getDevice();
  }
}
