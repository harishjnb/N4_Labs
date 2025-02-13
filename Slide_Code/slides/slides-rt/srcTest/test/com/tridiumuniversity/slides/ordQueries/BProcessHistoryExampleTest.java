/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.ordQueries;

import java.util.Arrays;
import java.util.List;

import javax.baja.history.BHistoryConfig;
import javax.baja.history.BHistoryId;
import javax.baja.history.BHistoryRecord;
import javax.baja.history.BHistoryService;
import javax.baja.history.BIHistory;
import javax.baja.history.BNumericTrendRecord;
import javax.baja.history.HistorySpaceConnection;
import javax.baja.history.db.BHistoryDatabase;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.sys.BAbsTime;
import javax.baja.sys.BRelTime;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;
import javax.baja.util.BTypeSpec;

import com.tridiumuniversity.slides.ordQueries.BProcessHistoryExample;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BProcessHistoryExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.ordQueries.BProcessHistoryExampleTest(2979906276)1.0$ @*/
/* Generated Mon Oct 09 11:53:38 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BProcessHistoryExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeClass
  public void setup()
    throws Exception
  {
    historyService = (BHistoryService)Sys.getService(BHistoryService.TYPE);
  }

  public void testHistoryProcessing()
  {
    // Create a historyConfig with id /testDevice/testHistory
    BTypeSpec numericTypeSpec = BTypeSpec.make(BNumericTrendRecord.TYPE);
    BHistoryId historyId = BHistoryId.make("testDevice", "testHistory");
    BHistoryConfig historyConfig = new BHistoryConfig(historyId, numericTypeSpec);

    // Create some fake records to add to our history
    BAbsTime yesterday = BAbsTime.now().subtract(BRelTime.DAY);
    BNumericTrendRecord record1 = new BNumericTrendRecord().set(yesterday, 1, BStatus.ok);
    BNumericTrendRecord record2 = new BNumericTrendRecord().set(yesterday.add(BRelTime.MINUTE), 2, BStatus.ok);
    BNumericTrendRecord record3 = new BNumericTrendRecord().set(yesterday.add(BRelTime.HOUR), 3, BStatus.ok);

    createHistoryWithRecords(historyConfig, Arrays.asList(record1, record2, record3));

    BProcessHistoryExample processHistoryExample = new BProcessHistoryExample();
    processHistoryExample.setHistoryId(historyId);
    stationHandler.getStation().add("processHistoryExample", processHistoryExample);
    processHistoryExample.doProcessHistory(null);

    List<BHistoryRecord> historyRecords = processHistoryExample.getHistoryRecords();

    Assert.assertTrue(historyRecords.stream().anyMatch(historyRecord -> recordsAreSame((BNumericTrendRecord)historyRecord, record1)),
      "Record 1 should have been processed");
    Assert.assertTrue(historyRecords.stream().anyMatch(historyRecord -> recordsAreSame((BNumericTrendRecord)historyRecord, record2)),
      "Record 2 should have been processed");
    Assert.assertTrue(historyRecords.stream().anyMatch(historyRecord -> recordsAreSame((BNumericTrendRecord)historyRecord, record3)),
      "Record 3 should have been processed");
  }

  private boolean recordsAreSame(BNumericTrendRecord record1, BNumericTrendRecord record2)
  {
    return record1.getTimestamp().equals(record2.getTimestamp()) &&
      record1.getValue() == record2.getValue() &&
      record1.getStatus().equals(record2.getStatus());
  }

  private void createHistoryWithRecords(BHistoryConfig historyConfig, List<BHistoryRecord> historyRecords)
  {
    BHistoryDatabase historyDatabase = historyService.getDatabase();
    try (HistorySpaceConnection connection = historyDatabase.getDbConnection(null))
    {
      connection.createHistory(historyConfig);
      BIHistory history = connection.getHistory(historyConfig.getId());
      for(BHistoryRecord historyRecord : historyRecords)
      {
        connection.append(history, historyRecord);
      }
    }
  }

  private BHistoryService historyService;
}
