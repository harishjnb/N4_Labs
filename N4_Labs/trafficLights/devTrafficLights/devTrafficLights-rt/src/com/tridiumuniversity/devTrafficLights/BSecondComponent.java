/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.devTrafficLights;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "timeExecuted",
        type = "BAbsTime",
        defaultValue = "BAbsTime.DEFAULT",
        flags = Flags.SUMMARY
)
@NiagaraAction(
        name = "execute",
        flags = Flags.SUMMARY
)
public class BSecondComponent extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BSecondComponent(3398277159)1.0$ @*/
/* Generated Mon Feb 03 14:04:10 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "timeExecuted"

  /**
   * Slot for the {@code timeExecuted} property.
   * @see #getTimeExecuted
   * @see #setTimeExecuted
   */
  public static final Property timeExecuted = newProperty(Flags.SUMMARY, BAbsTime.DEFAULT, null);

  /**
   * Get the {@code timeExecuted} property.
   * @see #timeExecuted
   */
  public BAbsTime getTimeExecuted() { return (BAbsTime)get(timeExecuted); }

  /**
   * Set the {@code timeExecuted} property.
   * @see #timeExecuted
   */
  public void setTimeExecuted(BAbsTime v) { set(timeExecuted, v, null); }

  //endregion Property "timeExecuted"

  //region Action "execute"

  /**
   * Slot for the {@code execute} action.
   * @see #execute()
   */
  public static final Action execute = newAction(Flags.SUMMARY, null);

  /**
   * Invoke the {@code execute} action.
   * @see #execute
   */
  public void execute() { invoke(execute, null, null); }

  //endregion Action "execute"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSecondComponent.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public void doExecute()
    {
        System.out.println("Hello, World 2nd component!");
        setTimeExecuted(BAbsTime.now());
    }
}
