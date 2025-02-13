/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BCssResource;

@NiagaraType
@NiagaraSingleton
public class BSlidesCssResource
  extends BCssResource
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ux.BSlidesCssResource(2747097003)1.0$ @*/
/* Generated Fri Oct 20 10:24:06 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BSlidesCssResource INSTANCE = new BSlidesCssResource();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSlidesCssResource.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private BSlidesCssResource()
  {
    super(BOrd.make("module://slides/rc/slides.css"));
  }
}
