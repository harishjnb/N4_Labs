package com.tridiumuniversity.devTrafficLights;


import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;

@NiagaraType
@NiagaraProperty(
        name="state",
        type = "String",
        defaultValue="",
        flags = Flags.TRANSIENT | Flags.SUMMARY | Flags.READONLY
)

@NiagaraProperty(
        name = "worker",
        type = "BDemoWorker",
        defaultValue= "new BDemoWorker()"
)

@NiagaraAction(
        name="execute",
        flags = Flags.ASYNC
)
public class BFastComponentWithWorker extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BFastComponentWithWorker(1441203040)1.0$ @*/
/* Generated Fri Feb 07 13:30:48 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "state"

  /**
   * Slot for the {@code state} property.
   * @see #getState
   * @see #setState
   */
  public static final Property state = newProperty(Flags.TRANSIENT | Flags.SUMMARY | Flags.READONLY, "", null);

  /**
   * Get the {@code state} property.
   * @see #state
   */
  public String getState() { return getString(state); }

  /**
   * Set the {@code state} property.
   * @see #state
   */
  public void setState(String v) { setString(state, v, null); }

  //endregion Property "state"

  //region Property "worker"

  /**
   * Slot for the {@code worker} property.
   * @see #getWorker
   * @see #setWorker
   */
  public static final Property worker = newProperty(0, new BDemoWorker(), null);

  /**
   * Get the {@code worker} property.
   * @see #worker
   */
  public BDemoWorker getWorker() { return (BDemoWorker)get(worker); }

  /**
   * Set the {@code worker} property.
   * @see #worker
   */
  public void setWorker(BDemoWorker v) { set(worker, v, null); }

  //endregion Property "worker"

  //region Action "execute"

  /**
   * Slot for the {@code execute} action.
   * @see #execute()
   */
  public static final Action execute = newAction(Flags.ASYNC, null);

  /**
   * Invoke the {@code execute} action.
   * @see #execute
   */
  public void execute() { invoke(execute, null, null); }

  //endregion Action "execute"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFastComponentWithWorker.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public void doExecute()
{
  setState("Executing");

  try
  {
    //Simulate a slow task by sleeping for 10 seconds
    Thread.sleep(10000L);
  }
  catch (InterruptedException ex)
  {
    setState("Interrupted");
  }

  setState("Complete");
}

  @Override
  public IFuture post(Action action, BValue argument, Context cx)
  {
    if (execute.equals(action))
    {
      getWorker().postAsync(new Invocation(this, action, argument, cx));
    }
    return null;
  }
}
