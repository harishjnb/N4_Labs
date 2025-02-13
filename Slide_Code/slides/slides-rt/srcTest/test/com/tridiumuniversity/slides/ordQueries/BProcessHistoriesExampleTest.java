/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.ordQueries;

import java.util.Arrays;
import java.util.List;

import javax.baja.history.BHistoryConfig;
import javax.baja.history.BHistoryId;
import javax.baja.history.BHistoryService;
import javax.baja.history.BNumericTrendRecord;
import javax.baja.history.HistorySpaceConnection;
import javax.baja.history.db.BHistoryDatabase;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;
import javax.baja.util.BTypeSpec;

import com.tridiumuniversity.slides.ordQueries.BProcessHistoriesExample;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BProcessHistoriesExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.ordQueries.BProcessHistoriesExampleTest(2979906276)1.0$ @*/
/* Generated Mon Oct 09 10:51:56 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BProcessHistoriesExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeClass
  public void setup()
    throws Exception
  {
    // The HistoryService is guaranteed to exist since this is a subclass of BTestNgStation
    historyService = (BHistoryService)Sys.getService(BHistoryService.TYPE);
  }

  public void testHistoriesProcessing()
  {
    BTypeSpec numericTypeSpec = BTypeSpec.make(BNumericTrendRecord.TYPE);

    BHistoryId historyId1 = BHistoryId.make("testDevice", "testHistory1");
    BHistoryId historyId2 = BHistoryId.make("testDevice", "testHistory2");
    BHistoryId historyId3 = BHistoryId.make("testDevice", "testHistory3");

    BHistoryConfig historyConfig1 = new BHistoryConfig(historyId1, numericTypeSpec);
    BHistoryConfig historyConfig2 = new BHistoryConfig(historyId2, numericTypeSpec);
    BHistoryConfig historyConfig3 = new BHistoryConfig(historyId3, numericTypeSpec);

    createHistories(Arrays.asList(historyConfig1, historyConfig2, historyConfig3));

    BProcessHistoriesExample processHistoriesExample = new BProcessHistoriesExample();
    stationHandler.getStation().add("processHistoriesExample", processHistoriesExample);
    processHistoriesExample.doProcessHistories(null);

    // Note: These historyConfigs are different than the above three - these are the historyConfigs created by the
    // framework for the histories themselves. It's similar to how a HistoryExt has a historyConfig, but the actual
    // history will have its own historyConfig.
    List<BHistoryConfig> historyConfigs = processHistoriesExample.getHistoryConfigs();

    // Since we can't just check that the list contains our three historyConfigs, we check that the list contains
    // historyConfigs with the correct historyIds
    Assert.assertTrue(historyConfigs.stream().anyMatch(historyConfig -> historyConfig.getId().equals(historyId1)),
      "All histories should be processed");
    Assert.assertTrue(historyConfigs.stream().anyMatch(historyConfig -> historyConfig.getId().equals(historyId2)),
      "All histories should be processed");
    Assert.assertTrue(historyConfigs.stream().anyMatch(historyConfig -> historyConfig.getId().equals(historyId3)),
      "All histories should be processed");
  }

  private void createHistories(List<BHistoryConfig> historyConfigs)
  {
    BHistoryDatabase historyDatabase = historyService.getDatabase();
    try (HistorySpaceConnection connection = historyDatabase.getDbConnection(null))
    {
      for (BHistoryConfig historyConfig : historyConfigs)
      {
        connection.createHistory(historyConfig);
      }
    }
  }

  private BHistoryService historyService;
}
