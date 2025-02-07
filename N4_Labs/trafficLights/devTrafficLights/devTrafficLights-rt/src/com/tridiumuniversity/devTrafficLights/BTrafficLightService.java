package com.tridiumuniversity.devTrafficLights;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BIRestrictedComponent;

@NiagaraType
@NiagaraProperty(
        name="outputFile",
        type="BOrd",
        defaultValue="BOrd.make(\"local:|foxs:|file:^traffic/trafficLights.csv\")",
        facets=
                {
                        @Facet(name = "BFacets.TARGET_TYPE", value = "\"file:CsvFile\"")
                }

                )

@NiagaraAction(
        name="run"
)
public final class BTrafficLightService extends BAbstractService implements BIRestrictedComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BTrafficLightService(3922809690)1.0$ @*/
/* Generated Fri Feb 07 14:47:47 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "outputFile"

  /**
   * Slot for the {@code outputFile} property.
   * @see #getOutputFile
   * @see #setOutputFile
   */
  public static final Property outputFile = newProperty(0, BOrd.make("local:|foxs:|file:^traffic/trafficLights.csv"), BFacets.make(BFacets.TARGET_TYPE, "file:CsvFile"));

  /**
   * Get the {@code outputFile} property.
   * @see #outputFile
   */
  public BOrd getOutputFile() { return (BOrd)get(outputFile); }

  /**
   * Set the {@code outputFile} property.
   * @see #outputFile
   */
  public void setOutputFile(BOrd v) { set(outputFile, v, null); }

  //endregion Property "outputFile"

  //region Action "run"

  /**
   * Slot for the {@code run} action.
   * @see #run()
   */
  public static final Action run = newAction(0, null);

  /**
   * Invoke the {@code run} action.
   * @see #run
   */
  public void run() { invoke(run, null, null); }

  //endregion Action "run"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightService.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  public void doRun(Context cx)
  {
    if (!getEnabled())
    {
      return;
    }

    new BTrafficLightJob(getOutputFile()).submit(cx);
  }
    @Override
    public Type[] getServiceTypes()
    {
        return new Type[] { BTrafficLightService.TYPE };
    }
}
