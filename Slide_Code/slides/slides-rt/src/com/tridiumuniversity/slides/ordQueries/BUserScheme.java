/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ordQueries;

import javax.baja.naming.BISession;
import javax.baja.naming.BOrd;
import javax.baja.naming.BOrdScheme;
import javax.baja.naming.BServiceScheme;
import javax.baja.naming.InvalidOrdBaseException;
import javax.baja.naming.OrdQuery;
import javax.baja.naming.OrdQueryList;
import javax.baja.naming.OrdTarget;
import javax.baja.naming.SyntaxException;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BValue;
import javax.baja.sys.ModuleNotFoundException;
import javax.baja.sys.ServiceNotFoundException;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.TypeNotFoundException;
import javax.baja.user.BUser;
import javax.baja.user.BUserService;

@NiagaraType(
  ordScheme = "userDemo"
)
@NiagaraSingleton
public class BUserScheme
  extends BOrdScheme
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ordQueries.BUserScheme(3317569899)1.0$ @*/
/* Generated Wed Nov 29 13:02:11 EST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BUserScheme INSTANCE = new BUserScheme();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUserScheme.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private BUserScheme()
  {
    super("userDemo");
  }

  @Override
  public OrdQuery parse(String queryBody)
  {
    return new UserQuery(queryBody);
  }

  @Override
  public OrdTarget resolve(OrdTarget base, OrdQuery ordQuery)
    throws SyntaxException, UnresolvedException
  {
    BUserService userService = null;

    try
    {
      BISession session = BOrd.toSession(base.get());
      if (session == null)
        throw new InvalidOrdBaseException("" + base);
      if (!(session instanceof BServiceScheme.ServiceSession))
        throw new InvalidOrdBaseException("Session does not support services");
      userService = (BUserService)((BServiceScheme.ServiceSession)session).getService(BUserService.TYPE);
    }
    catch (ModuleNotFoundException | TypeNotFoundException | ServiceNotFoundException ex)
    {
    }

    OrdTarget userServiceTarget = new OrdTarget(base, userService);
    if (userService == null || !userServiceTarget.canRead())
    {
      throw new UnresolvedException("Cannot find User Service");
    }

    userService.loadSlots();
    BValue user = userService.get(ordQuery.getBody());
    OrdTarget userTarget = new OrdTarget(base, user);
    if (!(user instanceof BUser) || !userTarget.canRead())
    {
      throw new UnresolvedException("Cannot find user " + ordQuery.getBody());
    }

    return userTarget;
  }

  public static class UserQuery implements OrdQuery
  {
    public UserQuery(String body)
    {
      this.body = body;
    }

    @Override
    public String getScheme() { return "userDemo"; }

    @Override
    public String getBody() { return body; }

    @Override
    public boolean isHost() { return false; }

    @Override
    public boolean isSession() { return false; }

    @Override
    public void normalize(OrdQueryList ordQueryList, int index)
    {
      ordQueryList.shiftToSession(index);
    }

    private final String body;
  }
}
