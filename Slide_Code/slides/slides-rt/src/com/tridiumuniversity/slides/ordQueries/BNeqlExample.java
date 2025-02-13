/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import java.util.HashMap;
import java.util.Map;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.query.BQueryResult;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Entity;
import javax.baja.tag.Id;

@NiagaraType
@NiagaraAction(
  name = "findHistorySources"
)
public class BNeqlExample
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BNeqlExample(1687897765)1.0$ @*/
/* Generated Mon Oct 09 15:59:31 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "findHistorySources"

  /**
   * Slot for the {@code findHistorySources} action.
   * @see #findHistorySources()
   */
  public static final Action findHistorySources = newAction(0, null);

  /**
   * Invoke the {@code findHistorySources} action.
   * @see #findHistorySources
   */
  public void findHistorySources() { invoke(findHistorySources, null, null); }

  //endregion Action "findHistorySources"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNeqlExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doFindHistorySources(Context cx)
  {
    BQueryResult result = (BQueryResult)BOrd.make("neql:n:history").get(Sys.getStation(), cx);

    result.stream().forEach(this::processEntity);
  }

  public Map<String, String> getHistorySourceMap()
  {
    return historySourceMap;
  }

  private void processEntity(Entity entity)
  {
    BComponent component = (BComponent)entity;
    Id historyTagId = Id.newId("n", "history");
    BString historyName = (BString)component.tags().get(historyTagId).orElse(BString.DEFAULT);
    historySourceMap.put(component.getName(), historyName.getString());
  }

  private final Map<String, String> historySourceMap = new HashMap<>();
}
