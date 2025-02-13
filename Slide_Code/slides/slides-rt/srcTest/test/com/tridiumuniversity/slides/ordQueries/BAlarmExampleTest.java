/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.ordQueries;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.baja.alarm.AlarmDbConnection;
import javax.baja.alarm.BAlarmDatabase;
import javax.baja.alarm.BAlarmRecord;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;
import javax.baja.util.BUuid;

import com.tridiumuniversity.slides.ordQueries.BAlarmExample;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BAlarmExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.ordQueries.BAlarmExampleTest(2979906276)1.0$ @*/
/* Generated Mon Oct 09 13:50:03 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAlarmExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testAlarmProcessing()
    throws IOException
  {
    BUuid uuid1 = BUuid.make();
    BUuid uuid2 = BUuid.make();
    BUuid uuid3 = BUuid.make();

    BAlarmRecord record1 = new BAlarmRecord(uuid1);
    BAlarmRecord record2 = new BAlarmRecord(uuid2);
    BAlarmRecord record3 = new BAlarmRecord(uuid3);

    createAlarms(Arrays.asList(record1, record2, record3));

    BAlarmExample alarmExample = new BAlarmExample();
    stationHandler.getStation().add("alarmExample", alarmExample);
    alarmExample.doProcessAlarms(null);

    List<BAlarmRecord> alarmRecords = alarmExample.getAlarmRecords();

    Assert.assertTrue(alarmRecords.stream().anyMatch(alarmRecord -> alarmRecord.getUuid().equals(uuid1)),
      "Record 1 should have been processed");
    Assert.assertTrue(alarmRecords.stream().anyMatch(alarmRecord -> alarmRecord.getUuid().equals(uuid2)),
      "Record 2 should have been processed");
    Assert.assertTrue(alarmRecords.stream().anyMatch(alarmRecord -> alarmRecord.getUuid().equals(uuid3)),
      "Record 3 should have been processed");
  }

  private void createAlarms(List<BAlarmRecord> alarmRecords)
    throws IOException
  {
    BAlarmDatabase alarmDatabase = getAlarmService().getAlarmDb();
    try(AlarmDbConnection connection = alarmDatabase.getDbConnection(null))
    {
      for (BAlarmRecord alarmRecord : alarmRecords)
      {
        connection.append(alarmRecord);
      }
    }
  }
}
