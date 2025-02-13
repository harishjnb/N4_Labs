package com.tridiumuniversity.slides.workbenchDevelopment;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "string",
  type = "BString",
  defaultValue = "BString.DEFAULT"
)
@NiagaraProperty(
  name = "delimiter",
  type = "BString",
  defaultValue = "BString.DEFAULT"
)
public class BStringTokenizer extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.workbenchDevelopment.BStringTokenizer(3471935962)1.0$ @*/
/* Generated Tue Aug 13 16:02:29 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "string"

  /**
   * Slot for the {@code string} property.
   * @see #getString
   * @see #setString
   */
  public static final Property string = newProperty(0, BString.DEFAULT, null);

  /**
   * Get the {@code string} property.
   * @see #string
   */
  public String getString() { return getString(string); }

  /**
   * Set the {@code string} property.
   * @see #string
   */
  public void setString(String v) { setString(string, v, null); }

  //endregion Property "string"

  //region Property "delimiter"

  /**
   * Slot for the {@code delimiter} property.
   * @see #getDelimiter
   * @see #setDelimiter
   */
  public static final Property delimiter = newProperty(0, BString.DEFAULT, null);

  /**
   * Get the {@code delimiter} property.
   * @see #delimiter
   */
  public String getDelimiter() { return getString(delimiter); }

  /**
   * Set the {@code delimiter} property.
   * @see #delimiter
   */
  public void setDelimiter(String v) { setString(delimiter, v, null); }

  //endregion Property "delimiter"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BStringTokenizer.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void changed(Property p, Context cx)
  {
    if (!isRunning())
      return;

    if (string.equals(p) || delimiter.equals(p))
    {
      String s = getString();
      String[] tokens = s.split(getDelimiter());

      removeAll(cx);
      for (String token : tokens)
      {
        add("token?", BString.make(token), Flags.READONLY | Flags.TRANSIENT);
      }
    }
  }
}
