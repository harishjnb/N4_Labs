/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "url",
  type="String",
  defaultValue = ""
)
public class BLoggingExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BLoggingExample(944886909)1.0$ @*/
/* Generated Fri Oct 06 14:45:44 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "url"

  /**
   * Slot for the {@code url} property.
   * @see #getUrl
   * @see #setUrl
   */
  public static final Property url = newProperty(0, "", null);

  /**
   * Get the {@code url} property.
   * @see #url
   */
  public String getUrl() { return getString(url); }

  /**
   * Set the {@code url} property.
   * @see #url
   */
  public void setUrl(String v) { setString(url, v, null); }

  //endregion Property "url"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLoggingExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  @Override
  public void started()
  {
    try
    {
      logger.info("Connecting to " + getUrl());
      long before = System.currentTimeMillis();
      connect();
      long after = System.currentTimeMillis();
      if (logger.isLoggable(Level.FINE))
      {
        logger.fine(String.format("Connected to %s in %d ms", getUrl(), after - before));
      }
    }
    catch (MalformedURLException ex)
    {
      logger.log(Level.SEVERE, "Unable to connect to " + getUrl(), ex);
    }
  }

  private void connect()
    throws MalformedURLException
  {
  }

  private static final Logger logger = Logger.getLogger("slides");
}
