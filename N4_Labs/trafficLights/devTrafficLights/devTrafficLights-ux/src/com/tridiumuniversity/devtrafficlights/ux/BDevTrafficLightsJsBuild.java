package com.tridiumuniversity.devtrafficlights.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BJsBuild;

@NiagaraType
@NiagaraSingleton
public final class BDevTrafficLightsJsBuild extends BJsBuild
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devtrafficlights.ux.BDevTrafficLightsJsBuild(2747097003)1.0$ @*/
/* Generated Mon Feb 10 17:35:08 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  public static final BDevTrafficLightsJsBuild INSTANCE = new BDevTrafficLightsJsBuild();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDevTrafficLightsJsBuild.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  private BDevTrafficLightsJsBuild()
  {
    super("devTrafficLights", BOrd.make("module://devTrafficLights/rc/devTrafficLights.built.min.js"));
  }
}
