/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import java.util.function.Consumer;

import javax.baja.job.BSimpleJob;
import javax.baja.job.JobCancelException;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BCalculatePiJob extends BSimpleJob
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BCalculatePiJob(2979906276)1.0$ @*/
/* Generated Tue Oct 10 09:44:06 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCalculatePiJob.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BCalculatePiJob()
  {
  }

  public BCalculatePiJob(int steps, Consumer<Double> whenDoneCallback)
  {
    this.whenDoneCallback = whenDoneCallback;
    this.steps = steps;
  }

  @Override
  public void run(Context cx)
  {
    if (steps <= 0)
      throw new IllegalArgumentException("steps must be positive");

    double pi = 0;
    for(int i = 0; i < steps; i++)
    {
      if (!isAlive())
      {
        throw new JobCancelException();
      }

      if (i % 2 == 0) pi += 4.0 / (2*i + 1);
      else pi -= 4.0 / (2*i + 1);

      log().message("slides", "piStep", new String[] {Integer.toString(i+1), Integer.toString(steps), Double.toString(pi)});
      progress((int) ((double)i / steps));
    }
    whenDoneCallback.accept(pi);
  }

  private Consumer<Double> whenDoneCallback;
  private int steps;
}
