/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BJsBuild;

@NiagaraType
@NiagaraSingleton
public final class BSlidesJsBuild extends BJsBuild
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ux.BSlidesJsBuild(2747097003)1.0$ @*/
/* Generated Thu Jul 25 11:17:48 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  public static final BSlidesJsBuild INSTANCE = new BSlidesJsBuild();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSlidesJsBuild.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  private BSlidesJsBuild()
  {
    super(
      "slides",
      BOrd.make("module://slides/rc/slides.built.min.js"),
      BSlidesCssResource.TYPE
    );
  }
}
