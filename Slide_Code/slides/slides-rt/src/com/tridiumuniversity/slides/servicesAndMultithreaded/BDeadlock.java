/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "number",
  type = "int",
  defaultValue = "0"
)
@NiagaraAction(
  name = "increment"
)
public class BDeadlock
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BDeadlock(1061812577)1.0$ @*/
/* Generated Tue Oct 10 09:29:05 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "number"

  /**
   * Slot for the {@code number} property.
   * @see #getNumber
   * @see #setNumber
   */
  public static final Property number = newProperty(0, 0, null);

  /**
   * Get the {@code number} property.
   * @see #number
   */
  public int getNumber() { return getInt(number); }

  /**
   * Set the {@code number} property.
   * @see #number
   */
  public void setNumber(int v) { setInt(number, v, null); }

  //endregion Property "number"

  //region Action "increment"

  /**
   * Slot for the {@code increment} action.
   * @see #increment()
   */
  public static final Action increment = newAction(0, null);

  /**
   * Invoke the {@code increment} action.
   * @see #increment
   */
  public void increment() { invoke(increment, null, null); }

  //endregion Action "increment"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDeadlock.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doIncrement(Context cx)
  {
    Thread t = new Thread(() -> doIncrementInternal(cx), "increment");
    t.start();
  }

  private synchronized void doIncrementInternal(Context cx)
  {
    setNumber(getNumber() + 1);
  }
}
