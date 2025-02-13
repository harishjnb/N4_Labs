package com.tridiumuniversity.slides.workbenchDevelopment;

import java.util.logging.Logger;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "frozenProperty",
  type = "int",
  defaultValue = "0"
)
public class BSubscribedLogger
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.workbenchDevelopment.BSubscribedLogger(553883464)1.0$ @*/
/* Generated Tue Aug 13 15:15:18 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "frozenProperty"

  /**
   * Slot for the {@code frozenProperty} property.
   * @see #getFrozenProperty
   * @see #setFrozenProperty
   */
  public static final Property frozenProperty = newProperty(0, 0, null);

  /**
   * Get the {@code frozenProperty} property.
   * @see #frozenProperty
   */
  public int getFrozenProperty() { return getInt(frozenProperty); }

  /**
   * Set the {@code frozenProperty} property.
   * @see #frozenProperty
   */
  public void setFrozenProperty(int v) { setInt(frozenProperty, v, null); }

  //endregion Property "frozenProperty"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSubscribedLogger.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void added(Property p, Context cx)
  {
    if (isRunning())
    {
      logger.info(String.format("%s (master): Dynamic property %s added", getName(), p.getName()));
    }
    else
    {
      logger.info(String.format("%s (proxy): Dynamic property %s added", getName(), p.getName()));
    }
  }

  @Override
  public void changed(Property p, Context cx)
  {
    if (isRunning())
    {
      logger.info(String.format("%s (master): property %s changed", getName(), p.getName()));
    }
    else
    {
      logger.info(String.format("%s (proxy): Property %s changed", getName(), p.getName()));
    }
  }

  @Override
  public void subscribed()
  {
    if (isRunning())
    {
      logger.info(String.format("%s (master): subscribed", getName()));
    }
    else
    {
      logger.info(String.format("%s (proxy): subscribed", getName()));
    }
  }

  @Override
  public void unsubscribed()
  {
    if (isRunning())
    {
      logger.info(String.format("%s (master): unsubscribed", getName()));
    }
    else
    {
      logger.info(String.format("%s (proxy): unsubscribed", getName()));
    }
  }

  private static final Logger logger = Logger.getLogger("slides");
}
