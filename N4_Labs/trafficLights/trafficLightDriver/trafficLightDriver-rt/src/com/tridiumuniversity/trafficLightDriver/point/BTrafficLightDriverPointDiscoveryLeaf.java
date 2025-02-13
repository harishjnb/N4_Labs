/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.point;

import javax.baja.control.BBooleanPoint;
import javax.baja.control.BBooleanWritable;
import javax.baja.control.BControlPoint;
import javax.baja.control.BEnumPoint;
import javax.baja.control.BEnumWritable;
import javax.baja.control.BNumericPoint;
import javax.baja.control.BNumericWritable;
import javax.baja.control.BStringPoint;
import javax.baja.control.BStringWritable;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.util.Array;
import javax.baja.registry.TypeInfo;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.status.BStatusValue;
import javax.baja.sys.*;

import com.tridium.ndriver.discover.BNPointDiscoveryLeaf;
import com.tridium.ndriver.util.SfUtil;
import com.tridiumuniversity.devTrafficLights.BTrafficLightState;

/**
 * BTrafficLightDriverPointDiscoveryLeaf is container class for point elements to display in
 * point discovery pane and pass to new point callback.
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "statusValue",
  type = "BStatusValue",
  defaultValue = "new BStatusEnum()",
  flags = Flags.READONLY
)
@NiagaraProperty(
  name = "facets",
  type = "BFacets",
  defaultValue = "BFacets.DEFAULT",
  flags = Flags.READONLY,
  facets = @Facet(name = "SfUtil.KEY_MGR", value = "SfUtil.MGR_UNSEEN")
)
@NiagaraProperty(
        name = "lightId",
        type = "String",
        defaultValue = "\"\"",
        facets = @Facet("SfUtil.incl()")
)
public class BTrafficLightDriverPointDiscoveryLeaf
  extends BNPointDiscoveryLeaf
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.point.BTrafficLightDriverPointDiscoveryLeaf(1530619367)1.0$ @*/
/* Generated Thu Feb 13 15:15:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "statusValue"

  /**
   * Slot for the {@code statusValue} property.
   * @see #getStatusValue
   * @see #setStatusValue
   */
  public static final Property statusValue = newProperty(Flags.READONLY, new BStatusEnum(), null);

  /**
   * Get the {@code statusValue} property.
   * @see #statusValue
   */
  public BStatusValue getStatusValue() { return (BStatusValue)get(statusValue); }

  /**
   * Set the {@code statusValue} property.
   * @see #statusValue
   */
  public void setStatusValue(BStatusValue v) { set(statusValue, v, null); }

  //endregion Property "statusValue"

  //region Property "facets"

  /**
   * Slot for the {@code facets} property.
   * @see #getFacets
   * @see #setFacets
   */
  public static final Property facets = newProperty(Flags.READONLY, BFacets.DEFAULT, BFacets.make(SfUtil.KEY_MGR, SfUtil.MGR_UNSEEN));

  /**
   * Get the {@code facets} property.
   * @see #facets
   */
  public BFacets getFacets() { return (BFacets)get(facets); }

  /**
   * Set the {@code facets} property.
   * @see #facets
   */
  public void setFacets(BFacets v) { set(facets, v, null); }

  //endregion Property "facets"

  //region Property "lightId"

  /**
   * Slot for the {@code lightId} property.
   * @see #getLightId
   * @see #setLightId
   */
  public static final Property lightId = newProperty(0, "", SfUtil.incl());

  /**
   * Get the {@code lightId} property.
   * @see #lightId
   */
  public String getLightId() { return getString(lightId); }

  /**
   * Set the {@code lightId} property.
   * @see #lightId
   */
  public void setLightId(String v) { setString(lightId, v, null); }

  //endregion Property "lightId"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverPointDiscoveryLeaf.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public BTrafficLightDriverPointDiscoveryLeaf()
{
}

  public BTrafficLightDriverPointDiscoveryLeaf(String lightId)
  {
    setLightId(lightId);
  }

  @Override
  public String getDiscoveryName()
  {
    switch (getLightId())
    {
      case "n":
      case "N":
        return "North";
      case "s":
      case "S":
        return "South";
      case "e":
      case "E":
        return "East";
      case "w":
      case "W":
        return "West";
      default:
        return getLightId();
    }
  }

  public TypeInfo[] getValidDatabaseTypes()
  {
    return new TypeInfo[] {BEnumPoint.TYPE.getTypeInfo(), BEnumWritable.TYPE.getTypeInfo()};
  }

  // Call when adding new object based on this discovery leaf.  Initialize proxy.
  public void updateTarget(BComponent target)
  {
    BControlPoint controlPoint = (BControlPoint) target;
    BTrafficLightDriverProxyExt proxyExt = new BTrafficLightDriverProxyExt();

    proxyExt.setLightId(getLightId());

    BEnumRange range = BEnumRange.make(BTrafficLightState.TYPE);
    BFacets trafficLightStateFacets = BFacets.make(BFacets.RANGE, range);
    controlPoint.setFacets(trafficLightStateFacets);
    controlPoint.setProxyExt(proxyExt);

    controlPoint.getStatusValue().setValueValue(getStatusValue().getValueValue());
  }

  /**
   * Return true if the specified component is an existing representation
   * of this discovery object.
   */
  public boolean isExisting(BComponent target)
  {
    if (!(target instanceof BControlPoint))
    {
      return false;
    }
    BControlPoint controlPoint = (BControlPoint) target;
    BTrafficLightDriverProxyExt proxyExt = (BTrafficLightDriverProxyExt) controlPoint.getProxyExt();

    return proxyExt.getLightId().equalsIgnoreCase(getLightId());
  }
}
