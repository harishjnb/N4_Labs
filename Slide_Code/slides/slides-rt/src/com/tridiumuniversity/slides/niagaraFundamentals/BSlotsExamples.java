package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraTopic;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Slot;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.Action;
import javax.baja.sys.Property;
import javax.baja.sys.Topic;

@NiagaraType
@NiagaraProperty(
  name = "myFrozenProperty",
  type = "BString",
  defaultValue = "I'm a frozen Property!"
)
@NiagaraAction(
  name = "myFrozenAction"
)
@NiagaraTopic(
  name = "myFrozenTopic",
  eventType = "BString"
)
@NiagaraAction(
  name = "addDynamicProperty"
)
@NiagaraAction(
  name = "addDynamicAction"
)
@NiagaraAction(
  name = "addDynamicTopic"
)
@NiagaraAction(
  name = "printAllSlotNames"
)
@NiagaraAction(
  name = "printFrozenPropertyValue"
)
@NiagaraAction(
  name = "printDynamicPropertyValue"
)
@NiagaraAction(
  name = "setFrozenProperty"
)
@NiagaraAction(
  name = "setDynamicProperty"
)
@NiagaraAction(
  name = "removeDynamicProperty"
)
@NiagaraAction(
  name = "removeAllDynamicProperties"
)
public class BSlotsExamples
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BSlotsExamples(3508548097)1.0$ @*/
/* Generated Fri Nov 22 14:39:11 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Property "myFrozenProperty"

  /**
   * Slot for the {@code myFrozenProperty} property.
   * @see #getMyFrozenProperty
   * @see #setMyFrozenProperty
   */
  public static final Property myFrozenProperty = newProperty(0, "I'm a frozen Property!", null);

  /**
   * Get the {@code myFrozenProperty} property.
   * @see #myFrozenProperty
   */
  public String getMyFrozenProperty() { return getString(myFrozenProperty); }

  /**
   * Set the {@code myFrozenProperty} property.
   * @see #myFrozenProperty
   */
  public void setMyFrozenProperty(String v) { setString(myFrozenProperty, v, null); }

  //endregion Property "myFrozenProperty"

  //region Action "myFrozenAction"

  /**
   * Slot for the {@code myFrozenAction} action.
   * @see #myFrozenAction()
   */
  public static final Action myFrozenAction = newAction(0, null);

  /**
   * Invoke the {@code myFrozenAction} action.
   * @see #myFrozenAction
   */
  public void myFrozenAction() { invoke(myFrozenAction, null, null); }

  //endregion Action "myFrozenAction"

  //region Action "addDynamicProperty"

  /**
   * Slot for the {@code addDynamicProperty} action.
   * @see #addDynamicProperty()
   */
  public static final Action addDynamicProperty = newAction(0, null);

  /**
   * Invoke the {@code addDynamicProperty} action.
   * @see #addDynamicProperty
   */
  public void addDynamicProperty() { invoke(addDynamicProperty, null, null); }

  //endregion Action "addDynamicProperty"

  //region Action "addDynamicAction"

  /**
   * Slot for the {@code addDynamicAction} action.
   * @see #addDynamicAction()
   */
  public static final Action addDynamicAction = newAction(0, null);

  /**
   * Invoke the {@code addDynamicAction} action.
   * @see #addDynamicAction
   */
  public void addDynamicAction() { invoke(addDynamicAction, null, null); }

  //endregion Action "addDynamicAction"

  //region Action "addDynamicTopic"

  /**
   * Slot for the {@code addDynamicTopic} action.
   * @see #addDynamicTopic()
   */
  public static final Action addDynamicTopic = newAction(0, null);

  /**
   * Invoke the {@code addDynamicTopic} action.
   * @see #addDynamicTopic
   */
  public void addDynamicTopic() { invoke(addDynamicTopic, null, null); }

  //endregion Action "addDynamicTopic"

  //region Action "printAllSlotNames"

  /**
   * Slot for the {@code printAllSlotNames} action.
   * @see #printAllSlotNames()
   */
  public static final Action printAllSlotNames = newAction(0, null);

  /**
   * Invoke the {@code printAllSlotNames} action.
   * @see #printAllSlotNames
   */
  public void printAllSlotNames() { invoke(printAllSlotNames, null, null); }

  //endregion Action "printAllSlotNames"

  //region Action "printFrozenPropertyValue"

  /**
   * Slot for the {@code printFrozenPropertyValue} action.
   * @see #printFrozenPropertyValue()
   */
  public static final Action printFrozenPropertyValue = newAction(0, null);

  /**
   * Invoke the {@code printFrozenPropertyValue} action.
   * @see #printFrozenPropertyValue
   */
  public void printFrozenPropertyValue() { invoke(printFrozenPropertyValue, null, null); }

  //endregion Action "printFrozenPropertyValue"

  //region Action "printDynamicPropertyValue"

  /**
   * Slot for the {@code printDynamicPropertyValue} action.
   * @see #printDynamicPropertyValue()
   */
  public static final Action printDynamicPropertyValue = newAction(0, null);

  /**
   * Invoke the {@code printDynamicPropertyValue} action.
   * @see #printDynamicPropertyValue
   */
  public void printDynamicPropertyValue() { invoke(printDynamicPropertyValue, null, null); }

  //endregion Action "printDynamicPropertyValue"

  //region Action "setFrozenProperty"

  /**
   * Slot for the {@code setFrozenProperty} action.
   * @see #setFrozenProperty()
   */
  public static final Action setFrozenProperty = newAction(0, null);

  /**
   * Invoke the {@code setFrozenProperty} action.
   * @see #setFrozenProperty
   */
  public void setFrozenProperty() { invoke(setFrozenProperty, null, null); }

  //endregion Action "setFrozenProperty"

  //region Action "setDynamicProperty"

  /**
   * Slot for the {@code setDynamicProperty} action.
   * @see #setDynamicProperty()
   */
  public static final Action setDynamicProperty = newAction(0, null);

  /**
   * Invoke the {@code setDynamicProperty} action.
   * @see #setDynamicProperty
   */
  public void setDynamicProperty() { invoke(setDynamicProperty, null, null); }

  //endregion Action "setDynamicProperty"

  //region Action "removeDynamicProperty"

  /**
   * Slot for the {@code removeDynamicProperty} action.
   * @see #removeDynamicProperty()
   */
  public static final Action removeDynamicProperty = newAction(0, null);

  /**
   * Invoke the {@code removeDynamicProperty} action.
   * @see #removeDynamicProperty
   */
  public void removeDynamicProperty() { invoke(removeDynamicProperty, null, null); }

  //endregion Action "removeDynamicProperty"

  //region Action "removeAllDynamicProperties"

  /**
   * Slot for the {@code removeAllDynamicProperties} action.
   * @see #removeAllDynamicProperties()
   */
  public static final Action removeAllDynamicProperties = newAction(0, null);

  /**
   * Invoke the {@code removeAllDynamicProperties} action.
   * @see #removeAllDynamicProperties
   */
  public void removeAllDynamicProperties() { invoke(removeAllDynamicProperties, null, null); }

  //endregion Action "removeAllDynamicProperties"

  //region Topic "myFrozenTopic"

  /**
   * Slot for the {@code myFrozenTopic} topic.
   * @see #fireMyFrozenTopic
   */
  public static final Topic myFrozenTopic = newTopic(0, null);

  /**
   * Fire an event for the {@code myFrozenTopic} topic.
   * @see #myFrozenTopic
   */
  public void fireMyFrozenTopic(BString event) { fire(myFrozenTopic, event, null); }

  //endregion Topic "myFrozenTopic"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSlotsExamples.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doMyFrozenAction()
  {
    System.out.println("My frozen action was invoked");
  }

  public void doAddDynamicProperty()
  {
    add("dynamicProperty", BString.make("I'm a dynamic Property!"));
  }

  public void doAddDynamicAction()
  {
    add("dynamicAction", new BCustomAction());
  }

  public void doAddDynamicTopic()
  {
    add("dynamicTopic", new BCustomTopic());
  }

  public void doPrintAllSlotNames()
  {
    for(Slot slot : getSlots())
    {
      System.out.println(slot.getName());
    }
  }

  public void doPrintFrozenPropertyValue()
  {
//    BString frozenPropertyValue = (BString)get("frozenProperty");
//    System.out.println(frozenPropertyValue);
    System.out.println(getMyFrozenProperty());
  }

  public void doPrintDynamicPropertyValue()
  {
    BString dynamicPropertyValue = (BString)get("dynamicProperty");
    if (dynamicPropertyValue != null)
    {
      System.out.println(dynamicPropertyValue);
    }
  }

  public void doSetFrozenProperty()
  {
//    set("myFrozenProperty", BString.make("new value"));
    setMyFrozenProperty("new value");
  }

  public void doSetDynamicProperty()
  {
    set("dynamicProperty", BString.make("new value"));
  }

  public void doRemoveDynamicProperty()
  {
    remove("dynamicProperty");
  }

  public void doRemoveAllDynamicProperties()
  {
    removeAll();
  }
}
