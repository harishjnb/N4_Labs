/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.servicesAndMultithreaded.BMutualExclusion;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BMutualExclusionTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.servicesAndMultithreaded.BMutualExclusionTest(2979906276)1.0$ @*/
/* Generated Tue Oct 10 10:31:37 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMutualExclusionTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testIncrementMutualExclusion()
  {
    BMutualExclusion mutualExclusion = new BMutualExclusion();
    mutualExclusion.setNumber(0);
    mutualExclusion.doIncrement1000Times(null);

    // Give the threads some time to complete
    try
    {
      Thread.sleep(delay);
    }
    catch(InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }

    Assert.assertEquals(mutualExclusion.getNumber(), 1000, "Mutual exclusion should be ensured");
  }

  private final long delay = 500;
}
