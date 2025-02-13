/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BComponent;
import javax.baja.sys.BFacets;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "enabled",
  type = "BBoolean",
  defaultValue = "BBoolean.FALSE",
  facets = {
    @Facet(name = "BFacets.TRUE_TEXT", value = "\"%lexicon(slides:enabled.value)%\""),
    @Facet(name = "BFacets.FALSE_TEXT", value = "\"%lexicon(slides:disabled.value)%\"")
  }
)
@NiagaraProperty(
  name = "filename",
  type = "String",
  defaultValue = ""
)
@NiagaraProperty(
  name = "state",
  type = "BFileState",
  defaultValue = "BFileState.idle"
)
@NiagaraAction(
  name = "readFile"
)
public class BLexiconExample
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BLexiconExample(3588019912)1.0$ @*/
/* Generated Wed Jul 24 11:42:40 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "enabled"

  /**
   * Slot for the {@code enabled} property.
   * @see #getEnabled
   * @see #setEnabled
   */
  public static final Property enabled = newProperty(0, BBoolean.FALSE.as(BBoolean.class).getBoolean(), BFacets.make(BFacets.make(BFacets.TRUE_TEXT, "%lexicon(slides:enabled.value)%"), BFacets.make(BFacets.FALSE_TEXT, "%lexicon(slides:disabled.value)%")));

  /**
   * Get the {@code enabled} property.
   * @see #enabled
   */
  public boolean getEnabled() { return getBoolean(enabled); }

  /**
   * Set the {@code enabled} property.
   * @see #enabled
   */
  public void setEnabled(boolean v) { setBoolean(enabled, v, null); }

  //endregion Property "enabled"

  //region Property "filename"

  /**
   * Slot for the {@code filename} property.
   * @see #getFilename
   * @see #setFilename
   */
  public static final Property filename = newProperty(0, "", null);

  /**
   * Get the {@code filename} property.
   * @see #filename
   */
  public String getFilename() { return getString(filename); }

  /**
   * Set the {@code filename} property.
   * @see #filename
   */
  public void setFilename(String v) { setString(filename, v, null); }

  //endregion Property "filename"

  //region Property "state"

  /**
   * Slot for the {@code state} property.
   * @see #getState
   * @see #setState
   */
  public static final Property state = newProperty(0, BFileState.idle, null);

  /**
   * Get the {@code state} property.
   * @see #state
   */
  public BFileState getState() { return (BFileState)get(state); }

  /**
   * Set the {@code state} property.
   * @see #state
   */
  public void setState(BFileState v) { set(state, v, null); }

  //endregion Property "state"

  //region Action "readFile"

  /**
   * Slot for the {@code readFile} action.
   * @see #readFile()
   */
  public static final Action readFile = newAction(0, null);

  /**
   * Invoke the {@code readFile} action.
   * @see #readFile
   */
  public void readFile() { invoke(readFile, null, null); }

  //endregion Action "readFile"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLexiconExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doReadFile(Context cx)
  {
    if (!getEnabled())
    {
      return;
    }

    setState(BFileState.inProgress);
    boolean success = processFile(cx);

    if (success)
    {
      setState(BFileState.success);
    }
    else
    {
      setState(BFileState.failure);
    }
  }

  private boolean processFile(Context cx)
  {
    return true;
  }
}
