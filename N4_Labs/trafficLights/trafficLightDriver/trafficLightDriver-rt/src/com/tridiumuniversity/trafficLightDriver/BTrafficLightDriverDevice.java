/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.trafficLightDriver;

import javax.baja.control.BControlPoint;
import javax.baja.driver.util.BPollFrequency;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.Lexicon;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BIpAddress;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import com.tridiumuniversity.devTrafficLights.BTrafficLightState;
import com.tridiumuniversity.trafficLightDriver.message.req.TrafficLightDriverGetIntersectionReq;
import com.tridiumuniversity.trafficLightDriver.message.req.TrafficLightDriverPingIntersectionReq;
import com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverGetIntersectionResp;
import com.tridiumuniversity.trafficLightDriver.message.resp.TrafficLightDriverPingIntersectionResp;
import com.tridiumuniversity.trafficLightDriver.point.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BTrafficLightDriverDevice models a single device
 */
@NiagaraType
@NiagaraProperty(
        name = "pollFrequency",
        type = "BPollFrequency",
        defaultValue = "BPollFrequency.normal"
)
// Add facet to include following in auto manager view
@NiagaraProperty(
        name = "status",
        type = "BStatus",
        defaultValue = "BStatus.ok",
        flags = Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE,
        facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT_READONLY)"),
        override = true
)
@NiagaraProperty(
        name = "points",
        type = "BTrafficLightDriverPointDeviceExt",
        defaultValue = "new BTrafficLightDriverPointDeviceExt()"
)
@NiagaraProperty(
        name = "intersectionId",
        type = "String",
        defaultValue = "A",
        facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT)")
)
public class BTrafficLightDriverDevice
        extends BNDevice
        implements BINPollable
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.BTrafficLightDriverDevice(4144957637)1.0$ @*/
/* Generated Thu Feb 13 13:33:45 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "pollFrequency"

  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);

  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }

  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

  //endregion Property "pollFrequency"

  //region Property "status"

  /**
   * Slot for the {@code status} property.
   *  Add facet to include following in auto manager view
   * @see #getStatus
   * @see #setStatus
   */
  public static final Property status = newProperty(Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

  //endregion Property "status"

  //region Property "points"

  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BTrafficLightDriverPointDeviceExt(), null);

  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BTrafficLightDriverPointDeviceExt getPoints() { return (BTrafficLightDriverPointDeviceExt)get(points); }

  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BTrafficLightDriverPointDeviceExt v) { set(points, v, null); }

  //endregion Property "points"

  //region Property "intersectionId"

  /**
   * Slot for the {@code intersectionId} property.
   * @see #getIntersectionId
   * @see #setIntersectionId
   */
  public static final Property intersectionId = newProperty(0, "A", SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code intersectionId} property.
   * @see #intersectionId
   */
  public String getIntersectionId() { return getString(intersectionId); }

  /**
   * Set the {@code intersectionId} property.
   * @see #intersectionId
   */
  public void setIntersectionId(String v) { setString(intersectionId, v, null); }

  //endregion Property "intersectionId"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverDevice.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////

  /**
   * Returns the network type that the device runs on.
   *
   * @return Type object representing the network
   */
  @Override
  public Type getNetworkType()
  {
    return BTrafficLightDriverNetwork.TYPE;
  }

  @Override
  public void stopped()
          throws Exception
  {
    super.stopped();

    if (subscribedByDevice || subscribedByPoints)
    {
      getTrafficLightDriverNetwork().getPollScheduler().unsubscribe(this);
    }
  }

  @Override
  public void subscribed()
  {
    super.subscribed();

    if (!isRunning())
    {
      return;
    }

    if (!subscribedByPoints)
    {
      getTrafficLightDriverNetwork().getPollScheduler().subscribe(this);
    }
    subscribedByDevice = true;
  }

  @Override
  public void unsubscribed()
  {
    super.unsubscribed();

    if (!isRunning())
    {
      return;
    }

    if (!subscribedByPoints)
    {
      getTrafficLightDriverNetwork().getPollScheduler().unsubscribe(this);
    }
    subscribedByDevice = false;
  }


////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////

  @Override
  public void doPing()
  {
    String id = getIntersectionId();
    BTrafficLightDriverNetwork network = getTrafficLightDriverNetwork();
    BIpAddress ipAddress = network.getIpAddress();
    TrafficLightDriverPingIntersectionReq pingReq = new TrafficLightDriverPingIntersectionReq(ipAddress, id);

    NMessage response;
    try
    {
      log.fine(() -> "Sending ping request to device " + id + " at " + ipAddress);
      response = network.tcomm().sendRequest(pingReq);
    }
    catch(Exception ex)
    {
      log.log(Level.WARNING, "Unable to complete ping request to device " + id + " at " + ipAddress, ex);
      pingFail(ex.getLocalizedMessage());
      return;
    }

    if (!(response instanceof TrafficLightDriverPingIntersectionResp))
    {
      String error = "Ping response from device " + id + " at " + ipAddress + " had unexpected response type";
      log.warning(error);
      pingFail(lex.getText("ping.unexpectedResponseType"));
      return;
    }

    TrafficLightDriverPingIntersectionResp pingIntersectionResp = (TrafficLightDriverPingIntersectionResp)response;
    if (pingIntersectionResp.getPingSuccessful())
    {
      log.fine(() -> "Ping to device " + id + " at " + ipAddress + " was successful");
      pingOk();
    }
    else
    {
      String error = "Ping to device " + id + " at " + ipAddress + " failed";
      log.fine(() -> error);
      pingFail(lex.getText("ping.failed"));
    }
  }


////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  @Override
  public void doPoll()
  {
    if (!getEnabled())
    {
      log.fine("Skipping poll for device " + getIntersectionId() + " because device is disabled");
      return;
    }

    BStatus status = getStatus();
    if (status.isDown() || status.isFault() || status.isStale())
    {
      log.fine("Skipping poll for device " + getIntersectionId() + " because status is " + status);
      return;
    }

    BTrafficLightDriverNetwork network = getTrafficLightDriverNetwork();
    String id = getIntersectionId();
    BIpAddress ipAddress = network.getIpAddress();
    TrafficLightDriverGetIntersectionReq getReq = new TrafficLightDriverGetIntersectionReq(ipAddress, id);

    NMessage response;
    try
    {
      log.fine(() -> "Sending poll request to device " + id + " at " + ipAddress);
      response = network.tcomm().sendRequest(getReq);
    }
    catch (Exception ex)
    {
      log.log(Level.WARNING, "Failed to poll device " + id + " at " + ipAddress, ex);
      return;
    }

    if(!(response instanceof TrafficLightDriverGetIntersectionResp))
    {
      log.warning("Poll response from device " + id + " at " + ipAddress + " has unexpected type");
      return;
    }

    TrafficLightDriverGetIntersectionResp getResp = (TrafficLightDriverGetIntersectionResp)response;
    if (getResp.responseErrorOccurred())
    {
      log.warning("Poll to device " + id + " at " + ipAddress + " failed");
      return;
    }

    Map<String, BTrafficLightState> lightStates = getResp.getLightStates();
    for(BControlPoint point : getPoints().getPoints())
    {
      BTrafficLightDriverProxyExt proxyExt = (BTrafficLightDriverProxyExt)point.getProxyExt();
      if (lightStates.containsKey(proxyExt.getLightId().toLowerCase()))
      {
        BTrafficLightState lightState = lightStates.get(proxyExt.getLightId().toLowerCase());
        if (proxyExt.isNumeric())
        {
          log.finer(() -> "Setting point " + proxyExt.getLightId() + " on device " + id + " to " + lightState.getOrdinal());
          proxyExt.readOk(new BStatusNumeric(lightState.getOrdinal()));
        }
        else if (proxyExt.isString())
        {
          log.finer(() -> "Setting point " + proxyExt.getLightId() + " on device " + id + " to " + lightState.getTag());
          proxyExt.readOk(new BStatusString(lightState.getTag()));
        }
        else if (proxyExt.isEnum())
        {
          log.finer(() -> "Setting point " + proxyExt.getLightId() + " on device " + id + " to " + lightState);
          proxyExt.readOk(new BStatusEnum(lightState));
        }
        else
        {
          log.warning("Control point at " + point.getSlotPath() + " has invalid type");
          proxyExt.readFail(lex.get("poll.invalidType"));
        }
      }
      else
      {
        log.warning("Point with id " + proxyExt.getLightId() + " on device " + id + " was not found on remote device during polling");
        proxyExt.readFail(lex.getText("poll.notFound"));
      }
    }
  }

////////////////////////////////////////////////////////////////
// Utilities
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

  public void pointSubscribed(BTrafficLightDriverProxyExt proxyExt)
  {
    if (!subscribedByDevice)
    {
      getTrafficLightDriverNetwork().getPollScheduler().subscribe(this);
    }
    subscribedByPoints = true;
    subscribedPoints.add(proxyExt.getLightId());
  }

  public void pointUnsubscribed(BTrafficLightDriverProxyExt proxyExt)
  {
    subscribedPoints.remove(proxyExt.getLightId());
    if (subscribedPoints.isEmpty())
    {
      subscribedByPoints = false;
      if (!subscribedByDevice)
      {
        getTrafficLightDriverNetwork().getPollScheduler().unsubscribe(this);
      }
    }
  }

  // This device has been subscribed to and should be polling
  private boolean subscribedByDevice = false;

  // Points beneath this device have been subscribed to, so this device should be polling
  private boolean subscribedByPoints = false;

  // Points beneath this device that are currently in a subscribed state
  private static final Set<String> subscribedPoints = new HashSet<>();

  private static final Lexicon lex = Lexicon.make(BTrafficLightDriverDevice.class);
  private static final Logger log = Logger.getLogger("trafficLightDriver");
}
