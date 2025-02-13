/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.ordQueries;

import static javax.baja.test.permissions.PermissionsScenario.withPermissions;

import javax.baja.naming.BOrd;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.role.BRole;
import javax.baja.security.BPermissionsMap;
import javax.baja.sys.BObject;
import javax.baja.sys.BasicContext;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;
import javax.baja.user.BUser;

import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BUserSchemeTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.ordQueries.BUserSchemeTest(2979906276)1.0$ @*/
/* Generated Fri Oct 27 16:04:49 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUserSchemeTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Test(
    expectedExceptions = UnresolvedException.class,
    expectedExceptionsMessageRegExp = "Cannot find user nonexistentUser"
  )
  public void throwsUnresolvedExceptionForNonexistentUser()
  {
    if (getUserService().get("nonexistentUser") != null)
    {
      getUserService().remove("nonexistentUser");
    }

    BOrd.make("userDemo:nonexistentUser").get(stationHandler.getStation());
  }

  public void resolvesToUserForExistingUser()
  {
    BUser user = addUser("testUser", "");

    BObject object = BOrd.make("userDemo:testUser").get(stationHandler.getStation());

    Assert.assertTrue(object instanceof BUser, "User scheme should only resolve to a type of BUser");
    Assert.assertSame(object, user, "User scheme should resolve to correct user");
  }

  @Test(
    expectedExceptions = UnresolvedException.class,
    expectedExceptionsMessageRegExp = "Cannot find User Service"
  )
  public void userWithoutPermissionCannotGetUserService()
  {
    userPermissionsScenario(
      withPermissions("").onOrd("service:baja:UserService")
    ).actAsUser((user) -> {
        BasicContext basicContext = new BasicContext(user);
        BOrd.make("userDemo:testUser").get(stationHandler.getStation(), basicContext);
      });
  }

  @Test(
    expectedExceptions = UnresolvedException.class,
    expectedExceptionsMessageRegExp = "Cannot find user testUser"
  )
  public void userWithoutPermissionCannotGetUser()
  {
    userPermissionsScenario(
      withPermissions("R").onOrd("service:baja:UserService"),
      withPermissions("").onOrd("service:baja:UserService|slot:testUser")
    ).actAsUser((user) -> {
      BasicContext basicContext = new BasicContext(user);
      BOrd.make("userDemo:testUser").get(stationHandler.getStation(), basicContext);
    });
  }

  @Override
  protected BUser addUser(String name, String roles)
  {
    if (getUserService().get(name) != null)
    {
      getUserService().remove(name);
    }
    return super.addUser(name, roles);
  }

  @Override
  protected BRole addRole(String name, BPermissionsMap permissionsMap)
  {
    if (getRoleService().get(name) != null)
    {
      getRoleService().remove(name);
    }
    return super.addRole(name, permissionsMap);
  }
}
