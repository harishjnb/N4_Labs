package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BString;
import javax.baja.sys.BTopic;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BCustomTopic
  extends BTopic
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BCustomTopic(2979906276)1.0$ @*/
/* Generated Tue Sep 03 13:45:45 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCustomTopic.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public Type getEventType()
  {
    return BString.TYPE;
  }
}
