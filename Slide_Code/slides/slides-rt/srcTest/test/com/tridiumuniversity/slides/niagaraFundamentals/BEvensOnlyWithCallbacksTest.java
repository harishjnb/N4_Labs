/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.niagaraFundamentals.BEvensOnlyWithCallbacks;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BEvensOnlyWithCallbacksTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.niagaraFundamentals.BEvensOnlyWithCallbacksTest(2979906276)1.0$ @*/
/* Generated Tue Jul 23 12:13:30 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEvensOnlyWithCallbacksTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void onlyEvenSetsAreAllowed()
  {
    BEvensOnlyWithCallbacks evensOnly = new BEvensOnlyWithCallbacks();

    evensOnly.setNumber(2);
    Assert.assertEquals(evensOnly.getNumber(), 2, "Even sets should be allowed");

    evensOnly.setNumber(3);
    Assert.assertEquals(evensOnly.getNumber(), 2, "Odd sets should not be allowed");
  }
}
