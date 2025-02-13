/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.point;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.discover.BNDiscoveryPreferences;

/**
 * BTrafficLightDriverPointDiscoveryPreferences controls the type of discovery leafs using during
 * point discovery for trafficLightDriver
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
public class BTrafficLightDriverPointDiscoveryPreferences
  extends BNDiscoveryPreferences
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.point.BTrafficLightDriverPointDiscoveryPreferences(2979906276)1.0$ @*/
/* Generated Wed Feb 12 11:41:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverPointDiscoveryPreferences.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BTrafficLightDriverPointDiscoveryPreferences()
  {
  }

  public Type getDiscoveryLeafType()
  {
    return BTrafficLightDriverPointDiscoveryLeaf.TYPE;
  }
}
