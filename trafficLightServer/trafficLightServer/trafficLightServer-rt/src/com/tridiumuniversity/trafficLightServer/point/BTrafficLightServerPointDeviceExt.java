/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer.point;

import com.tridium.ndriver.util.AgentInfoUtil;
import com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice;
import com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetwork;

import javax.baja.agent.AgentList;
import javax.baja.driver.point.BPointDeviceExt;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.TypeNotFoundException;

/**
 * BTrafficLightServerPointDeviceExt is a container for trafficLightServer proxy points.
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
@NiagaraType
public class BTrafficLightServerPointDeviceExt
  extends BPointDeviceExt
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.point.BTrafficLightServerPointDeviceExt(2979906276)1.0$ @*/
/* Generated Fri Aug 25 11:08:21 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerPointDeviceExt.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  /**
   * Adds BNPointManager and renames.
   *
   * @see AgentInfoUtil#getAgentsHelp
   */
  public AgentList getAgents(Context cx)
  {
    AgentList agents = super.getAgents(cx);
    agents.add("ndriver:NPointManager");
    agents.add("ndriver:NPointUxManager");

    try {
      AgentInfoUtil.getAgentsHelp(
        agents,
        getType().getTypeInfo().getModuleName(),
        "ndriver:NPointUxManager",
        "PointUxManager",
        "Point Ux Manager"
      );
    }
    catch (TypeNotFoundException ex)
    {
      // OK if ndriver:NPointUxManager doesn't exist, ie ux profile not supported
    }

    return AgentInfoUtil.getAgentsHelp(
      agents,
      getType().getTypeInfo().getModuleName(),
      "ndriver:NPointManager",
      "PointManager",
      "Point Manager"
    );
  }

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrafficLightServerNetwork.
   *
   * @return network as a BTrafficLightServerNetwork.
   */
  public final BTrafficLightServerNetwork getTrafficLightServerNetwork()
  {
    return (BTrafficLightServerNetwork) getNetwork();
  }

  /**
   * Get the device cast to a BTrafficLightServerDevice.
   *
   * @return device as a BTrafficLightServerDevice.
   */
  public final BTrafficLightServerDevice getTrafficLightServerDevice()
  {
    return (BTrafficLightServerDevice) getDevice();
  }

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////

  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BTrafficLightServerDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BTrafficLightServerPointFolder.TYPE;
  }

  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BTrafficLightServerProxyExt.TYPE;
  }

}
