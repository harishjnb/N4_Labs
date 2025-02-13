package com.tridiumuniversity.slides.ui;

import javax.baja.gx.BBrush;
import javax.baja.gx.BColor;
import javax.baja.gx.BEllipseGeom;
import javax.baja.gx.BFont;
import javax.baja.gx.Graphics;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.ui.BWidget;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import com.tridiumuniversity.slides.moduleDevelopment.BCompass;

@NiagaraType
@NiagaraProperty(
  name = "backgroundColor",
  type = "gx:Brush",
  defaultValue = "BBrush.makeSolid(BColor.white)"
)
@NiagaraProperty(
  name = "needleColor",
  type = "gx:Brush",
  defaultValue = "BBrush.makeSolid(BColor.black)"
)
@NiagaraProperty(
  name = "fontColor",
  type = "gx:Brush",
  defaultValue = "BBrush.makeSolid(BColor.black)"
)
@NiagaraProperty(
  name = "font",
  type = "gx:Font",
  defaultValue = "BFont.DEFAULT"
)
@NiagaraProperty(
  name = "value",
  type = "slides:Compass",
  defaultValue = "BCompass.DEFAULT"
)
public class BCompassWidget
  extends BWidget
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ui.BCompassWidget(3337518306)1.0$ @*/
/* Generated Wed Nov 06 13:12:27 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "backgroundColor"

  /**
   * Slot for the {@code backgroundColor} property.
   * @see #getBackgroundColor
   * @see #setBackgroundColor
   */
  public static final Property backgroundColor = newProperty(0, BBrush.makeSolid(BColor.white), null);

  /**
   * Get the {@code backgroundColor} property.
   * @see #backgroundColor
   */
  public BBrush getBackgroundColor() { return (BBrush)get(backgroundColor); }

  /**
   * Set the {@code backgroundColor} property.
   * @see #backgroundColor
   */
  public void setBackgroundColor(BBrush v) { set(backgroundColor, v, null); }

  //endregion Property "backgroundColor"

  //region Property "needleColor"

  /**
   * Slot for the {@code needleColor} property.
   * @see #getNeedleColor
   * @see #setNeedleColor
   */
  public static final Property needleColor = newProperty(0, BBrush.makeSolid(BColor.black), null);

  /**
   * Get the {@code needleColor} property.
   * @see #needleColor
   */
  public BBrush getNeedleColor() { return (BBrush)get(needleColor); }

  /**
   * Set the {@code needleColor} property.
   * @see #needleColor
   */
  public void setNeedleColor(BBrush v) { set(needleColor, v, null); }

  //endregion Property "needleColor"

  //region Property "fontColor"

  /**
   * Slot for the {@code fontColor} property.
   * @see #getFontColor
   * @see #setFontColor
   */
  public static final Property fontColor = newProperty(0, BBrush.makeSolid(BColor.black), null);

  /**
   * Get the {@code fontColor} property.
   * @see #fontColor
   */
  public BBrush getFontColor() { return (BBrush)get(fontColor); }

  /**
   * Set the {@code fontColor} property.
   * @see #fontColor
   */
  public void setFontColor(BBrush v) { set(fontColor, v, null); }

  //endregion Property "fontColor"

  //region Property "font"

  /**
   * Slot for the {@code font} property.
   * @see #getFont
   * @see #setFont
   */
  public static final Property font = newProperty(0, BFont.DEFAULT, null);

  /**
   * Get the {@code font} property.
   * @see #font
   */
  public BFont getFont() { return (BFont)get(font); }

  /**
   * Set the {@code font} property.
   * @see #font
   */
  public void setFont(BFont v) { set(font, v, null); }

  //endregion Property "font"

  //region Property "value"

  /**
   * Slot for the {@code value} property.
   * @see #getValue
   * @see #setValue
   */
  public static final Property value = newProperty(0, BCompass.DEFAULT, null);

  /**
   * Get the {@code value} property.
   * @see #value
   */
  public BCompass getValue() { return (BCompass)get(value); }

  /**
   * Set the {@code value} property.
   * @see #value
   */
  public void setValue(BCompass v) { set(value, v, null); }

  //endregion Property "value"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCompassWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void paint(Graphics graphics)
  {
    double width = getWidth();
    double height = getHeight();
    double centerX = width / 2;
    double centerY = height / 2;
    double textXOffset = width * 0.1;
    double textYOffset = height * 0.1;

    // Draw compass background
    graphics.setBrush(getBackgroundColor());
    graphics.fill(BEllipseGeom.make(0, 0, width, height));

    // Draw compass text
    graphics.setBrush(getFontColor());
    graphics.setFont(getFont());
    graphics.drawString("N", centerX, textYOffset);
    graphics.drawString("S", centerX, height - textYOffset);
    graphics.drawString("E", width - textXOffset, centerY);
    graphics.drawString("W", textXOffset, centerY);

    // Draw compass needle
    graphics.setBrush(getNeedleColor());
    BCompass value = getValue();
    if (value == BCompass.north)
    {
      graphics.strokeLine(centerX, centerY, centerX, 0);
    }
    else if (value == BCompass.south)
    {
      graphics.strokeLine(centerX, centerY, centerX, height);
    }
    else if (value == BCompass.east)
    {
      graphics.strokeLine(centerX, centerY, width, centerY);
    }
    else if (value == BCompass.west)
    {
      graphics.strokeLine(centerX, centerY, 0, centerY);
    }
  }
}
