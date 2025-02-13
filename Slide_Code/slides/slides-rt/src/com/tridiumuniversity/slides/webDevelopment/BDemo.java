/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.webDevelopment;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BComponent;
import javax.baja.sys.BInteger;
import javax.baja.sys.BString;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "intProperty",
  type = "BInteger",
  defaultValue = "BInteger.DEFAULT"
)
@NiagaraProperty(
  name = "stringProperty",
  type = "BString",
  defaultValue = "BString.DEFAULT"
)
@NiagaraProperty(
  name = "booleanProperty",
  type = "BBoolean",
  defaultValue = "BBoolean.DEFAULT"
)
public class BDemo extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.webDevelopment.BDemo(2794058629)1.0$ @*/
/* Generated Fri Oct 20 08:21:52 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "intProperty"

  /**
   * Slot for the {@code intProperty} property.
   * @see #getIntProperty
   * @see #setIntProperty
   */
  public static final Property intProperty = newProperty(0, BInteger.DEFAULT.as(BInteger.class).getInt(), null);

  /**
   * Get the {@code intProperty} property.
   * @see #intProperty
   */
  public int getIntProperty() { return getInt(intProperty); }

  /**
   * Set the {@code intProperty} property.
   * @see #intProperty
   */
  public void setIntProperty(int v) { setInt(intProperty, v, null); }

  //endregion Property "intProperty"

  //region Property "stringProperty"

  /**
   * Slot for the {@code stringProperty} property.
   * @see #getStringProperty
   * @see #setStringProperty
   */
  public static final Property stringProperty = newProperty(0, BString.DEFAULT, null);

  /**
   * Get the {@code stringProperty} property.
   * @see #stringProperty
   */
  public String getStringProperty() { return getString(stringProperty); }

  /**
   * Set the {@code stringProperty} property.
   * @see #stringProperty
   */
  public void setStringProperty(String v) { setString(stringProperty, v, null); }

  //endregion Property "stringProperty"

  //region Property "booleanProperty"

  /**
   * Slot for the {@code booleanProperty} property.
   * @see #getBooleanProperty
   * @see #setBooleanProperty
   */
  public static final Property booleanProperty = newProperty(0, BBoolean.DEFAULT.as(BBoolean.class).getBoolean(), null);

  /**
   * Get the {@code booleanProperty} property.
   * @see #booleanProperty
   */
  public boolean getBooleanProperty() { return getBoolean(booleanProperty); }

  /**
   * Set the {@code booleanProperty} property.
   * @see #booleanProperty
   */
  public void setBooleanProperty(boolean v) { setBoolean(booleanProperty, v, null); }

  //endregion Property "booleanProperty"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDemo.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
