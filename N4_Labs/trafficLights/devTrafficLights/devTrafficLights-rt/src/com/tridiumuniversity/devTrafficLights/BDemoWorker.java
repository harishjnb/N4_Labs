/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.devTrafficLights;

import javax.baja.sys.*;
import javax.baja.util.*;
import javax.baja.nre.annotations.*;

@NiagaraType
@NiagaraProperty(
        name = "queueSize",
        type = "int",
        defaultValue = "10"
)
public class BDemoWorker extends BWorker
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BDemoWorker(726796455)1.0$ @*/
/* Generated Fri Feb 07 13:15:02 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "queueSize"

  /**
   * Slot for the {@code queueSize} property.
   * @see #getQueueSize
   * @see #setQueueSize
   */
  public static final Property queueSize = newProperty(0, 10, null);

  /**
   * Get the {@code queueSize} property.
   * @see #queueSize
   */
  public int getQueueSize() { return getInt(queueSize); }

  /**
   * Set the {@code queueSize} property.
   * @see #queueSize
   */
  public void setQueueSize(int v) { setInt(queueSize, v, null); }

  //endregion Property "queueSize"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDemoWorker.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public Worker getWorker()
    {
        if (worker == null)
        {
            queue = new CoalesceQueue(getQueueSize());
            worker = new Worker(queue);
        }
        return worker;
    }

    @Override
    public void changed(Property p, Context cx)
    {
        if (queueSize.equals(p))
        {
            // Force instantiation of new worker with new queue size
            worker = null;
        }
    }

    /**
     * Post an action to be run asynchronously.
     */
    public void postAsync(Runnable r)
    {
        if (!isRunning() || queue == null)
        {
            throw new NotRunningException();
        }
        queue.enqueue(r);
    }


    private CoalesceQueue queue;
    private Worker worker;
}
