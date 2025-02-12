package com.tridiumuniversity.prac;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum(
        range = {
                @Range("low"),
                @Range("med"),
                @Range("high")
        },
        defaultValue = "low"
)
public final class BMyState extends BFrozenEnum {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.prac.BMyState(1888665550)1.0$ @*/
/* Generated Tue Feb 11 19:14:11 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  /** Ordinal value for low. */
  public static final int LOW = 0;
  /** Ordinal value for med. */
  public static final int MED = 1;
  /** Ordinal value for high. */
  public static final int HIGH = 2;

  /** BMyState constant for low. */
  public static final BMyState low = new BMyState(LOW);
  /** BMyState constant for med. */
  public static final BMyState med = new BMyState(MED);
  /** BMyState constant for high. */
  public static final BMyState high = new BMyState(HIGH);

  /** Factory method with ordinal. */
  public static BMyState make(int ordinal)
  {
    return (BMyState)low.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BMyState make(String tag)
  {
    return (BMyState)low.getRange().get(tag);
  }

  /** Private constructor. */
  private BMyState(int ordinal)
  {
    super(ordinal);
  }

  public static final BMyState DEFAULT = low;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMyState.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}
