/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BRelTime;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.moduleDevelopment.BTimeHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BTimeHolderTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.moduleDevelopment.BTimeHolderTest(2979906276)1.0$ @*/
/* Generated Fri Oct 06 14:34:21 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTimeHolderTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void testTimeDefaultsToTenSeconds()
  {
    BTimeHolder th = new BTimeHolder();
    Assert.assertEquals(th.getTime(), BRelTime.makeSeconds(10));
  }
}
