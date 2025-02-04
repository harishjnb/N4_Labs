/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.devTrafficLights;

import javax.baja.nre.annotations.*;
import javax.baja.sys.*;

import javax.baja.sys.BComponent;

@NiagaraType
@NiagaraProperty(
        name = "minimumYellowTime",
        type = "baja:RelTime",
        defaultValue = "BRelTime.makeSeconds(5)",
        facets =
        {
                @Facet(name="BFacets.MIN", value="BRelTime.makeSeconds(3)"),
                @Facet(name="BFacets.MAX", value="BRelTime.makeSeconds(20)")
        }
)
@NiagaraProperty(
        name = "state",
        type = "BTrafficLightState",
        defaultValue = "BTrafficLightState.red",
        flags = Flags.READONLY | Flags.SUMMARY
)
@NiagaraProperty(
        name = "lastChange",
        type = "baja:AbsTime",
        defaultValue = "BAbsTime.NULL",
        flags = Flags.READONLY | Flags.TRANSIENT
)
@NiagaraAction(
        name="transition",
        parameterType="BTrafficLightState",
        defaultValue = "BTrafficLightState.red"
)

@NiagaraTopic(
        name="transitioned",
        eventType="BTrafficLightState",
        flags=Flags.SUMMARY
)
public class BTrafficLight extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BTrafficLight(3546490292)1.0$ @*/
/* Generated Tue Feb 04 14:53:28 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "minimumYellowTime"

  /**
   * Slot for the {@code minimumYellowTime} property.
   * @see #getMinimumYellowTime
   * @see #setMinimumYellowTime
   */
  public static final Property minimumYellowTime = newProperty(0, BRelTime.makeSeconds(5), BFacets.make(BFacets.make(BFacets.MIN, BRelTime.makeSeconds(3)), BFacets.make(BFacets.MAX, BRelTime.makeSeconds(20))));

  /**
   * Get the {@code minimumYellowTime} property.
   * @see #minimumYellowTime
   */
  public BRelTime getMinimumYellowTime() { return (BRelTime)get(minimumYellowTime); }

  /**
   * Set the {@code minimumYellowTime} property.
   * @see #minimumYellowTime
   */
  public void setMinimumYellowTime(BRelTime v) { set(minimumYellowTime, v, null); }

  //endregion Property "minimumYellowTime"

  //region Property "state"

  /**
   * Slot for the {@code state} property.
   * @see #getState
   * @see #setState
   */
  public static final Property state = newProperty(Flags.READONLY | Flags.SUMMARY, BTrafficLightState.red, null);

  /**
   * Get the {@code state} property.
   * @see #state
   */
  public BTrafficLightState getState() { return (BTrafficLightState)get(state); }

  /**
   * Set the {@code state} property.
   * @see #state
   */
  public void setState(BTrafficLightState v) { set(state, v, null); }

  //endregion Property "state"

  //region Property "lastChange"

  /**
   * Slot for the {@code lastChange} property.
   * @see #getLastChange
   * @see #setLastChange
   */
  public static final Property lastChange = newProperty(Flags.READONLY | Flags.TRANSIENT, BAbsTime.NULL, null);

  /**
   * Get the {@code lastChange} property.
   * @see #lastChange
   */
  public BAbsTime getLastChange() { return (BAbsTime)get(lastChange); }

  /**
   * Set the {@code lastChange} property.
   * @see #lastChange
   */
  public void setLastChange(BAbsTime v) { set(lastChange, v, null); }

  //endregion Property "lastChange"

  //region Action "transition"

  /**
   * Slot for the {@code transition} action.
   * @see #transition(BTrafficLightState parameter)
   */
  public static final Action transition = newAction(0, BTrafficLightState.red, null);

  /**
   * Invoke the {@code transition} action.
   * @see #transition
   */
  public void transition(BTrafficLightState parameter) { invoke(transition, parameter, null); }

  //endregion Action "transition"

  //region Topic "transitioned"

  /**
   * Slot for the {@code transitioned} topic.
   * @see #fireTransitioned
   */
  public static final Topic transitioned = newTopic(Flags.SUMMARY, null);

  /**
   * Fire an event for the {@code transitioned} topic.
   * @see #transitioned
   */
  public void fireTransitioned(BTrafficLightState event) { fire(transitioned, event, null); }

  //endregion Topic "transitioned"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLight.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public void doTransition(BTrafficLightState newState)
    {
        BTrafficLightState oldState = getState();
        if(oldState.equals(BTrafficLightState.green)&&newState.equals(BTrafficLightState.red))
        {
            setState(BTrafficLightState.yellow);
            Clock.schedule(this,this.getMinimumYellowTime(),transition,BTrafficLightState.red);
        }
        else if(oldState.equals(BTrafficLightState.yellow)&&newState.equals(BTrafficLightState.red))
        {
            long timeinYellowState = BAbsTime.now().getMillis() - getLastChange().getMillis();
           if(timeinYellowState>getMinimumYellowTime().getMillis())
            setState(newState);

        }
        else {
            setState(newState);
        }
        if(!getState().equals(oldState))
        setLastChange(BAbsTime.now());

    }

    @Override
    public void changed(Property prop, Context cx)
    {
        if(prop.equals(state))
        {
            fireTransitioned(getState());
        }
    }


    private void scheduleStateChange(BRelTime delay, BTrafficLightState newState)
    {
        ticket = Clock.schedule(this, delay, transition, newState);
    }

    private boolean stateChangeScheduled()
    {
        return ticket != null && !ticket.isExpired();
    }

    private void cancelStateChange()
    {
        if (ticket != null)
        {
            ticket.cancel();
            ticket = null;
        }
    }

    private Clock.Ticket ticket = null;
}
