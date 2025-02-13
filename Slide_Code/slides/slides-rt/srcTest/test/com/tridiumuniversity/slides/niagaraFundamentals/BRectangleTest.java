/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.niagaraFundamentals.BRectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BRectangleTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.niagaraFundamentals.BRectangleTest(2979906276)1.0$ @*/
/* Generated Tue Jul 23 12:06:13 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRectangleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void areaUpdatesWithWidth()
  {
    BRectangle rectangle = new BRectangle();

    rectangle.setLength(1);
    rectangle.setWidth(1);
    rectangle.setArea(1);
    Assert.assertEquals(rectangle.getArea(), 1.0, "Area should have been initialized to 1 before test");

    rectangle.setWidth(3);
    Assert.assertEquals(rectangle.getArea(), 3.0, "Area should update when width updates");
  }

  public void areaUpdatesWithLength()
  {
    BRectangle rectangle = new BRectangle();

    rectangle.setLength(1);
    rectangle.setWidth(1);
    rectangle.setArea(1);
    Assert.assertEquals(rectangle.getArea(), 1.0, "Area should have been initialized to 1 before test");

    rectangle.setLength(3);
    Assert.assertEquals(rectangle.getArea(), 3.0, "Area should update when length updates");
  }
}
