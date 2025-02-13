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
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType(
  agent = @AgentOn(types = "slides:DocumentationExample")
)
@NiagaraSingleton
public class BDocumentationExampleView
  extends BSingleton implements BIJavaScript, BIFormFactorMax
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ux.BDocumentationExampleView(3880584804)1.0$ @*/
/* Generated Thu Jul 25 14:58:42 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  public static final BDocumentationExampleView INSTANCE = new BDocumentationExampleView();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDocumentationExampleView.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  private BDocumentationExampleView()
  {
  }

  @Override
  public JsInfo getJsInfo(Context cx)
  {
    return JS_INFO;
  }

  private static final JsInfo JS_INFO = JsInfo.make(
    BOrd.make("module://slides/rc/DocumentationExampleView.js"),
    BSlidesJsBuild.TYPE
  );
}
