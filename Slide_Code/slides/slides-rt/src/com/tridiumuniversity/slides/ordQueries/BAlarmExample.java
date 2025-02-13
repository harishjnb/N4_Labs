/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.baja.alarm.BAlarmRecord;
import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BIObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraAction(
  name = "processAlarms"
)
public class BAlarmExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BAlarmExample(1458235164)1.0$ @*/
/* Generated Mon Oct 09 14:05:05 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "processAlarms"

  /**
   * Slot for the {@code processAlarms} action.
   * @see #processAlarms()
   */
  public static final Action processAlarms = newAction(0, null);

  /**
   * Invoke the {@code processAlarms} action.
   * @see #processAlarms
   */
  public void processAlarms() { invoke(processAlarms, null, null); }

  //endregion Action "processAlarms"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAlarmExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doProcessAlarms(Context cx)
  {
    @SuppressWarnings("unchecked")
    BITable<BAlarmRecord> alarms = (BITable<BAlarmRecord>) BOrd.make("alarm:|bql:select *")
      .get(null, cx);

    try(TableCursor<BAlarmRecord> cursor = alarms.cursor())
    {
      for (BAlarmRecord alarmRecord : cursor)
      {
        // NOTE: For memory efficiency, a cursor over BAlarmRecords will return the same instance of BAlarmRecord
        // in every iteration, changing only the values. Since we're saving the records in a list, we need to make a
        // new copy of them
        BAlarmRecord savedAlarmRecord = (BAlarmRecord)alarmRecord.newCopy();
        processAlarmRecord(savedAlarmRecord);
      }
    }
  }

  public List<BAlarmRecord> getAlarmRecords()
  {
    return Collections.unmodifiableList(alarmRecords);
  }

  private void processAlarmRecord(BAlarmRecord alarmRecord)
  {
    alarmRecords.add(alarmRecord);
  }

  private final List<BAlarmRecord> alarmRecords = new ArrayList<>();
}
