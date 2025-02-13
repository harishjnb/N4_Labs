/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BRelTime;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "time",
  type = "baja:RelTime",
  defaultValue = "BRelTime.makeSeconds(10)"
)
public class BTimeHolder
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BTimeHolder(3331454786)1.0$ @*/
/* Generated Fri Oct 06 14:32:48 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "time"

  /**
   * Slot for the {@code time} property.
   * @see #getTime
   * @see #setTime
   */
  public static final Property time = newProperty(0, BRelTime.makeSeconds(10), null);

  /**
   * Get the {@code time} property.
   * @see #time
   */
  public BRelTime getTime() { return (BRelTime)get(time); }

  /**
   * Set the {@code time} property.
   * @see #time
   */
  public void setTime(BRelTime v) { set(time, v, null); }

  //endregion Property "time"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTimeHolder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
