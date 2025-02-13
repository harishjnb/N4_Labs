/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.niagaraFundamentals.BComponentArray;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BComponentArrayTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.niagaraFundamentals.BComponentArrayTest(2979906276)1.0$ @*/
/* Generated Tue Jul 23 12:07:31 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BComponentArrayTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void componentChildrenAffectSize()
  {
    BComponentArray array = new BComponentArray();
    Assert.assertEquals(array.getSize(), 0, "A new component array should have a size of 0");

    array.add("test", new BComponent());
    Assert.assertEquals(array.getSize(), 1, "Adding a component should increment size");

    array.remove("test");
    Assert.assertEquals(array.getSize(), 0, "Removing a component should decrement size");
  }

  public void nonComponentChildrenDoNotAffectSize()
  {
    BComponentArray array = new BComponentArray();
    Assert.assertEquals(array.getSize(), 0, "A new component array should have a size of 0");

    array.add("test", BString.make("test"));
    Assert.assertEquals(array.getSize(), 0, "Adding a non-component should not change size");

    array.remove("test");
    Assert.assertEquals(array.getSize(), 0, "Removing a non-component should not change size");
  }
}
