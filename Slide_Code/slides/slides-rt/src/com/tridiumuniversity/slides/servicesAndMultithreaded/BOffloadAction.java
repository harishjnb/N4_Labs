/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraAction(
  name = "slowAction"
)
@NiagaraAction(
  name = "fastAction"
)
public class BOffloadAction
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BOffloadAction(1596137247)1.0$ @*/
/* Generated Tue Oct 10 09:01:05 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "slowAction"

  /**
   * Slot for the {@code slowAction} action.
   * @see #slowAction()
   */
  public static final Action slowAction = newAction(0, null);

  /**
   * Invoke the {@code slowAction} action.
   * @see #slowAction
   */
  public void slowAction() { invoke(slowAction, null, null); }

  //endregion Action "slowAction"

  //region Action "fastAction"

  /**
   * Slot for the {@code fastAction} action.
   * @see #fastAction()
   */
  public static final Action fastAction = newAction(0, null);

  /**
   * Invoke the {@code fastAction} action.
   * @see #fastAction
   */
  public void fastAction() { invoke(fastAction, null, null); }

  //endregion Action "fastAction"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BOffloadAction.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doSlowAction(Context cx)
  {
    expensiveOperationDone = false;
    expensiveOperation(cx);
  }

  public void doFastAction(Context cx)
  {
    expensiveOperationDone = false;
    Thread thread = new Thread(() -> expensiveOperation(cx), "expensiveOperationThread");
    thread.start();
  }

  public long getDelay()
  {
    return delay;
  }

  public void setDelay(long delay)
  {
    this.delay = delay;
  }

  public boolean isExpensiveOperationDone()
  {
    return expensiveOperationDone;
  }

  private void expensiveOperation(Context cx)
  {
    try
    {
      Thread.sleep(getDelay());
    }
    catch (InterruptedException ex)
    {
      // ignore for this example
    }
    finally
    {
      expensiveOperationDone = true;
    }
  }

  private long delay = 10000;
  private boolean expensiveOperationDone;
}
