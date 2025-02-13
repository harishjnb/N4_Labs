/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import java.util.HashMap;
import java.util.Map;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.spy.SpyWriter;
import javax.baja.sys.Action;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "optionName",
  type = "BString",
  defaultValue = "BString.DEFAULT"
)
@NiagaraAction(
  name = "addOption",
  parameterType = "BBoolean",
  defaultValue = "BBoolean.DEFAULT"
)
@NiagaraAction(
  name = "setOption",
  parameterType = "BBoolean",
  defaultValue = "BBoolean.DEFAULT"
)
@NiagaraAction(
  name = "removeOption"
)
public class BSpyExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.moduleDevelopment.BSpyExample(2564384833)1.0$ @*/
/* Generated Wed Nov 29 13:02:11 EST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "optionName"

  /**
   * Slot for the {@code optionName} property.
   * @see #getOptionName
   * @see #setOptionName
   */
  public static final Property optionName = newProperty(0, BString.DEFAULT, null);

  /**
   * Get the {@code optionName} property.
   * @see #optionName
   */
  public String getOptionName() { return getString(optionName); }

  /**
   * Set the {@code optionName} property.
   * @see #optionName
   */
  public void setOptionName(String v) { setString(optionName, v, null); }

  //endregion Property "optionName"

  //region Action "addOption"

  /**
   * Slot for the {@code addOption} action.
   * @see #addOption(BBoolean parameter)
   */
  public static final Action addOption = newAction(0, BBoolean.DEFAULT, null);

  /**
   * Invoke the {@code addOption} action.
   * @see #addOption
   */
  public void addOption(BBoolean parameter) { invoke(addOption, parameter, null); }

  //endregion Action "addOption"

  //region Action "setOption"

  /**
   * Slot for the {@code setOption} action.
   * @see #setOption(BBoolean parameter)
   */
  public static final Action setOption = newAction(0, BBoolean.DEFAULT, null);

  /**
   * Invoke the {@code setOption} action.
   * @see #setOption
   */
  public void setOption(BBoolean parameter) { invoke(setOption, parameter, null); }

  //endregion Action "setOption"

  //region Action "removeOption"

  /**
   * Slot for the {@code removeOption} action.
   * @see #removeOption()
   */
  public static final Action removeOption = newAction(0, null);

  /**
   * Invoke the {@code removeOption} action.
   * @see #removeOption
   */
  public void removeOption() { invoke(removeOption, null, null); }

  //endregion Action "removeOption"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpyExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  @Override
  public void spy(SpyWriter out) throws Exception
  {
    out.startProps();
    out.trTitle("Options", 2);
    for(Map.Entry<String, Boolean> option : options.entrySet())
    {
      out.prop(option.getKey(), option.getValue());
    }
    out.endProps();

    super.spy(out);
  }

  public void doAddOption(BBoolean optionValue, Context cx)
  {
    addOption(getOptionName(), optionValue.getBoolean());
  }

  public void doSetOption(BBoolean optionValue, Context cx)
  {
    setOption(getOptionName(), optionValue.getBoolean());
  }

  public void doRemoveOption(Context cx)
  {
    removeOption(getOptionName());
  }

  private void addOption(String key, Boolean value)
  {
    options.put(key, value);
  }

  private void setOption(String key, Boolean value)
  {
    if (options.containsKey(key))
    {
      options.put(key, value);
    }
  }

  private void removeOption(String key)
  {
    options.remove(key);
  }

  private Boolean getOption(String key)
  {
    return options.get(key);
  }

  private final Map<String, Boolean> options = new HashMap<>();
}
