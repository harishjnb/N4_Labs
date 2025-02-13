/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.ordQueries;

import java.util.Map;
import java.util.Optional;

import javax.baja.control.BNumericWritable;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BIService;
import javax.baja.sys.BStation;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Tag;
import javax.baja.tagdictionary.BTagDictionaryService;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.ordQueries.BNeqlExample;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BNeqlExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.ordQueries.BNeqlExampleTest(2979906276)1.0$ @*/
/* Generated Mon Oct 09 14:35:51 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNeqlExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  protected void configureTestStation(BStation station, String stationName, int webPort, int foxPort)
    throws Exception
  {
    super.configureTestStation(station, stationName, webPort, foxPort);

    // Install TagDictionaryService
    BTagDictionaryService tagDictionaryService;
    Optional<BIService> tagDictionaryServiceOpt = Sys.findService(BTagDictionaryService.TYPE);
    if (!tagDictionaryServiceOpt.isPresent())
    {
      tagDictionaryService = new BTagDictionaryService();
      stationHandler.getStation().getServices().add("TagDictionaryService", tagDictionaryService);
    }
  }

  public void findsHistorySources()
  {
    Tag history1Tag = Tag.newTag("n:history", "history1");
    BNumericWritable source1 = new BNumericWritable();
    source1.tags().set(history1Tag);

    Tag history2Tag = Tag.newTag("n:history", "history2");
    BNumericWritable source2 = new BNumericWritable();
    source2.tags().set(history2Tag);

    BNumericWritable notSource = new BNumericWritable();

    BNeqlExample neqlExample = new BNeqlExample();

    stationHandler.getStation().add("source1", source1);
    stationHandler.getStation().add("source2", source2);
    stationHandler.getStation().add("notSource", notSource);
    stationHandler.getStation().add("neqlExample", neqlExample);

    neqlExample.doFindHistorySources(null);
    Map<String, String> historySourceMap = neqlExample.getHistorySourceMap();

    Assert.assertTrue(historySourceMap.containsKey(source1.getName()), "History source 1 should have been saved");
    Assert.assertEquals(historySourceMap.get(source1.getName()), "history1",
      "History source 1 should be associated with correct history name");

    Assert.assertTrue(historySourceMap.containsKey(source2.getName()), "History source 2 should have been saved");
    Assert.assertEquals(historySourceMap.get(source2.getName()), "history2",
      "History source 2 should be associated with correct history name");

    Assert.assertFalse(historySourceMap.containsKey(notSource.getName()), "Non-history source should not have been saved");
  }
}
