/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.job.BJob;
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
  name = "steps",
  type = "int",
  defaultValue = "1"
)
@NiagaraProperty(
  name = "pi",
  type = "double",
  defaultValue = "0"
)
@NiagaraAction(
  name = "startJob"
)
public class BCalculatePi extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BCalculatePi(4080376337)1.0$ @*/
/* Generated Tue Oct 10 09:51:04 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "steps"

  /**
   * Slot for the {@code steps} property.
   * @see #getSteps
   * @see #setSteps
   */
  public static final Property steps = newProperty(0, 1, null);

  /**
   * Get the {@code steps} property.
   * @see #steps
   */
  public int getSteps() { return getInt(steps); }

  /**
   * Set the {@code steps} property.
   * @see #steps
   */
  public void setSteps(int v) { setInt(steps, v, null); }

  //endregion Property "steps"

  //region Property "pi"

  /**
   * Slot for the {@code pi} property.
   * @see #getPi
   * @see #setPi
   */
  public static final Property pi = newProperty(0, 0, null);

  /**
   * Get the {@code pi} property.
   * @see #pi
   */
  public double getPi() { return getDouble(pi); }

  /**
   * Set the {@code pi} property.
   * @see #pi
   */
  public void setPi(double v) { setDouble(pi, v, null); }

  //endregion Property "pi"

  //region Action "startJob"

  /**
   * Slot for the {@code startJob} action.
   * @see #startJob()
   */
  public static final Action startJob = newAction(0, null);

  /**
   * Invoke the {@code startJob} action.
   * @see #startJob
   */
  public void startJob() { invoke(startJob, null, null); }

  //endregion Action "startJob"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCalculatePi.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doStartJob(Context cx)
  {
    BJob job = new BCalculatePiJob(getSteps(), this::setPi);
    job.submit(cx);
  }
}
