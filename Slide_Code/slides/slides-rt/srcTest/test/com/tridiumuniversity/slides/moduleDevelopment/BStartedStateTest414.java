/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.moduleDevelopment.BStartedState;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BStartedStateTest414
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.moduleDevelopment.BStartedStateTest414(2979906276)1.0$ @*/
/* Generated Wed Jul 24 13:46:22 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BStartedStateTest414.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testStateIsSetOnStart()
  {
    BStartedState ss = new BStartedState();
    Assert.assertNotEquals(ss.getState(), "started");
    stationHandler.getStation().add("ss", ss);
    Assert.assertEquals(ss.getState(), "started");
  }
}
