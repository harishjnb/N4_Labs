package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BAction;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BCustomAction
  extends BAction
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BCustomAction(2979906276)1.0$ @*/
/* Generated Tue Sep 03 13:45:45 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCustomAction.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public Type getParameterType()
  {
    return null;
  }

  @Override
  public BValue getParameterDefault()
  {
    return null;
  }

  @Override
  public BValue invoke(BComponent target, BValue argument)
  {
    System.out.println("My custom action was invoked");
    return null;
  }

  @Override
  public Type getReturnType()
  {
    return null;
  }
}
