/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.control.BNumericPoint;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BIObject;
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
  name = "buildMatchingPointArray"
)
public class BBqlExample2 extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BBqlExample2(708898213)1.0$ @*/
/* Generated Mon Oct 09 10:34:51 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

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

  //region Action "buildMatchingPointArray"

  /**
   * Slot for the {@code buildMatchingPointArray} action.
   * @see #buildMatchingPointArray()
   */
  public static final Action buildMatchingPointArray = newAction(0, null);

  /**
   * Invoke the {@code buildMatchingPointArray} action.
   * @see #buildMatchingPointArray
   */
  public void buildMatchingPointArray() { invoke(buildMatchingPointArray, null, null); }

  //endregion Action "buildMatchingPointArray"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBqlExample2.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doBuildMatchingPointArray(Context cx)
  {
    Pattern regex = Pattern.compile(getPointNameRegex());
    @SuppressWarnings("unchecked")
    BITable<BNumericPoint> table = (BITable<BNumericPoint>) BOrd.make(
      "bql:select from control:NumericPoint"
    ).get(Sys.getStation(), cx);

    try (TableCursor<BNumericPoint> cursor = table.cursor())
    {
      while (cursor.next())
      {
        BNumericPoint point = cursor.get();
        if (regex.matcher(point.getName()).matches())
        {
          array.add(point);
        }
      }
    }

    // Alternative iteration using TableCursor with for-each loop
//    try (TableCursor<BNumericPoint> cursor = table.cursor())
//    {
//      for (BNumericPoint point : cursor)
//      {
//        if (regex.matcher(point.getName()).matches())
//        {
//          array.add(point);
//        }
//      }
//    }

    // Alternative iteration using TableCursor with stream
//    try (TableCursor<BNumericPoint> cursor = table.cursor())
//    {
//      cursor.stream()
//        .filter(point -> regex.matcher(point.getName()).matches())
//        .forEach(array::add);
//    }
  }

  public List<BNumericPoint> getArray()
  {
    return Collections.unmodifiableList(array);
  }

  private final List<BNumericPoint> array = new ArrayList<>();
}
