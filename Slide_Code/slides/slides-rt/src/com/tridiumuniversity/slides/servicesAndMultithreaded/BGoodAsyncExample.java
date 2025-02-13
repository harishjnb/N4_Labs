/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.IFuture;

@NiagaraType
@NiagaraAction(
  name = "asyncAction",
  flags = Flags.ASYNC
)
public class BGoodAsyncExample
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BGoodAsyncExample(2573909903)1.0$ @*/
/* Generated Tue Oct 10 09:05:54 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "asyncAction"

  /**
   * Slot for the {@code asyncAction} action.
   * @see #asyncAction()
   */
  public static final Action asyncAction = newAction(Flags.ASYNC, null);

  /**
   * Invoke the {@code asyncAction} action.
   * @see #asyncAction
   */
  public void asyncAction() { invoke(asyncAction, null, null); }

  //endregion Action "asyncAction"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BGoodAsyncExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doAsyncAction(Context cx)
  {
    expensiveOperationDone = false;
    expensiveOperation(cx);
  }

  @Override
  public IFuture post(Action action, BValue value, Context cx)
  {
    if (asyncAction.equals(action))
    {
      Thread t = new Thread(() -> doAsyncAction(cx), "expensiveOperationThread");
      t.start();
    }
    return null;
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
