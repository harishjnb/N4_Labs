/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BTrafficLightServerDeviceFolder is a folder for BTrafficLightServerDevice.
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
@NiagaraType
public class BTrafficLightServerDeviceFolder
  extends BNDeviceFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.BTrafficLightServerDeviceFolder(2979906276)1.0$ @*/
/* Generated Fri Aug 25 11:08:20 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerDeviceFolder.class);

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
   * @return true if parent is BTrafficLightServerNetwork or BTrafficLightServerDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BTrafficLightServerNetwork ||
           parent instanceof BTrafficLightServerDeviceFolder;
  }
}
