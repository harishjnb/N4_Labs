/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.IllegalChildException;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.niagaraFundamentals.BThing;
import com.tridiumuniversity.slides.niagaraFundamentals.BThingContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BThingContainerTest extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.niagaraFundamentals.BThingContainerTest(2979906276)1.0$ @*/
/* Generated Tue Jul 23 12:09:06 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BThingContainerTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void canHaveThingContainerChildren()
  {
    BThingContainer container1 = new BThingContainer();
    BThingContainer container2 = new BThingContainer();

    container1.add("container", container2);
  }

  public void canHaveThingChildren()
  {
    BThingContainer container = new BThingContainer();
    BThing thing = new BThing();

    container.add("thing", thing);
  }

  public void cannotHaveOtherChildren()
  {
    BThingContainer container = new BThingContainer();
    BComponent component = new BComponent();

    Assert.assertThrows(IllegalChildException.class, () -> container.add("component", component));
  }
}
