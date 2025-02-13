/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum(
  range = {
    @Range(ordinal = 1, value = "north"),
    @Range(ordinal = 2, value = "south"),
    @Range(ordinal = 3, value = "east"),
    @Range(ordinal = 4, value = "west"),
  },
  defaultValue = "west"
)
public final class BCompass extends BFrozenEnum
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BCompass(3027418257)1.0$ @*/
/* Generated Fri Oct 06 11:48:20 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  /** Ordinal value for north. */
  public static final int NORTH = 1;
  /** Ordinal value for south. */
  public static final int SOUTH = 2;
  /** Ordinal value for east. */
  public static final int EAST = 3;
  /** Ordinal value for west. */
  public static final int WEST = 4;

  /** BCompass constant for north. */
  public static final BCompass north = new BCompass(NORTH);
  /** BCompass constant for south. */
  public static final BCompass south = new BCompass(SOUTH);
  /** BCompass constant for east. */
  public static final BCompass east = new BCompass(EAST);
  /** BCompass constant for west. */
  public static final BCompass west = new BCompass(WEST);

  /** Factory method with ordinal. */
  public static BCompass make(int ordinal)
  {
    return (BCompass)north.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BCompass make(String tag)
  {
    return (BCompass)north.getRange().get(tag);
  }

  /** Private constructor. */
  private BCompass(int ordinal)
  {
    super(ordinal);
  }

  public static final BCompass DEFAULT = west;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCompass.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
