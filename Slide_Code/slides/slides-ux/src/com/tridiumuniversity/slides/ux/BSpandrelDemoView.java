/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ux;

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

@NiagaraType(
  agent = @AgentOn(types = "slides:Demo")
)
@NiagaraSingleton
public class BSpandrelDemoView extends BSingleton implements BIJavaScript, BIFormFactorMax
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ux.BSpandrelDemoView(871993280)1.0$ @*/
/* Generated Tue Oct 24 11:32:28 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BSpandrelDemoView INSTANCE = new BSpandrelDemoView();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpandrelDemoView.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private BSpandrelDemoView()
  {
  }

  @Override
  public JsInfo getJsInfo(Context cx)
  {
    return jsInfo;
  }

  private static final JsInfo jsInfo = JsInfo.make(
    BOrd.make("module://slides/rc/spandrel/DemoView.js"),
    BSlidesJsBuild.TYPE
  );
}
