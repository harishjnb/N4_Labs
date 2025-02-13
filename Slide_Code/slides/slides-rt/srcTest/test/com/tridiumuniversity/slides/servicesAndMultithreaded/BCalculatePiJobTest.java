/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.job.BJobState;
import javax.baja.job.JobLogItem;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;
import javax.baja.util.LexiconModule;

import com.tridiumuniversity.slides.servicesAndMultithreaded.BCalculatePiJob;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BCalculatePiJobTest extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.servicesAndMultithreaded.BCalculatePiJobTest(2979906276)1.0$ @*/
/* Generated Tue Oct 10 10:44:44 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCalculatePiJobTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  // Note that the below test isn't running the job on a separate job thread because it's not submitting the job
  // to the JobService.
  public void callsConsumer()
  {
    consumerCalled = false;
    BCalculatePiJob job = new BCalculatePiJob(1, d -> consumerCalled = true);

    // Simulate the job running normally - without this, calls to isAlive() will return false
    job.setJobState(BJobState.running);

    Assert.assertFalse(consumerCalled, "Consumer should not be called before job is run");
    job.run(null);
    Assert.assertTrue(consumerCalled, "Consumer should be called when job is run");
  }

  public void throwsExceptionForNegativeSteps()
  {
    consumerCalled = false;
    BCalculatePiJob job = new BCalculatePiJob(-1, d -> consumerCalled = true);

    // Simulate the job running normally - without this, calls to isAlive() will return false
    job.setJobState(BJobState.running);

    Assert.assertThrows(IllegalArgumentException.class, () -> job.run(null));
  }

  public void logsEachApproximation()
  {
    consumerCalled = false;
    BCalculatePiJob job = new BCalculatePiJob(3, d -> consumerCalled = true);

    // Simulate the job running normally - without this, calls to isAlive() will return false
    job.setJobState(BJobState.running);

    job.run(null);
    JobLogItem[] logItems = job.log().getItems();

    for(int i = 0; i < logItems.length; i++)
    {
      Assert.assertTrue(matchesExpectedLogMessage(logItems[i].getMessage(), i+1, logItems.length),
        "Log message " + i + " should match expected lexicon value");
    }
  }

  // Note that the below test isn't running the job on a separate job thread because it's not submitting the job
  // to the JobService.
  public void moreStepsImprovePiApproximation()
  {
    BCalculatePiJob fewStepsJob = new BCalculatePiJob(5, d -> piApproximation = d);
    BCalculatePiJob moreStepsJob = new BCalculatePiJob(100, d -> piApproximation = d);

    // Simulate the jobs running normally - without this, calls to isAlive() will return false
    fewStepsJob.setJobState(BJobState.running);
    moreStepsJob.setJobState(BJobState.running);

    piApproximation = 0;
    fewStepsJob.run(null);
    double firstApproximation = piApproximation;

    piApproximation = 0;
    moreStepsJob.run(null);
    double secondApproximation = piApproximation;

    double firstApproximationError = Math.PI - firstApproximation;
    double secondApproximationError = Math.PI - secondApproximation;
    Assert.assertTrue(Math.abs(secondApproximationError) < Math.abs(firstApproximationError),
      "More steps should improve pi approximation");
  }

  private boolean matchesExpectedLogMessage(String message, int stepNumber, int totalSteps)
  {
    // Replace the {0} and {1} in the lexicon value with the stepNumber and totalSteps
    String lexMessage = lex.getText("piStep", null);
    lexMessage = lexMessage.replace("{0}", Integer.toString(stepNumber));
    lexMessage = lexMessage.replace("{1}", Integer.toString(totalSteps));

    // Strip everything after the {2} - we don't know the pi approximation, so we can't fill it in like we did for the
    // stepNumber and totalSteps
    lexMessage = lexMessage.substring(0, lexMessage.indexOf("{2}"));

    // We consider message to "match" the expected value if it's the same as the lexicon string up until the {2}
    return message.startsWith(lexMessage);
  }

  private double piApproximation;
  private boolean consumerCalled = false;
  private static final LexiconModule lex = LexiconModule.make(BCalculatePiJob.class);
}
