/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BInteger;
import javax.baja.sys.Context;
import javax.baja.sys.IPropertyValidator;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.Validatable;
import javax.baja.util.CannotValidateException;

@NiagaraType
@NiagaraProperty(
  name = "number",
  type = "int",
  defaultValue = "0"
)
public class BEvensOnly
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BEvensOnly(3015285771)1.0$ @*/
/* Generated Tue Jul 23 12:11:04 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "number"

  /**
   * Slot for the {@code number} property.
   * @see #getNumber
   * @see #setNumber
   */
  public static final Property number = newProperty(0, 0, null);

  /**
   * Get the {@code number} property.
   * @see #number
   */
  public int getNumber() { return getInt(number); }

  /**
   * Set the {@code number} property.
   * @see #number
   */
  public void setNumber(int v) { setInt(number, v, null); }

  //endregion Property "number"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEvensOnly.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public IPropertyValidator getPropertyValidator(Property property, Context cx)
  {
    return new EvenPropertyValidator();
  }

  private static class EvenPropertyValidator implements IPropertyValidator
  {
    @Override
    public void validateSet(Validatable validatable, Context context)
    {
      int pendingValue = ((BInteger)validatable.getProposedValue(number)).getInt();
      if (pendingValue % 2 != 0)
        throw new CannotValidateException();
    }
  }
}
