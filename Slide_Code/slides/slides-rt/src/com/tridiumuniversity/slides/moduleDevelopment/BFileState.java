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
    @Range("idle"),
    @Range("inProgress"),
    @Range("success"),
    @Range("failure")
  }
)
public final class BFileState
  extends BFrozenEnum
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BFileState(2097536741)1.0$ @*/
/* Generated Wed Nov 29 14:37:17 EST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  /** Ordinal value for idle. */
  public static final int IDLE = 0;
  /** Ordinal value for inProgress. */
  public static final int IN_PROGRESS = 1;
  /** Ordinal value for success. */
  public static final int SUCCESS = 2;
  /** Ordinal value for failure. */
  public static final int FAILURE = 3;

  /** BFileState constant for idle. */
  public static final BFileState idle = new BFileState(IDLE);
  /** BFileState constant for inProgress. */
  public static final BFileState inProgress = new BFileState(IN_PROGRESS);
  /** BFileState constant for success. */
  public static final BFileState success = new BFileState(SUCCESS);
  /** BFileState constant for failure. */
  public static final BFileState failure = new BFileState(FAILURE);

  /** Factory method with ordinal. */
  public static BFileState make(int ordinal)
  {
    return (BFileState)idle.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BFileState make(String tag)
  {
    return (BFileState)idle.getRange().get(tag);
  }

  /** Private constructor. */
  private BFileState(int ordinal)
  {
    super(ordinal);
  }

  public static final BFileState DEFAULT = idle;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFileState.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}
