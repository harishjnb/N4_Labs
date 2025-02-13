/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.servicesAndMultithreaded;

import java.util.Optional;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BIService;
import javax.baja.sys.ServiceNotFoundException;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BLookupServiceExample extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.servicesAndMultithreaded.BLookupServiceExample(2979906276)1.0$ @*/
/* Generated Tue Oct 10 08:34:02 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLookupServiceExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BSimpleService lookupService()
  {
    try
    {
      return (BSimpleService)Sys.getService(BSimpleService.TYPE);
    }
    catch (ServiceNotFoundException ex)
    {
      return null;
    }
  }

  public BSimpleService lookupService2()
  {
    Optional<BIService> optExampleService = Sys.findService(BSimpleService.TYPE);
    return (BSimpleService)optExampleService.orElse(null);
  }
}
