/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.baja.alarm.BAlarmRecord;
import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
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
import javax.baja.util.BUuid;

@NiagaraType
@NiagaraProperty(
  name = "alarmUuid",
  type = "BUuid",
  defaultValue = "BUuid.DEFAULT"
)
@NiagaraAction(
  name = "processAlarm"
)
public class BAlarmExample2 extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BAlarmExample2(4111338760)1.0$ @*/
/* Generated Mon Oct 09 14:22:47 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "alarmUuid"

  /**
   * Slot for the {@code alarmUuid} property.
   * @see #getAlarmUuid
   * @see #setAlarmUuid
   */
  public static final Property alarmUuid = newProperty(0, BUuid.DEFAULT, null);

  /**
   * Get the {@code alarmUuid} property.
   * @see #alarmUuid
   */
  public BUuid getAlarmUuid() { return (BUuid)get(alarmUuid); }

  /**
   * Set the {@code alarmUuid} property.
   * @see #alarmUuid
   */
  public void setAlarmUuid(BUuid v) { set(alarmUuid, v, null); }

  //endregion Property "alarmUuid"

  //region Action "processAlarm"

  /**
   * Slot for the {@code processAlarm} action.
   * @see #processAlarm()
   */
  public static final Action processAlarm = newAction(0, null);

  /**
   * Invoke the {@code processAlarm} action.
   * @see #processAlarm
   */
  public void processAlarm() { invoke(processAlarm, null, null); }

  //endregion Action "processAlarm"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAlarmExample2.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doProcessAlarm(Context cx) throws IOException
  {
    String query = String.format("alarm:|bql:select * where uuid = '%s'", getAlarmUuid().encodeToString());
    @SuppressWarnings("unchecked")
    BITable<BAlarmRecord> alarmRecords = (BITable<BAlarmRecord>)BOrd.make(query)
      .get(null, cx);

    try (TableCursor<BAlarmRecord> cursor = alarmRecords.cursor())
    {
      if (!cursor.next())
        return;

      BAlarmRecord alarmRecord = cursor.get();
      processAlarmRecord(alarmRecord);
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
