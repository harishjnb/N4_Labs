/*
 * Copyright 2025 tridiumuniversity. All Rights Reserved.
 */

package com.tridiumuniversity.trafficLightDriver.ui;

import javax.baja.sys.*;
import javax.baja.util.*;
import javax.baja.gx.*;
import javax.baja.ui.*;
import javax.baja.control.*;
import javax.baja.driver.*;
import javax.baja.driver.point.*;
import javax.baja.driver.ui.point.*;
import javax.baja.workbench.mgr.*;
import javax.baja.workbench.mgr.folder.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.ui.point.BNPointManager;
import com.tridium.ndriver.ui.point.NPointController;
import com.tridium.ndriver.ui.point.NPointModel;
import com.tridiumuniversity.trafficLightDriver.*;
import com.tridiumuniversity.trafficLightDriver.point.*;

import java.util.ArrayList;

import static javax.baja.driver.ui.point.PointModel.*;

/**
 * BTrafficLightDriverPointManager provides the user interface to manage
 * proxy points in single device
 *
 * @author tridiumuniversity on 12 Feb 2025
 */
@NiagaraType(agent=@AgentOn(types="trafficLightDriver:TrafficLightDriverPointDeviceExt"))
public class BTrafficLightDriverPointManager
  extends BNPointManager
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.trafficLightDriver.ui.BTrafficLightDriverPointManager(311468428)1.0$ @*/
/* Generated Thu Feb 13 13:51:44 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightDriverPointManager.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Constructor
////////////////////////////////////////////////////////////////

  public BTrafficLightDriverPointManager()
  {
  }

////////////////////////////////////////////////////////////////
// Support
////////////////////////////////////////////////////////////////

  protected MgrModel makeModel()
  {
    return new Model(this);
  }

  protected MgrController makeController()
  {
    return new Controller(this);
  }

////////////////////////////////////////////////////////////////
// Model
////////////////////////////////////////////////////////////////

  class Model extends NPointModel
  {
    Model(BNPointManager manager)
    {
      super(manager);
    }

    protected MgrColumn[] makeColumns()
    {
      return cols;
    }

    @Override
    public MgrTypeInfo[] getNewTypes()
    {
      ArrayList<MgrTypeInfo> list = new ArrayList<>();
      addEnumPointTypes(list,true);
      addStringPointTypes(list,true);
      addNumericPointTypes(list,true);
      return list.toArray(new MgrTypeInfo[0]);
    }
  }



////////////////////////////////////////////////////////////////
// Controller
////////////////////////////////////////////////////////////////

  class Controller extends NPointController
  {
    Controller(BNPointManager mgr)
    {
      super(mgr);
    }
  }

////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  static Lexicon lex = Lexicon.make(BTrafficLightDriverPointManager.class);

  // base class columns
  MgrColumn colName        = new MgrColumn.Name();
  MgrColumn colType        = new MgrColumn.Type();
  MgrColumn colToString    = new MgrColumn.ToString("Out", 0);

  MgrColumn lightId  = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BTrafficLightDriverProxyExt.lightId},   MgrColumn.EDITABLE);

  MgrColumn colEnabled     = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.enabled}, MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colFaultCause  = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.faultCause},   MgrColumn.UNSEEN);

  MgrColumn colReadValue   = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.readValue},    MgrColumn.UNSEEN);
  MgrColumn colWriteValue  = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.writeValue},   MgrColumn.UNSEEN);


  // TrafficLightDriverProxyExt specific columns
  MgrColumn[] cols =
  {
    colName, colType, colToString,lightId,
    colEnabled, colFaultCause, colReadValue, colWriteValue,
  };
}
