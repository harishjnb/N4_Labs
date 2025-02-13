package test.com.tridiumuniversity.slides.workbenchDevelopment;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BString;

import com.tridiumuniversity.slides.workbenchDevelopment.BStringTokenizer;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

@NiagaraType
@Test
public class BStringTokenizerTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.workbenchDevelopment.BStringTokenizerTest(2979906276)1.0$ @*/
/* Generated Tue Aug 13 16:02:30 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BStringTokenizerTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void splitsStringAndAddsDynamicSlots()
  {
    BStringTokenizer stringTokenizer = new BStringTokenizer();
    stationHandler.getStation().add("stringTokenizer", stringTokenizer);
    stringTokenizer.setString("my test string");
    stringTokenizer.setDelimiter(" ");

    Assert.assertEquals(stringTokenizer.getPropertyCount(), 5, "dynamic slots should have been added");
    Assert.assertEquals(stringTokenizer.get("token"), BString.make("my"), "dynamic slots should be split based on delimiter");
    Assert.assertEquals(stringTokenizer.get("token1"), BString.make("test"), "dynamic slots should be split based on delimiter");
    Assert.assertEquals(stringTokenizer.get("token2"), BString.make("string"), "dynamic slots should be split based on delimiter");
  }
}
