/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.history.BHistoryConfig;
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
  name = "processHistories"
)
public class BProcessHistoriesExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BProcessHistoriesExample(3131656389)1.0$ @*/
/* Generated Mon Oct 09 10:51:56 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "processHistories"

  /**
   * Slot for the {@code processHistories} action.
   * @see #processHistories()
   */
  public static final Action processHistories = newAction(0, null);

  /**
   * Invoke the {@code processHistories} action.
   * @see #processHistories
   */
  public void processHistories() { invoke(processHistories, null, null); }

  //endregion Action "processHistories"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BProcessHistoriesExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doProcessHistories(Context cx)
  {
    @SuppressWarnings("unchecked")
    BITable<BHistoryConfig> histories = (BITable<BHistoryConfig>) BOrd.make("history:|bql:select *")
      .get(null, cx);

    try (TableCursor<BHistoryConfig> cursor = histories.cursor())
    {
      for (BHistoryConfig historyConfig : cursor)
      {
        processHistoryConfig(historyConfig);
      }
    }
  }

  public List<BHistoryConfig> getHistoryConfigs()
  {
    return Collections.unmodifiableList(historyConfigs);
  }

  private void processHistoryConfig(BHistoryConfig historyConfig)
  {
    historyConfigs.add(historyConfig);
  }

  private final List<BHistoryConfig> historyConfigs = new ArrayList<>();
}
