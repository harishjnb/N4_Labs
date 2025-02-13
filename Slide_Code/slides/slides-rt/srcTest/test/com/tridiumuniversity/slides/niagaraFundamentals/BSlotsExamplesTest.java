package test.com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraType;

import com.tridiumuniversity.slides.niagaraFundamentals.BSlotsExamples;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

@NiagaraType
@Test
public class BSlotsExamplesTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.niagaraFundamentals.BSlotsExamplesTest(2979906276)1.0$ @*/
/* Generated Tue Sep 03 15:19:48 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSlotsExamplesTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testAddDynamicProperty()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    Assert.assertNull(slotsExamples.get("dynamicProperty"), "dynamicProperty shouldn't exist before action is invoked");
    slotsExamples.doAddDynamicProperty();
    Assert.assertNotNull(slotsExamples.get("dynamicProperty"), "dynamicProperty should exist after action is invoked");
  }

  public void testAddDynamicAction()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    Assert.assertNull(slotsExamples.getAction("dynamicAction"), "dynamicAction shouldn't exist before action is invoked");
    slotsExamples.doAddDynamicAction();
    Assert.assertNotNull(slotsExamples.getAction("dynamicAction"), "dynamicAction should exist after action is invoked");
  }

  public void testAddDynamicTopic()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    Assert.assertNull(slotsExamples.getTopic("dynamicTopic"), "dynamicTopic shouldn't exist before action is invoked");
    slotsExamples.doAddDynamicTopic();
    Assert.assertNotNull(slotsExamples.getTopic("dynamicTopic"), "dynamicTopic should exist after action is invoked");
  }

  public void testSetFrozenProperty()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    Assert.assertNotEquals(slotsExamples.getMyFrozenProperty(), "new value", "myFrozenProperty should not equal new value before action is invoked");
    slotsExamples.doSetFrozenProperty();
    Assert.assertEquals(slotsExamples.getMyFrozenProperty(), "new value", "myFrozenProperty should equal new value after action is invoked");
  }

  public void testSetDynamicProperty()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    slotsExamples.doAddDynamicProperty();
    Assert.assertNotEquals(((BString)slotsExamples.get("dynamicProperty")).getString(), "new value", "dynamicProperty should not have new value before action is invoked");
    slotsExamples.doSetDynamicProperty();
    Assert.assertEquals(((BString)slotsExamples.get("dynamicProperty")).getString(), "new value", "dynamicProperty should have new value after action is invoked");
  }

  public void testRemoveDynamicProperty()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    slotsExamples.doAddDynamicProperty();
    Assert.assertNotNull(slotsExamples.get("dynamicProperty"), "dynamicProperty should exist before action is invoked");
    slotsExamples.doRemoveDynamicProperty();
    Assert.assertNull(slotsExamples.get("dynamicProperty"), "dynamicProperty shouldn't exist after action is invoked");
  }

  public void testRemoveAllDynamicProperties()
  {
    BSlotsExamples slotsExamples = new BSlotsExamples();
    slotsExamples.add("dynamic1", new BComponent());
    slotsExamples.add("dynamic2", new BComponent());
    slotsExamples.add("dynamic3", new BComponent());
    slotsExamples.add("dynamic4", new BComponent());
    Assert.assertEquals(slotsExamples.getDynamicPropertiesArray().length, 4, "all dynamic properties should be present before they are removed");
    slotsExamples.doRemoveAllDynamicProperties();
    Assert.assertEquals(slotsExamples.getDynamicPropertiesArray().length, 0, "no dynamic properties should be present after they are removed");
  }
}
