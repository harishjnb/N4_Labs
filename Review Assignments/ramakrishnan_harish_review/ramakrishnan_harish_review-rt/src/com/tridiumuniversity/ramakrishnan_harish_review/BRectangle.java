package com.tridiumuniversity.ramakrishnan_harish_review;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraTopic;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.logging.*;

@NiagaraType

@NiagaraProperty(
        name="length",
        type ="double",
        defaultValue = "0.0",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name="width",
        type ="double",
        defaultValue = "0.0",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name="threshold",
        type ="double",
        defaultValue = "0.0",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name="area",
        type ="double",
        defaultValue = "0.0",
        flags=Flags.SUMMARY | Flags.READONLY
)

@NiagaraAction(
        name="calcArea"
)

@NiagaraTopic(
        name="detected",
        eventType="BDouble",
        flags=Flags.SUMMARY
)
public class BRectangle extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.ramakrishnan_harish_review.BRectangle(3531630012)1.0$ @*/
/* Generated Wed Feb 05 15:41:15 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "length"

  /**
   * Slot for the {@code length} property.
   * @see #getLength
   * @see #setLength
   */
  public static final Property length = newProperty(Flags.SUMMARY, 0.0, null);

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
  public static final Property width = newProperty(Flags.SUMMARY, 0.0, null);

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

  //region Property "threshold"

  /**
   * Slot for the {@code threshold} property.
   * @see #getThreshold
   * @see #setThreshold
   */
  public static final Property threshold = newProperty(Flags.SUMMARY, 0.0, null);

  /**
   * Get the {@code threshold} property.
   * @see #threshold
   */
  public double getThreshold() { return getDouble(threshold); }

  /**
   * Set the {@code threshold} property.
   * @see #threshold
   */
  public void setThreshold(double v) { setDouble(threshold, v, null); }

  //endregion Property "threshold"

  //region Property "area"

  /**
   * Slot for the {@code area} property.
   * @see #getArea
   * @see #setArea
   */
  public static final Property area = newProperty(Flags.SUMMARY | Flags.READONLY, 0.0, null);

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

  //region Action "calcArea"

  /**
   * Slot for the {@code calcArea} action.
   * @see #calcArea()
   */
  public static final Action calcArea = newAction(0, null);

  /**
   * Invoke the {@code calcArea} action.
   * @see #calcArea
   */
  public void calcArea() { invoke(calcArea, null, null); }

  //endregion Action "calcArea"

  //region Topic "detected"

  /**
   * Slot for the {@code detected} topic.
   * @see #fireDetected
   */
  public static final Topic detected = newTopic(Flags.SUMMARY, null);

  /**
   * Fire an event for the {@code detected} topic.
   * @see #detected
   */
  public void fireDetected(BDouble event) { fire(detected, event, null); }

  //endregion Topic "detected"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRectangle.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    double areaVal = 0.0;
    @Override
public void changed(Property prop, Context cx)
{
    if(prop.equals(length)||prop.equals(width)||prop.equals(threshold))
    {
        areaVal =  calcAreaCalc(this.getLength(),this.getWidth());
        this.setArea(areaVal);
        if(areaVal>this.getThreshold())
        {
            fireDetected(BDouble.make(areaVal));
        }

    }
}

    public void doCalcArea()
    {
        areaVal=calcAreaCalc(this.getLength(),this.getWidth());
        this.setArea(areaVal);
        if(areaVal>this.getThreshold())
        {
            fireDetected(BDouble.make(areaVal));
            logger.log(Level.INFO,"Length is "+getLength()+" width is "+getWidth());
        }

    }

    public double calcAreaCalc(double len, double wid)
    {
        return len * wid;
    }
    private static final Logger logger = Logger.getLogger("ramakrishnan.harish.review");
}
