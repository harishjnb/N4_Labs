/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ui.drivers;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BObject;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.CommandArtifact;
import javax.baja.workbench.mgr.MgrController;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.ui.NMgrControllerUtil;
import com.tridium.ndriver.ui.device.BINDeviceMgrAgent;
import com.tridium.ndriver.ui.device.BNDeviceManager;

/**
 * This class won't do much good outside of a driver
 */
@NiagaraType(
  agent = @AgentOn(types = "exampleDriver:ExampleNetwork"))
public class BResetCommand
  extends BObject implements BINDeviceMgrAgent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ui.drivers.BResetCommand(251164061)1.0$ @*/
/* Generated Tue Oct 10 13:55:43 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BResetCommand.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  @Override
  public String getUiName()
  {
    return "example.driver.command.reset";
  }

  @Override
  public CommandArtifact doInvoke(BNDeviceManager deviceMgr, BNNetwork network)
  {
    return new ResetArtifact();
  }

  @Override
  public int getFlags()
  {
    return MgrController.BARS;
  }

  @Override
  public void update(BNDeviceManager deviceManager, NMgrControllerUtil.NDeviceMgrAgentCommand agentCommand)
  {
  }

  private static class ResetArtifact implements CommandArtifact
  {
    @Override
    public void undo() throws Exception
    {
    }

    @Override
    public void redo() throws Exception
    {
    }
  }
}
