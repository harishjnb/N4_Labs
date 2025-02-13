/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.servicesAndMultithreaded.BGoodAsyncExample;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BGoodAsyncExampleTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.servicesAndMultithreaded.BGoodAsyncExampleTest(2979906276)1.0$ @*/
/* Generated Tue Oct 10 10:09:14 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BGoodAsyncExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void asyncActionCompletes()
  {
    BGoodAsyncExample goodAsyncExample = new BGoodAsyncExample();
    goodAsyncExample.setDelay(delay);

    // Note that I'm calling asyncAction() instead of doAsyncAction(). This is so that I give the framework the chance
    // to call the post() method.
    goodAsyncExample.asyncAction();

    try
    {
      Thread.sleep(5 * delay);
    }
    catch(InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }

    Assert.assertTrue(goodAsyncExample.isExpensiveOperationDone());
  }

  private final long delay = 100;
}
