package com.tridiumuniversity.slides.servicesAndMultithreaded;

import java.util.logging.Logger;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BFacets;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Action;
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
  name = "syncAction"
)
@NiagaraAction(
  name = "asyncAction",
  flags = Flags.ASYNC
)
public class BThreadLogger
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BThreadLogger(2150319501)1.0$ @*/
/* Generated Tue Nov 26 13:19:53 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

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

  //region Action "syncAction"

  /**
   * Slot for the {@code syncAction} action.
   * @see #syncAction()
   */
  public static final Action syncAction = newAction(0, null);

  /**
   * Invoke the {@code syncAction} action.
   * @see #syncAction
   */
  public void syncAction() { invoke(syncAction, null, null); }

  //endregion Action "syncAction"

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
  public static final Type TYPE = Sys.loadType(BThreadLogger.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void started()
  {
    logger.info("started() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void descendantsStarted()
  {
    logger.info("descendantsStarted() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void stationStarted()
  {
    logger.info("stationStarted() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void atSteadyState()
  {
    logger.info("atSteadyState() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void stopped()
  {
    logger.info("stopped() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void descendantsStopped()
  {
    logger.info("descendantsStopped() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void changed(Property p, Context cx)
  {
    logger.info("changed() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void checkAdd(String name, BValue value, int flags, BFacets facets, Context cx)
  {
    logger.info("checkAdd() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void added(Property p, Context cx)
  {
    logger.info("added() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void checkRemove(Property property, Context cx)
  {
    logger.info("checkRemove() called on thread " + Thread.currentThread().getName());
  }

  @Override
  public void removed(Property p, BValue old, Context cx)
  {
    logger.info("removed() called on thread " + Thread.currentThread().getName());
  }
  
  public void doSyncAction(Context cx)
  {
    logger.info("syncAction invoked on thread " + Thread.currentThread().getName());
  }

  public void doAsyncAction(Context cx)
  {
    logger.info("asyncAction invoked on thread " + Thread.currentThread().getName());
  }

  private static final Logger logger = Logger.getLogger("slides");
}
