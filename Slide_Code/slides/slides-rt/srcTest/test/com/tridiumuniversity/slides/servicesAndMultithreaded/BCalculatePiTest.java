/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.servicesAndMultithreaded.BCalculatePi;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BCalculatePiTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.servicesAndMultithreaded.BCalculatePiTest(2979906276)1.0$ @*/
/* Generated Tue Oct 10 11:02:58 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCalculatePiTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testPiCalculation()
  {
    BCalculatePi calculatePi = new BCalculatePi();
    calculatePi.setSteps(10);
    calculatePi.setPi(0);
    calculatePi.doStartJob(null);

    // Give the job some time to complete
    try
    {
      Thread.sleep(200);
    }
    catch (InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }

    Assert.assertNotEquals(calculatePi.getPi(), 0, "pi approximation should have been calculated");
  }
}
