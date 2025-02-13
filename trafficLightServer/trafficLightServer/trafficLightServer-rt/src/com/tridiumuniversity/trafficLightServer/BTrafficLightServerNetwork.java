/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightServer;

import java.util.Optional;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.Lexicon;

import com.tridiumuniversity.trafficLightServer.comm.BTrafficLightServerTcpCommConfig;
import com.tridiumuniversity.trafficLightServer.comm.TrafficLightServerListener;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.NComm;
import com.tridium.ndriver.comm.NMessage;

/**
 * BTrafficLightServerNetwork models a network of devices
 *
 * @author tridiumuniversity on 25 Aug 2023
 */
@NiagaraType
@NiagaraProperty(
  name = "tcpConfig",
  type = "BTrafficLightServerTcpCommConfig",
  defaultValue = "new BTrafficLightServerTcpCommConfig()"
)
public class BTrafficLightServerNetwork
  extends BNNetwork
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetwork(2060121005)1.0$ @*/
/* Generated Fri Aug 25 11:19:18 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "tcpConfig"

  /**
   * Slot for the {@code tcpConfig} property.
   * @see #getTcpConfig
   * @see #setTcpConfig
   */
  public static final Property tcpConfig = newProperty(0, new BTrafficLightServerTcpCommConfig(), null);

  /**
   * Get the {@code tcpConfig} property.
   * @see #tcpConfig
   */
  public BTrafficLightServerTcpCommConfig getTcpConfig() { return (BTrafficLightServerTcpCommConfig)get(tcpConfig); }

  /**
   * Set the {@code tcpConfig} property.
   * @see #tcpConfig
   */
  public void setTcpConfig(BTrafficLightServerTcpCommConfig v) { set(tcpConfig, v, null); }

  //endregion Property "tcpConfig"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerNetwork.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
@Override
public void started()
  throws Exception
{
  super.started();
  getTcpConfig().setDefaultListener(new TrafficLightServerListener(getTcpConfig()));
}

  /**
   * Specify name for network resources.
   */
  public String getNetworkName()
  {
    return "TrafficLightServerNetwork";
  }

  /**
   * return device folder type
   */
  @Override
  public Type getDeviceFolderType()
  {
    return BTrafficLightServerDeviceFolder.TYPE;
  }

  /**
   * return device type
   */
  @Override
  public Type getDeviceType()
  {
    return BTrafficLightServerDevice.TYPE;
  }

  /* TODO - Add license check if needed
  @Override
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */

  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if (!isRunning())
    {
      return;
    }

    if (p == status)
    {
      // Give any comms opportunity to respond to status changes
      getTcpConfig().statusUpdate();
    }
  }
////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////


  /**
   * Access the tcp comm stack
   */
  public NComm tcomm()
  {
    return (NComm)getTcpConfig().comm();
  }

  public void sendMessage(NMessage message)
    throws Exception
  {
    tcomm().sendMessage(message);
  }

  public boolean deviceIsUp(String intersectionId)
  {
    Optional<BTrafficLightServerDevice> deviceOpt = getDevice(intersectionId);
    if (!deviceOpt.isPresent())
    {
      return false;
    }
    BTrafficLightServerDevice device = deviceOpt.get();
    return deviceIsUp(device);
  }

  public boolean deviceIsUp(BTrafficLightServerDevice device)
  {
    return device.getEnabled() && device.getStatus().isOk();
  }

  public Optional<BTrafficLightServerDevice> getDevice(String intersectionId)
  {
    return getBDeviceList()
      .stream()
      .filter(device -> device instanceof BTrafficLightServerDevice)
      .map(device -> (BTrafficLightServerDevice)device)
      .filter(device -> device.getIntersectionId().equalsIgnoreCase(intersectionId))
      .findFirst();
  }

  public static Lexicon LEX = Lexicon.make(BTrafficLightServerNetwork.class);
}
