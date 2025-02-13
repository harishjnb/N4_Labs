/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.ordQueries;

import javax.baja.control.BNumericWritable;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BDouble;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.ordQueries.BBqlExample;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BBqlExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.ordQueries.BBqlExampleTest(2979906276)1.0$ @*/
/* Generated Mon Oct 09 10:14:01 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBqlExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void matchingPointTotalHonorsRegex()
  {
    BBqlExample bqlExample = new BBqlExample();
    bqlExample.setPointNameRegex("test1.?"); // match names of "test1" followed by zero or one character

    BNumericWritable test1 = new BNumericWritable();
    BNumericWritable test10 = new BNumericWritable();
    BNumericWritable test100 = new BNumericWritable();

    test1.set(BDouble.make(1));
    test10.set(BDouble.make(10));
    test100.set(BDouble.make(100));

    stationHandler.getStation().add("bqlExample", bqlExample);
    stationHandler.getStation().add("test1", test1);
    stationHandler.getStation().add("test10", test10);
    stationHandler.getStation().add("test100", test100);

    BDouble total = bqlExample.doComputeMatchingPointTotal(null);
    Assert.assertEquals(BDouble.make(11.0), total, "Total should only include NumericPoints whose names match the regex");
  }
}
