/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.servicesAndMultithreaded;

import java.util.Optional;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BIService;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.servicesAndMultithreaded.BLookupServiceExample;
import com.tridiumuniversity.slides.servicesAndMultithreaded.BSimpleService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BLookupServiceExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.servicesAndMultithreaded.BLookupServiceExampleTest(2979906276)1.0$ @*/
/* Generated Tue Oct 10 08:34:02 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLookupServiceExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeMethod
  public void setupTest()
  {
    uninstallSimpleServiceIfPresent();
  }

  public void lookupServiceDoesNotFindServiceWhenItIsMissing()
  {
    BLookupServiceExample lookupServiceExample = new BLookupServiceExample();
    Assert.assertNull(lookupServiceExample.lookupService(),
      "lookupService should return null when there is no service");
  }

  public void lookupServiceFindsServiceWhenItIsPresent()
  {
    installSimpleService();
    BLookupServiceExample lookupServiceExample = new BLookupServiceExample();
    Assert.assertEquals(lookupServiceExample.lookupService(), simpleService);
  }

  public void lookupService2DoesNotFindServiceWhenItIsMissing()
  {
    BLookupServiceExample lookupServiceExample = new BLookupServiceExample();
    Assert.assertNull(lookupServiceExample.lookupService2(),
      "lookupService2 should return null when there is no service");
  }

  public void lookupService2FindsServiceWhenItIsPresent()
  {
    installSimpleService();
    BLookupServiceExample lookupServiceExample = new BLookupServiceExample();
    Assert.assertEquals(lookupServiceExample.lookupService2(), simpleService);
  }

  private void installSimpleService()
  {
    stationHandler.getStation().getServices().add("SimpleService", simpleService);
  }

  private void uninstallSimpleServiceIfPresent()
  {
    Optional<BIService> simpleServiceOpt = Sys.findService(BSimpleService.TYPE);
    simpleServiceOpt.ifPresent(simpleService -> stationHandler.getStation().getServices().remove((BSimpleService)simpleService));
  }

  private final BSimpleService simpleService = new BSimpleService();
}
