/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraTopic;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BComponent;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Topic;
import javax.baja.sys.Type;

@NiagaraType
/**
 * This JavaDoc comment will be included with the slot code
 */
@NiagaraTopic(
  name = "valueComputed",
  flags = Flags.SUMMARY,
  eventType = "BBoolean"
)
public class BTopicExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BTopicExample(2976952230)1.0$ @*/
/* Generated Fri Oct 06 11:44:59 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Topic "valueComputed"

  /**
   * Slot for the {@code valueComputed} topic.
   * This JavaDoc comment will be included with the slot code
   * @see #fireValueComputed
   */
  public static final Topic valueComputed = newTopic(Flags.SUMMARY, null);

  /**
   * Fire an event for the {@code valueComputed} topic.
   * This JavaDoc comment will be included with the slot code
   * @see #valueComputed
   */
  public void fireValueComputed(BBoolean event) { fire(valueComputed, event, null); }

  //endregion Topic "valueComputed"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTopicExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
