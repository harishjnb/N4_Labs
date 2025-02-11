package com.tridiumuniversity.devtrafficlights.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

@NiagaraType(agent = @AgentOn(types="devTrafficLights:NumericWritableEditor"))
@NiagaraSingleton
public final class BNumericWritableEditorWidget
    extends BSingleton
    implements BIJavaScript, BIFormFactorMax
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devtrafficlights.ux.BNumericWritableEditorWidget(748222546)1.0$ @*/
/* Generated Mon Feb 10 17:35:08 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  public static final BNumericWritableEditorWidget INSTANCE = new BNumericWritableEditorWidget();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNumericWritableEditorWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  private BNumericWritableEditorWidget() {}
  public JsInfo getJsInfo(Context cx) { return jsInfo; }

  private static final JsInfo jsInfo =
      JsInfo.make(
        BOrd.make("module://devTrafficLights/rc/NumericWritableEditorWidget.js"),
        BDevTrafficLightsJsBuild.TYPE
      );
}
