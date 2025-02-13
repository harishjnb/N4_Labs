/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraTopic;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Action;
import javax.baja.sys.BString;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Topic;
import javax.baja.sys.Type;

/**
 * This is my class JavaDoc
 */
@NiagaraType
/**
 * This is my Property JavaDoc
 */
@NiagaraProperty(
  name = "exampleProperty",
  type = "String",
  defaultValue = ""
)
/**
 * This is my Action JavaDoc
 */
@NiagaraAction(
  name = "exampleAction"
)
/**
 * This is my Topic JavaDoc
 */
@NiagaraTopic(
  name = "exampleTopic",
  eventType = "BString"
)
public class BDocumentationExample
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BDocumentationExample(3972864845)1.0$ @*/
/* Generated Thu Jul 25 14:46:20 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "exampleProperty"

  /**
   * Slot for the {@code exampleProperty} property.
   * This is my Property JavaDoc
   * @see #getExampleProperty
   * @see #setExampleProperty
   */
  public static final Property exampleProperty = newProperty(0, "", null);

  /**
   * Get the {@code exampleProperty} property.
   * This is my Property JavaDoc
   * @see #exampleProperty
   */
  public String getExampleProperty() { return getString(exampleProperty); }

  /**
   * Set the {@code exampleProperty} property.
   * This is my Property JavaDoc
   * @see #exampleProperty
   */
  public void setExampleProperty(String v) { setString(exampleProperty, v, null); }

  //endregion Property "exampleProperty"

  //region Action "exampleAction"

  /**
   * Slot for the {@code exampleAction} action.
   * This is my Action JavaDoc
   * @see #exampleAction()
   */
  public static final Action exampleAction = newAction(0, null);

  /**
   * Invoke the {@code exampleAction} action.
   * This is my Action JavaDoc
   * @see #exampleAction
   */
  public void exampleAction() { invoke(exampleAction, null, null); }

  //endregion Action "exampleAction"

  //region Topic "exampleTopic"

  /**
   * Slot for the {@code exampleTopic} topic.
   * This is my Topic JavaDoc
   * @see #fireExampleTopic
   */
  public static final Topic exampleTopic = newTopic(0, null);

  /**
   * Fire an event for the {@code exampleTopic} topic.
   * This is my Topic JavaDoc
   * @see #exampleTopic
   */
  public void fireExampleTopic(BString event) { fire(exampleTopic, event, null); }

  //endregion Topic "exampleTopic"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDocumentationExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doExampleAction() {}

  /**
   * This is my method JavaDoc
   * @param exampleParameter1
   * @param exampleParameter2
   */
  public void exampleMethod(int exampleParameter1, String exampleParameter2) {}
}
