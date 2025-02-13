/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.history.BHistoryId;
import javax.baja.history.BHistoryRecord;
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
  name = "historyId",
  type = "BHistoryId",
  defaultValue = "BHistoryId.DEFAULT"
)
@NiagaraAction(
  name = "processHistory"
)
public class BProcessHistoryExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BProcessHistoryExample(1849541991)1.0$ @*/
/* Generated Mon Oct 09 11:50:51 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "historyId"

  /**
   * Slot for the {@code historyId} property.
   * @see #getHistoryId
   * @see #setHistoryId
   */
  public static final Property historyId = newProperty(0, BHistoryId.DEFAULT, null);

  /**
   * Get the {@code historyId} property.
   * @see #historyId
   */
  public BHistoryId getHistoryId() { return (BHistoryId)get(historyId); }

  /**
   * Set the {@code historyId} property.
   * @see #historyId
   */
  public void setHistoryId(BHistoryId v) { set(historyId, v, null); }

  //endregion Property "historyId"

  //region Action "processHistory"

  /**
   * Slot for the {@code processHistory} action.
   * @see #processHistory()
   */
  public static final Action processHistory = newAction(0, null);

  /**
   * Invoke the {@code processHistory} action.
   * @see #processHistory
   */
  public void processHistory() { invoke(processHistory, null, null); }

  //endregion Action "processHistory"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BProcessHistoryExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doProcessHistory(Context cx)
  {
    String query = String.format("history:%s|bql:select *", getHistoryId().encodeToString());
    @SuppressWarnings("unchecked")
    BITable<BHistoryRecord> historyRecords = (BITable<BHistoryRecord>) BOrd.make(query).get(null, cx);

    try (TableCursor<BHistoryRecord> cursor = historyRecords.cursor())
    {
      for (BHistoryRecord historyRecord : cursor)
      {
        // NOTE: For memory efficiency, a cursor over BHistoryRecords will return the same instance of BHistoryRecord
        // in every iteration, changing only the values. Since we're saving the records in a list, we need to make a
        // new copy of them
        BHistoryRecord savedHistoryRecord = (BHistoryRecord)historyRecord.newCopy();
        processHistoryRecord(savedHistoryRecord);
      }
    }
  }

  public List<BHistoryRecord> getHistoryRecords()
  {
    return Collections.unmodifiableList(historyRecords);
  }

  private void processHistoryRecord(BHistoryRecord record)
  {
    historyRecords.add(record);
  }

  private final List<BHistoryRecord> historyRecords = new ArrayList<>();
}
