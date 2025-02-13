/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BFacets;
import javax.baja.sys.BRelTime;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
/**
 * This JavaDoc comment will be included in the slot code.
 */
@NiagaraProperty(
  name = "time",
  type = "baja:RelTime",
  defaultValue = "BRelTime.makeSeconds(10)",
  flags = Flags.HIDDEN,
  facets = {
    @Facet(name = "BFacets.MIN", value = "BRelTime.makeSeconds(1)"),
    @Facet(name = "BFacets.MAX", value = "BRelTime.makeSeconds(100)")
  }
  )
public class BPropertyExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BPropertyExample(2165957801)1.0$ @*/
/* Generated Fri Oct 06 11:39:01 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "time"

  /**
   * Slot for the {@code time} property.
   * This JavaDoc comment will be included in the slot code.
   * @see #getTime
   * @see #setTime
   */
  public static final Property time = newProperty(Flags.HIDDEN, BRelTime.makeSeconds(10), BFacets.make(BFacets.make(BFacets.MIN, BRelTime.makeSeconds(1)), BFacets.make(BFacets.MAX, BRelTime.makeSeconds(100))));

  /**
   * Get the {@code time} property.
   * This JavaDoc comment will be included in the slot code.
   * @see #time
   */
  public BRelTime getTime() { return (BRelTime)get(time); }

  /**
   * Set the {@code time} property.
   * This JavaDoc comment will be included in the slot code.
   * @see #time
   */
  public void setTime(BRelTime v) { set(time, v, null); }

  //endregion Property "time"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPropertyExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
