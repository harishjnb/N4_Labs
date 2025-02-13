package com.tridiumuniversity.slides.niagaraFundamentals;

import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraAction(
  name = "addNameWithSpaces"
)
@NiagaraAction(
  name = "addEscapedNameWithSpaces"
)
@NiagaraAction(
  name = "addHappiness"
)
@NiagaraAction(
  name = "addChild"
)
@NiagaraAction(
  name = "addUniqueChild"
)
public class BSlotAdder
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.niagaraFundamentals.BSlotAdder(1934864233)1.0$ @*/
/* Generated Wed Sep 04 09:12:23 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Action "addNameWithSpaces"

  /**
   * Slot for the {@code addNameWithSpaces} action.
   * @see #addNameWithSpaces()
   */
  public static final Action addNameWithSpaces = newAction(0, null);

  /**
   * Invoke the {@code addNameWithSpaces} action.
   * @see #addNameWithSpaces
   */
  public void addNameWithSpaces() { invoke(addNameWithSpaces, null, null); }

  //endregion Action "addNameWithSpaces"

  //region Action "addEscapedNameWithSpaces"

  /**
   * Slot for the {@code addEscapedNameWithSpaces} action.
   * @see #addEscapedNameWithSpaces()
   */
  public static final Action addEscapedNameWithSpaces = newAction(0, null);

  /**
   * Invoke the {@code addEscapedNameWithSpaces} action.
   * @see #addEscapedNameWithSpaces
   */
  public void addEscapedNameWithSpaces() { invoke(addEscapedNameWithSpaces, null, null); }

  //endregion Action "addEscapedNameWithSpaces"

  //region Action "addHappiness"

  /**
   * Slot for the {@code addHappiness} action.
   * @see #addHappiness()
   */
  public static final Action addHappiness = newAction(0, null);

  /**
   * Invoke the {@code addHappiness} action.
   * @see #addHappiness
   */
  public void addHappiness() { invoke(addHappiness, null, null); }

  //endregion Action "addHappiness"

  //region Action "addChild"

  /**
   * Slot for the {@code addChild} action.
   * @see #addChild()
   */
  public static final Action addChild = newAction(0, null);

  /**
   * Invoke the {@code addChild} action.
   * @see #addChild
   */
  public void addChild() { invoke(addChild, null, null); }

  //endregion Action "addChild"

  //region Action "addUniqueChild"

  /**
   * Slot for the {@code addUniqueChild} action.
   * @see #addUniqueChild()
   */
  public static final Action addUniqueChild = newAction(0, null);

  /**
   * Invoke the {@code addUniqueChild} action.
   * @see #addUniqueChild
   */
  public void addUniqueChild() { invoke(addUniqueChild, null, null); }

  //endregion Action "addUniqueChild"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSlotAdder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void doAddNameWithSpaces()
  {
    // This will throw an IllegalNameException
    add("a name with spaces", new BComponent());
  }

  public void doAddEscapedNameWithSpaces()
  {
    add(SlotPath.escape("a name with spaces"), new BComponent());
  }

  public void doAddHappiness()
  {
    add(SlotPath.escape("幸福"), new BComponent());
  }

  public void doAddChild()
  {
    // This will throw a DuplicateSlotException if a slot named "child" already exists
    add("child", new BComponent());
  }

  public void doAddUniqueChild()
  {
    add("child?", new BComponent());
  }
}
