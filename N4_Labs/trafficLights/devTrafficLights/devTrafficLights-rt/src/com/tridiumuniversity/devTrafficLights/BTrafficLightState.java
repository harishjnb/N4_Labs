package com.tridiumuniversity.devTrafficLights;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum(
        range = {
                @Range("red"),
                @Range("yellow"),
                @Range("green")
        },
        defaultValue = "green"
)

public final class BTrafficLightState extends BFrozenEnum {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BTrafficLightState(1253259184)1.0$ @*/
/* Generated Tue Feb 04 15:06:19 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  /** Ordinal value for red. */
  public static final int RED = 0;
  /** Ordinal value for yellow. */
  public static final int YELLOW = 1;
  /** Ordinal value for green. */
  public static final int GREEN = 2;

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

  public static final BTrafficLightState DEFAULT = green;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightState.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
