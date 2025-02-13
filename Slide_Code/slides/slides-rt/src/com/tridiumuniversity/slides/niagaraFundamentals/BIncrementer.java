/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BInteger;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraAction(
  name = "increment",
  parameterType = "BInteger",
  defaultValue = "BInteger.make(-1)",
  returnType = "BInteger"
)
public class BIncrementer
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BIncrementer(1406857678)1.0$ @*/
/* Generated Tue Jul 23 12:04:40 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Action "increment"

  /**
   * Slot for the {@code increment} action.
   * @see #increment(BInteger parameter)
   */
  public static final Action increment = newAction(0, BInteger.make(-1), null);

  /**
   * Invoke the {@code increment} action.
   * @see #increment
   */
  public BInteger increment(BInteger parameter) { return (BInteger)invoke(increment, parameter, null); }

  //endregion Action "increment"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BIncrementer.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BInteger doIncrement(BInteger number, Context cx)
  {
    return BInteger.make(number.getInt() + 1);
  }
}
