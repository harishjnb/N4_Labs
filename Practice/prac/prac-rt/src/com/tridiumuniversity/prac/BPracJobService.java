package com.tridiumuniversity.prac;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BIRestrictedComponent;

@NiagaraType
@NiagaraProperty(
        name="jobfile",
        type="BOrd",
        defaultValue="BOrd.make(\"file:^joboutfile.text\")",
        facets=
                {
                        @Facet(name="BFacets.TARGET_TYPE",value="\"file:TxtFile\"")
                }
)

@NiagaraAction(
        name="execute"
)
public class BPracJobService extends BAbstractService implements BIRestrictedComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.prac.BPracJobService(3789863360)1.0$ @*/
/* Generated Tue Feb 11 19:10:13 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "jobfile"

  /**
   * Slot for the {@code jobfile} property.
   * @see #getJobfile
   * @see #setJobfile
   */
  public static final Property jobfile = newProperty(0, BOrd.make("file:^joboutfile.text"), BFacets.make(BFacets.TARGET_TYPE, "file:TxtFile"));

  /**
   * Get the {@code jobfile} property.
   * @see #jobfile
   */
  public BOrd getJobfile() { return (BOrd)get(jobfile); }

  /**
   * Set the {@code jobfile} property.
   * @see #jobfile
   */
  public void setJobfile(BOrd v) { set(jobfile, v, null); }

  //endregion Property "jobfile"

  //region Action "execute"

  /**
   * Slot for the {@code execute} action.
   * @see #execute()
   */
  public static final Action execute = newAction(0, null);

  /**
   * Invoke the {@code execute} action.
   * @see #execute
   */
  public void execute() { invoke(execute, null, null); }

  //endregion Action "execute"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPracJobService.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public Type[] getServiceTypes()
    {
        return new Type[] { BPracJobService.TYPE };
    }

    public void doExecute(Context cx)
    {
        if(!getEnabled())
            return;

        new BPracJob(getJobfile()).submit(cx);
    }
}
