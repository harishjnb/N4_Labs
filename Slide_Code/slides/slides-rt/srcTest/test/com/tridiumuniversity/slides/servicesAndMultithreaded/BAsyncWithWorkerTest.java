/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.servicesAndMultithreaded.BAsyncWithWorker;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BAsyncWithWorkerTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.servicesAndMultithreaded.BAsyncWithWorkerTest(2979906276)1.0$ @*/
/* Generated Tue Oct 10 10:16:02 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAsyncWithWorkerTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void asyncActionCompletes()
  {
    BAsyncWithWorker asyncWithWorker = new BAsyncWithWorker();
    asyncWithWorker.setDelay(DELAY);

    // The Worker thread isn't started until the BConcreteThreadPoolWorker#started() callback method is called, so I'm
    // mounting everything in a station to ensure it is called
    stationHandler.getStation().add("asyncWithWorker", asyncWithWorker);

    // Note that I'm calling asyncAction() instead of doAsyncAction(). This is so that I give the framework the chance
    // to call the post() method.
    asyncWithWorker.asyncAction();

    try
    {
      Thread.sleep(5 * DELAY);
    }
    catch(InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }

    Assert.assertTrue(asyncWithWorker.isExpensiveOperationDone());
  }

  private static final long DELAY = 100;
}
