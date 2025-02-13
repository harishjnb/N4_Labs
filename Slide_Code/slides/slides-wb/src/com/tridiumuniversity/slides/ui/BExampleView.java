package com.tridiumuniversity.slides.ui;

import javax.baja.gx.BImage;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponentEvent;
import javax.baja.sys.BIcon;
import javax.baja.ui.BAbstractButton;
import javax.baja.ui.BMenu;
import javax.baja.ui.BToolBar;
import javax.baja.ui.BWidget;
import javax.baja.ui.Command;
import javax.baja.ui.CommandArtifact;
import javax.baja.ui.menu.BIMenu;
import javax.baja.ui.text.BTextEditor;
import javax.baja.ui.toolbar.BIToolBar;
import javax.baja.ui.util.UiLexicon;
import javax.baja.workbench.view.BWbComponentView;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType(
  agent = @AgentOn(
    types = "slides:Example"
  )
)
public class BExampleView
  extends BWbComponentView
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.ui.BExampleView(893604242)1.0$ @*/
/* Generated Wed Nov 06 15:47:53 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BExampleView.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BExampleView()
  {
    componentEventDisplay = new BTextEditor();
    componentEventDisplay.setEditable(false);
    setContent(componentEventDisplay);
  }

  @Override
  public BIMenu[] getViewMenus()
  {
    BMenu menu = LEXICON.buildMenu("menu.name");
    menu.add(null, exampleCommand);
    menu.add(null, clearCommand);
    return new BIMenu[] { menu };
  }

  @Override
  public BIToolBar getViewToolBar()
  {
    BToolBar toolbar = new BToolBar();

    BAbstractButton button = toolbar.addButton(null, exampleCommand);
    button.setImage(BImage.make(BIcon.std("emerald.png")));

    button = toolbar.addButton(null, clearCommand);
    button.setImage(BImage.make(BIcon.std("clear.png")));

    return toolbar;
  }

  @Override
  public void handleComponentEvent(BComponentEvent event)
  {
    addLine(event.toString());
  }

  private class ExampleCommand
    extends Command
  {
    public ExampleCommand(BWidget owner, String label)
    {
      super(owner, label);
    }

    @Override
    public CommandArtifact doInvoke()
    {
      addLine("Example Command invoked!");
      return null;
    }
  }

  private class ClearCommand
    extends Command
  {
    public ClearCommand(BWidget owner, String label)
    {
      super(owner, label);
    }

    @Override
    public CommandArtifact doInvoke()
    {
      clear();
      return null;
    }
  }

  private void addLine(String newLine)
  {
    String text = componentEventDisplay.getText();
    componentEventDisplay.setText(text + "\n" + newLine);
  }

  private void clear()
  {
    componentEventDisplay.setText("");
  }

  BTextEditor componentEventDisplay;
  private static final UiLexicon LEXICON = UiLexicon.makeUiLexicon(BExampleView.class);
  private final ExampleCommand exampleCommand = new ExampleCommand(this, LEXICON.get("exampleCommand.name"));
  private final ClearCommand clearCommand = new ClearCommand(this, LEXICON.get("clearCommand.name"));
}
