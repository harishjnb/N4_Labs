/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BInteger;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
/**
 * This JavaDoc comment will be included with the slot code
 */
@NiagaraAction(
  name = "computeValue",
  flags = Flags.ASYNC,
  parameterType = "BInteger",
  defaultValue = "BInteger.make(0)",
  returnType = "BInteger"
)
public class BActionExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BActionExample(72460392)1.0$ @*/
/* Generated Fri Oct 06 11:41:40 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "computeValue"

  /**
   * Slot for the {@code computeValue} action.
   * This JavaDoc comment will be included with the slot code
   * @see #computeValue(BInteger parameter)
   */
  public static final Action computeValue = newAction(Flags.ASYNC, BInteger.make(0), null);

  /**
   * Invoke the {@code computeValue} action.
   * This JavaDoc comment will be included with the slot code
   * @see #computeValue
   */
  public BInteger computeValue(BInteger parameter) { return (BInteger)invoke(computeValue, parameter, null); }

  //endregion Action "computeValue"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BActionExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BInteger doComputeValue(BInteger integer, Context cx)
  {
    return BInteger.DEFAULT;
  }
}
