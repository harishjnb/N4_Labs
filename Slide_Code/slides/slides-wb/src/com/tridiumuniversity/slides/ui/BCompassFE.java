package com.tridiumuniversity.slides.ui;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.ui.BRadioButton;
import javax.baja.ui.ToggleCommand;
import javax.baja.ui.ToggleCommandGroup;
import javax.baja.ui.pane.BGridPane;
import javax.baja.workbench.fieldeditor.BWbFieldEditor;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridiumuniversity.slides.moduleDevelopment.BCompass;

@NiagaraType(
  agent = @AgentOn(
    types = "slides:Compass"
  )
)
public class BCompassFE
  extends BWbFieldEditor
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ui.BCompassFE(1700536625)1.0$ @*/
/* Generated Wed Nov 06 15:47:53 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCompassFE.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BCompassFE()
  {
    RadioButtonGroup radioGroup = new RadioButtonGroup();
    northButton = new BRadioButton(radioGroup, "North");
    southButton = new BRadioButton(radioGroup, "South");
    eastButton = new BRadioButton(radioGroup, "East");
    westButton = new BRadioButton(radioGroup, "West");

    BGridPane gridPane = new BGridPane(4);
    gridPane.setColumnGap(10);
    gridPane.add(null, northButton);
    gridPane.add(null, southButton);
    gridPane.add(null, eastButton);
    gridPane.add(null, westButton);

    setContent(gridPane);
  }

  @Override
  public void doLoadValue(BObject object, Context context)
  {
    northButton.setSelected(object == BCompass.north);
    southButton.setSelected(object == BCompass.south);
    eastButton.setSelected(object == BCompass.east);
    westButton.setSelected(object == BCompass.west);
  }

  @Override
  public BObject doSaveValue(BObject object, Context context)
  {
    if (northButton.isSelected())
    {
      return BCompass.north;
    }
    else if (southButton.isSelected())
    {
      return BCompass.south;
    }
    else if (eastButton.isSelected())
    {
      return BCompass.east;
    }
    else if (westButton.isSelected())
    {
      return BCompass.west;
    }

    return BCompass.DEFAULT;
  }

  private class RadioButtonGroup
    extends ToggleCommandGroup<ToggleCommand>
  {
    @Override
    public void selected(ToggleCommand command)
    {
      setModified();
    }
  }

  private final BRadioButton northButton;
  private final BRadioButton southButton;
  private final BRadioButton eastButton;
  private final BRadioButton westButton;
}
