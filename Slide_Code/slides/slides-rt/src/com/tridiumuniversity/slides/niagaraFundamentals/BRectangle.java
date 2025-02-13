/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "length",
  type = "double",
  defaultValue = "0"
)
@NiagaraProperty(
  name = "width",
  type = "double",
  defaultValue = "0"
)
@NiagaraProperty(
  name = "area",
  type = "double",
  defaultValue = "0",
  flags = Flags.READONLY
)
public class BRectangle
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BRectangle(2379685848)1.0$ @*/
/* Generated Tue Jul 23 12:04:40 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "length"

  /**
   * Slot for the {@code length} property.
   * @see #getLength
   * @see #setLength
   */
  public static final Property length = newProperty(0, 0, null);

  /**
   * Get the {@code length} property.
   * @see #length
   */
  public double getLength() { return getDouble(length); }

  /**
   * Set the {@code length} property.
   * @see #length
   */
  public void setLength(double v) { setDouble(length, v, null); }

  //endregion Property "length"

  //region Property "width"

  /**
   * Slot for the {@code width} property.
   * @see #getWidth
   * @see #setWidth
   */
  public static final Property width = newProperty(0, 0, null);

  /**
   * Get the {@code width} property.
   * @see #width
   */
  public double getWidth() { return getDouble(width); }

  /**
   * Set the {@code width} property.
   * @see #width
   */
  public void setWidth(double v) { setDouble(width, v, null); }

  //endregion Property "width"

  //region Property "area"

  /**
   * Slot for the {@code area} property.
   * @see #getArea
   * @see #setArea
   */
  public static final Property area = newProperty(Flags.READONLY, 0, null);

  /**
   * Get the {@code area} property.
   * @see #area
   */
  public double getArea() { return getDouble(area); }

  /**
   * Set the {@code area} property.
   * @see #area
   */
  public void setArea(double v) { setDouble(area, v, null); }

  //endregion Property "area"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRectangle.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void changed(Property p, Context cx)
  {
    if (length.equals(p) || width.equals(p))
    {
      setArea(getLength() * getWidth());
    }
  }
}
