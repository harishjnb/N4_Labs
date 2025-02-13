/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.BThreadPoolWorker;
import javax.baja.util.Queue;
import javax.baja.util.ThreadPoolWorker;
import javax.baja.util.Worker;

@NiagaraType
public class BConcreteThreadPoolWorker
  extends BThreadPoolWorker
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BConcreteThreadPoolWorker(2979906276)1.0$ @*/
/* Generated Tue Oct 10 09:08:56 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BConcreteThreadPoolWorker.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  @Override
  public Worker getWorker()
  {
    return worker;
  }

  public void addWork(Runnable runnable)
  {
    queue.enqueue(runnable);
  }

  private final Queue queue = new Queue();
  private final ThreadPoolWorker worker = new ThreadPoolWorker(queue);
}
