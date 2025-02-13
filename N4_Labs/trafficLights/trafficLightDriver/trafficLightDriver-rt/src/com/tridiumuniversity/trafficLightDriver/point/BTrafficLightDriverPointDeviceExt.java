/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.point;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.Lexicon;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.point.*;

import com.tridiumuniversity.trafficLightDriver.*;
import com.tridiumuniversity.trafficLightDriver.message.req.TrafficLightDriverDiscoverReq;
import com.tridiumuniversity.trafficLightDriver.message.rsp.TrafficLightDriverDiscoverResp;

import java.util.List;
import java.util.Map;

import static com.tridiumuniversity.trafficLightDriver.BTrafficLightDriverNetwork.lex;

/**
 * BTrafficLightDriverPointDeviceExt is a container for trafficLightDriver proxy points.
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "discoveryPreferences",
  type = "BTrafficLightDriverPointDiscoveryPreferences",
  defaultValue = "new BTrafficLightDriverPointDiscoveryPreferences()",
  override = true
)
public class BTrafficLightDriverPointDeviceExt
  extends BNPointDeviceExt
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.point.BTrafficLightDriverPointDeviceExt(881751269)1.0$ @*/
/* Generated Wed Feb 12 11:41:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "discoveryPreferences"

  /**
   * Slot for the {@code discoveryPreferences} property.
   * @see #getDiscoveryPreferences
   * @see #setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(0, new BTrafficLightDriverPointDiscoveryPreferences(), null);

  //endregion Property "discoveryPreferences"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverPointDeviceExt.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrafficLightDriverNetwork.
   *
   * @return network as a BTrafficLightDriverNetwork.
   */
  public final BTrafficLightDriverNetwork getTrafficLightDriverNetwork()
  {
    return (BTrafficLightDriverNetwork) getNetwork();
  }

  /**
   * Get the device cast to a BTrafficLightDriverDevice.
   *
   * @return device as a BTrafficLightDriverDevice.
   */
  public final BTrafficLightDriverDevice getTrafficLightDriverDevice()
  {
    return (BTrafficLightDriverDevice) getDevice();
  }

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////

  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BTrafficLightDriverDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BTrafficLightDriverPointFolder.TYPE;
  }

  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BTrafficLightDriverProxyExt.TYPE;
  }

////////////////////////////////////////////////////////////////
//BINDiscoveryHost
////////////////////////////////////////////////////////////////

  /**
   * Call back for discoveryJob to get an array of discovery objects.
   * Override point for driver specific discovery.
   */
  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs)
    throws Exception
  {
    if (!prefs.getJob().isAlive())
    {
      return null;
    }

    BIpAddress address = getTrafficLightDriverNetwork().getIpAddress();
    NMessage response = getTrafficLightDriverNetwork().tcomm().sendRequest(new TrafficLightDriverDiscoverReq(address));

    if (!(response instanceof TrafficLightDriverDiscoverResp))
    {
      prefs.getJob().discoverFail(lex.getText("discover.unexpectedResponseType"));
      return null;
    }

    TrafficLightDriverDiscoverResp discoverResp = (TrafficLightDriverDiscoverResp)response;
    Map<String, List<String>> intersectionLightMap = discoverResp.getIntersectionLightMap();
    List<String> lights = intersectionLightMap.get(getTrafficLightDriverDevice().getIntersectionId().toLowerCase());

    BINDiscoveryObject[] discoveredPoints = new BINDiscoveryObject[lights.size()];
    int i = 0;
    for(String lightId : lights)
    {
      prefs.getJob().log().message("trafficLightDriver", "discover.discoveredPoint.id", lightId);
      discoveredPoints[i++] = new BTrafficLightDriverPointDiscoveryLeaf(lightId);
    }

    return discoveredPoints;
  }
  private static final Lexicon lex = Lexicon.make(BTrafficLightDriverNetwork.class);
}
