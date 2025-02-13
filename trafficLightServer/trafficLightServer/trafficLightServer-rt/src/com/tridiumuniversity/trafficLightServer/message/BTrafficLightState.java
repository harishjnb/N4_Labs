/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.message;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum(
  range = {
    @Range(ordinal = 1, value = "red"),
    @Range(ordinal = 2, value = "yellow"),
    @Range(ordinal = 3, value = "green"),
  },
  defaultValue = "red"
)
public final class BTrafficLightState extends BFrozenEnum
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.message.BTrafficLightState(3080305099)1.0$ @*/
/* Generated Fri Aug 25 11:25:00 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  /** Ordinal value for red. */
  public static final int RED = 1;
  /** Ordinal value for yellow. */
  public static final int YELLOW = 2;
  /** Ordinal value for green. */
  public static final int GREEN = 3;

  /** BTrafficLightState constant for red. */
  public static final BTrafficLightState red = new BTrafficLightState(RED);
  /** BTrafficLightState constant for yellow. */
  public static final BTrafficLightState yellow = new BTrafficLightState(YELLOW);
  /** BTrafficLightState constant for green. */
  public static final BTrafficLightState green = new BTrafficLightState(GREEN);

  /** Factory method with ordinal. */
  public static BTrafficLightState make(int ordinal)
  {
    return (BTrafficLightState)red.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BTrafficLightState make(String tag)
  {
    return (BTrafficLightState)red.getRange().get(tag);
  }

  /** Private constructor. */
  private BTrafficLightState(int ordinal)
  {
    super(ordinal);
  }

  public static final BTrafficLightState DEFAULT = red;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightState.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
