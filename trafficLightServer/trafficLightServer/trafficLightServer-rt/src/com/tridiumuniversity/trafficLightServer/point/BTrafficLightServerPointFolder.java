/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.point;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.point.BNPointFolder;

import com.tridiumuniversity.trafficLightServer.*;

/**
 * BTrafficLightServerPointFolder
 *
 * @author   tridiumuniversity on 25 Aug 2023
 */
@NiagaraType
public class BTrafficLightServerPointFolder
  extends BNPointFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.point.BTrafficLightServerPointFolder(2979906276)1.0$ @*/
/* Generated Fri Aug 25 11:08:21 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerPointFolder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Access
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

  /**
   * Get the device cast to a BTrafficLightServerDevice.
   *
   * @return device as a BTrafficLightServerDevice.
   */
  public final BTrafficLightServerDevice getTrafficLightServerDevice()
  {
    return (BTrafficLightServerDevice) getDevice();
  }
}
