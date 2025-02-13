/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.ui;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BLabel;
import javax.baja.ui.pane.BGridPane;
import javax.baja.workbench.view.BWbComponentView;

@NiagaraType(
  agent = @AgentOn(types = "slides:Example")
)
public class BGridPaneExample extends BWbComponentView
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ui.BGridPaneExample(893604242)1.0$ @*/
/* Generated Tue Oct 10 13:26:09 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BGridPaneExample.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BGridPaneExample()
  {
    BGridPane gridPane = new BGridPane();
    gridPane.setColumnCount(3);
    gridPane.setColumnGap(50);

    for(int i = 0; i < 6; i++)
      gridPane.add(null, new BLabel("Label " + i));

    setContent(gridPane);
  }
}
