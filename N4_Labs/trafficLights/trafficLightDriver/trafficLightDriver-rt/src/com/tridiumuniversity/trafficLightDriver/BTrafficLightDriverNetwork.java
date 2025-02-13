/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.Lexicon;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;

import com.tridiumuniversity.trafficLightDriver.comm.BTrafficLightDriverTcpCommConfig;
import com.tridiumuniversity.trafficLightDriver.learn.BTrafficLightDriverDeviceDiscoveryPreferences;
import com.tridiumuniversity.trafficLightDriver.message.req.TrafficLightDriverPingNetworkReq;

import javax.baja.sys.Action;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BTrafficLightDriverNetwork models a network of devices
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "pollScheduler",
  type = "BNPollScheduler",
  defaultValue = "new BNPollScheduler()"
)
@NiagaraProperty(
  name = "tcpConfig",
  type = "BTrafficLightDriverTcpCommConfig",
  defaultValue = "new BTrafficLightDriverTcpCommConfig()"
)
@NiagaraProperty(
  name = "discoveryPreferences",
  type = "BNDiscoveryPreferences",
  defaultValue = "new BTrafficLightDriverDeviceDiscoveryPreferences()",
  flags = Flags.HIDDEN
)

@NiagaraProperty(
        name="ipAddress",
        type="BIpAddress",
        defaultValue = "new BIpAddress(\"127.0.0.1\",23)"
        )
@NiagaraAction(
  name = "submitDiscoveryJob",
  defaultValue = "new BTrafficLightDriverDeviceDiscoveryPreferences()",
  parameterType = "BNDiscoveryPreferences",
  returnType = "BOrd",
  flags = Flags.HIDDEN
)
public class BTrafficLightDriverNetwork
  extends BNNetwork
  implements BINDiscoveryHost
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.BTrafficLightDriverNetwork(3696286921)1.0$ @*/
/* Generated Wed Feb 12 14:07:19 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "pollScheduler"

  /**
   * Slot for the {@code pollScheduler} property.
   * @see #getPollScheduler
   * @see #setPollScheduler
   */
  public static final Property pollScheduler = newProperty(0, new BNPollScheduler(), null);

  /**
   * Get the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }

  /**
   * Set the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public void setPollScheduler(BNPollScheduler v) { set(pollScheduler, v, null); }

  //endregion Property "pollScheduler"

  //region Property "tcpConfig"

  /**
   * Slot for the {@code tcpConfig} property.
   * @see #getTcpConfig
   * @see #setTcpConfig
   */
  public static final Property tcpConfig = newProperty(0, new BTrafficLightDriverTcpCommConfig(), null);

  /**
   * Get the {@code tcpConfig} property.
   * @see #tcpConfig
   */
  public BTrafficLightDriverTcpCommConfig getTcpConfig() { return (BTrafficLightDriverTcpCommConfig)get(tcpConfig); }

  /**
   * Set the {@code tcpConfig} property.
   * @see #tcpConfig
   */
  public void setTcpConfig(BTrafficLightDriverTcpCommConfig v) { set(tcpConfig, v, null); }

  //endregion Property "tcpConfig"

  //region Property "discoveryPreferences"

  /**
   * Slot for the {@code discoveryPreferences} property.
   * @see #getDiscoveryPreferences
   * @see #setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(Flags.HIDDEN, new BTrafficLightDriverDeviceDiscoveryPreferences(), null);

  /**
   * Get the {@code discoveryPreferences} property.
   * @see #discoveryPreferences
   */
  public BNDiscoveryPreferences getDiscoveryPreferences() { return (BNDiscoveryPreferences)get(discoveryPreferences); }

  /**
   * Set the {@code discoveryPreferences} property.
   * @see #discoveryPreferences
   */
  public void setDiscoveryPreferences(BNDiscoveryPreferences v) { set(discoveryPreferences, v, null); }

  //endregion Property "discoveryPreferences"

  //region Property "ipAddress"

  /**
   * Slot for the {@code ipAddress} property.
   * @see #getIpAddress
   * @see #setIpAddress
   */
  public static final Property ipAddress = newProperty(0, new BIpAddress("127.0.0.1",23), null);

  /**
   * Get the {@code ipAddress} property.
   * @see #ipAddress
   */
  public BIpAddress getIpAddress() { return (BIpAddress)get(ipAddress); }

  /**
   * Set the {@code ipAddress} property.
   * @see #ipAddress
   */
  public void setIpAddress(BIpAddress v) { set(ipAddress, v, null); }

  //endregion Property "ipAddress"

  //region Action "submitDiscoveryJob"

  /**
   * Slot for the {@code submitDiscoveryJob} action.
   * @see #submitDiscoveryJob(BNDiscoveryPreferences parameter)
   */
  public static final Action submitDiscoveryJob = newAction(Flags.HIDDEN, new BTrafficLightDriverDeviceDiscoveryPreferences(), null);

  /**
   * Invoke the {@code submitDiscoveryJob} action.
   * @see #submitDiscoveryJob
   */
  public BOrd submitDiscoveryJob(BNDiscoveryPreferences parameter) { return (BOrd)invoke(submitDiscoveryJob, parameter, null); }

  //endregion Action "submitDiscoveryJob"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverNetwork.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  /**
   * Specify name for network resources.
   */
  public String getNetworkName()
  {
    return "TrafficLightDriverNetwork";
  }

  /**
   * return device folder type
   */
  @Override
  public Type getDeviceFolderType()
  {
    return BTrafficLightDriverDeviceFolder.TYPE;
  }

  /**
   * return device type
   */
  @Override
  public Type getDeviceType()
  {
    return BTrafficLightDriverDevice.TYPE;
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
//BINDiscoveryHost
////////////////////////////////////////////////////////////////

  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs)
    throws Exception
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void doPing()
  {
    NMessage response;
    try
    {
      log.fine(() -> "Sending ping request to " + getIpAddress());
      response = tcomm().sendRequest(new TrafficLightDriverPingNetworkReq(getIpAddress()));
    }
    catch (Exception ex)
    {
      log.log(Level.WARNING, "Unable to complete ping request to " + getIpAddress(), ex);
      pingFail(ex.getLocalizedMessage());
      return;
    }

    if (!(response instanceof com.tridiumuniversity.trafficLightDriver.message.rsp.TrafficLightDriverPingNetworkResp))
    {
      String error = "Ping response from " + getIpAddress() + " had unexpected response type";
      log.warning(error);
      pingFail(lex.getText("ping.unexpectedResponseType"));
      return;
    }

    com.tridiumuniversity.trafficLightDriver.message.rsp.TrafficLightDriverPingNetworkResp pingResponse = (com.tridiumuniversity.trafficLightDriver.message.rsp.TrafficLightDriverPingNetworkResp)response;
    if (pingResponse.getPingSuccessful())
    {
      pingOk();
      log.fine(() -> "Ping to " + getIpAddress() + " was successful");
    }
    else
    {
      String error = "Ping from " + getIpAddress() + " failed";
      log.fine(() -> error);
      pingFail(lex.getText("ping.failed"));
    }
  }


  public BOrd doSubmitDiscoveryJob(BNDiscoveryPreferences preferences)
  {
    // Saves the most recent device discovery parameters
    setDiscoveryPreferences((BTrafficLightDriverDeviceDiscoveryPreferences) preferences.newCopy());
    // Instantiates an instance of BNDiscoveryJob
    BNDiscoveryJob job = new BNDiscoveryJob(this);
    // Passes the discovery parameters to the job
    job.setDiscoveryPreferences(preferences);
    // Submits the job and returns Ord
    return job.submit(null);
  }

////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////


  /**
   * Access the tcp comm stack
   */
  public NComm tcomm()
  {
    return (NComm) getTcpConfig().comm();
  }


  private Logger log = Logger.getLogger("trafficLightDriver");

  public static Lexicon lex = Lexicon.make(BTrafficLightDriverNetwork.class);
}
