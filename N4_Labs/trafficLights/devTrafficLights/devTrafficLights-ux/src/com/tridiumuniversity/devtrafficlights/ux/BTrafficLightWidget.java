package com.tridiumuniversity.devtrafficlights.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType(
        agent=@AgentOn(types="devTrafficLights:TrafficLight")
)
@NiagaraSingleton

public final class BTrafficLightWidget extends BSingleton implements BIJavaScript, BIFormFactorMax
        {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devtrafficlights.ux.BTrafficLightWidget(3669802121)1.0$ @*/
/* Generated Tue Feb 11 14:32:05 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  public static final BTrafficLightWidget INSTANCE = new BTrafficLightWidget();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    private BTrafficLightWidget()
    {

    }
            public JsInfo getJsInfo(Context cx) { return jsInfo; }

    private static final JsInfo jsInfo =
                    JsInfo.make(
                            BOrd.make("module://devTrafficLights/rc/TrafficLightWidget.js"),
                            BDevTrafficLightsJsBuild.TYPE
                    );
}
