package com.tridiumuniversity.devTrafficLights;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Flags;
import javax.baja.sys.Action;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

@NiagaraType
@NiagaraProperty(
        name="state",
        type = "String",
        defaultValue="",
        flags = Flags.TRANSIENT | Flags.SUMMARY | Flags.READONLY
)
@NiagaraAction(
        name="execute",
        flags = Flags.ASYNC
)
public class BSlowComponentWithAsyncAction extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BSlowComponentWithAsyncAction(2796332301)1.0$ @*/
/* Generated Fri Feb 07 13:15:03 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

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
  public static final Type TYPE = Sys.loadType(BSlowComponentWithAsyncAction.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public void doExecute()
{
  setState("Executing");
  try{
    Thread.sleep(10000L);
  }
  catch(InterruptedException e)
  {
    setState("Interrupted");
  }
  setState("Complete");
}

}
