package test.com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.DuplicateSlotException;
import javax.baja.sys.IllegalNameException;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.niagaraFundamentals.BSlotAdder;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@Test
public class BSlotAdderTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.niagaraFundamentals.BSlotAdderTest(2979906276)1.0$ @*/
/* Generated Wed Sep 04 09:10:23 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSlotAdderTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testAddNameWithSpaces()
  {
    BSlotAdder slotAdder = new BSlotAdder();
    Assert.assertThrows(IllegalNameException.class, slotAdder::doAddNameWithSpaces);
  }

  public void testAddEscapedNameWithSpaces()
  {
    BSlotAdder slotAdder = new BSlotAdder();
    Assert.assertNull(slotAdder.get(SlotPath.escape("a name with spaces")));
    slotAdder.doAddEscapedNameWithSpaces();
    Assert.assertNotNull(slotAdder.get(SlotPath.escape("a name with spaces")));
  }

  public void testAddHappiness()
  {
    BSlotAdder slotAdder = new BSlotAdder();
    Assert.assertNull(slotAdder.get(SlotPath.escape("幸福")));
    slotAdder.doAddHappiness();
    Assert.assertNotNull(slotAdder.get(SlotPath.escape("幸福")));
  }

  public void testAddChild()
  {
    BSlotAdder slotAdder = new BSlotAdder();
    Assert.assertNull(slotAdder.get("child"));
    slotAdder.doAddChild();
    Assert.assertNotNull(slotAdder.get("child"));
    Assert.assertThrows(DuplicateSlotException.class, slotAdder::doAddChild);
  }

  public void testAddUniqueChild()
  {
    BSlotAdder slotAdder = new BSlotAdder();
    Assert.assertNull(slotAdder.get("child"));
    Assert.assertNull(slotAdder.get("child1"));

    slotAdder.doAddUniqueChild();
    Assert.assertNotNull(slotAdder.get("child"));
    Assert.assertNull(slotAdder.get("child1"));

    slotAdder.doAddUniqueChild();
    Assert.assertNotNull(slotAdder.get("child"));
    Assert.assertNotNull(slotAdder.get("child1"));
  }
}
