/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import javax.baja.naming.BOrd;
import javax.baja.naming.OrdTarget;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.user.BUserService;

@NiagaraType
@NiagaraAction(
  name = "findMyComponent"
)
public class BOrdExample
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BOrdExample(3745976562)1.0$ @*/
/* Generated Mon Oct 09 10:04:47 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "findMyComponent"

  /**
   * Slot for the {@code findMyComponent} action.
   * @see #findMyComponent()
   */
  public static final Action findMyComponent = newAction(0, null);

  /**
   * Invoke the {@code findMyComponent} action.
   * @see #findMyComponent
   */
  public void findMyComponent() { invoke(findMyComponent, null, null); }

  //endregion Action "findMyComponent"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BOrdExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void doFindMyComponent(Context cx)
  {
    OrdTarget target1 = BOrd.make("local:|station:|slot:/Services/UserService").resolve(null, cx);
    OrdTarget target2 = BOrd.make("station:|slot:/Services/UserService").resolve(null, cx);
    OrdTarget target3 = BOrd.make("slot:/Services/UserService").resolve(Sys.getStation(), cx);

    BComponent servicesContainer = getServicesContainer(cx);
    OrdTarget target4 = BOrd.make("slot:UserService").resolve(servicesContainer, cx);

    if (target3.canRead())
    {
      BUserService userService = (BUserService)target3.get();
      System.out.println("Current logged in user has read permissiosn for UserService");
    }

    BUserService userService = (BUserService)BOrd.make("slot:/Services/UserService").get(Sys.getStation(), cx);

    System.out.println("Target 1:" + ((BComponent)target1.get()).getSlotPath());
    System.out.println("Target 2:" + ((BComponent)target2.get()).getSlotPath());
    System.out.println("Target 3:" + ((BComponent)target3.get()).getSlotPath());
    System.out.println("Target 4:" + ((BComponent)target4.get()).getSlotPath());
    System.out.println("User Service:" + userService.getSlotPath());
  }

  public BComponent getServicesContainer(Context cx)
  {
    return (BComponent)BOrd.make("slot:/Services").get(Sys.getStation(), cx);
  }
}
