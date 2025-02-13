/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.util.regex.Pattern;

import javax.baja.collection.BITable;
import javax.baja.collection.Column;
import javax.baja.collection.ColumnList;
import javax.baja.collection.TableCursor;
import javax.baja.control.BNumericPoint;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BDouble;
import javax.baja.sys.BIObject;
import javax.baja.sys.BString;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(
  name = "pointNameRegex",
  type = "String",
  defaultValue = "\".*\""
)
@NiagaraAction(
  name = "computeMatchingPointTotal",
  returnType = "BDouble"
)
public class BBqlExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BBqlExample(2117827262)1.0$ @*/
/* Generated Mon Oct 09 10:10:58 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "pointNameRegex"

  /**
   * Slot for the {@code pointNameRegex} property.
   * @see #getPointNameRegex
   * @see #setPointNameRegex
   */
  public static final Property pointNameRegex = newProperty(0, ".*", null);

  /**
   * Get the {@code pointNameRegex} property.
   * @see #pointNameRegex
   */
  public String getPointNameRegex() { return getString(pointNameRegex); }

  /**
   * Set the {@code pointNameRegex} property.
   * @see #pointNameRegex
   */
  public void setPointNameRegex(String v) { setString(pointNameRegex, v, null); }

  //endregion Property "pointNameRegex"

  //region Action "computeMatchingPointTotal"

  /**
   * Slot for the {@code computeMatchingPointTotal} action.
   * @see #computeMatchingPointTotal()
   */
  public static final Action computeMatchingPointTotal = newAction(0, null);

  /**
   * Invoke the {@code computeMatchingPointTotal} action.
   * @see #computeMatchingPointTotal
   */
  public BDouble computeMatchingPointTotal() { return (BDouble)invoke(computeMatchingPointTotal, null, null); }

  //endregion Action "computeMatchingPointTotal"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBqlExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BDouble doComputeMatchingPointTotal(Context cx)
  {
    Pattern regex = Pattern.compile(getPointNameRegex());
    @SuppressWarnings("unchecked")
    BITable<BNumericPoint> table = (BITable<BNumericPoint>) BOrd.make(
      "bql:select name, out.value from control:NumericPoint"
    ).get(Sys.getStation(), cx);

    ColumnList columns = table.getColumns();
    Column nameColumn = columns.get("name");
    Column valueColumn = columns.get("out.value");

    double total = 0.0;
    try (TableCursor<BNumericPoint> cursor = table.cursor())
    {
      while (cursor.next())
      {
        String name = ((BString) cursor.cell(nameColumn)).getString();
        double value = ((BDouble) cursor.cell(valueColumn)).getDouble();
        if (regex.matcher(name).matches())
          total += value;
      }
    }

    return BDouble.make(total);
  }
}
