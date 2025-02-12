package com.tridiumuniversity.prac;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.file.BIFile;
import javax.baja.file.BajaFileUtil;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.*;
import javax.baja.sys.*;
import javax.baja.util.BFormat;
import javax.baja.util.BIRestrictedComponent;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@NiagaraType
@NiagaraProperty(
        name="worker",
        type="BPracWorker",
        defaultValue="new BPracWorker()"
)

@NiagaraProperty(
        name="state",
        type="BMyState",
        defaultValue="BMyState.low",
        flags = Flags.TRANSIENT | Flags.READONLY
)

@NiagaraProperty(
        name="totalCtr",
        type="BInteger",
        defaultValue="BInteger.DEFAULT",
        flags = Flags.SUMMARY | Flags.READONLY
)

@NiagaraProperty(
        name="threshold",
        type="BInteger",
        defaultValue="BInteger.make(5)",
        facets=
                {
                        @Facet(name="BFacets.MIN", value="0"),
                        @Facet(name="BFacets.MAX", value="20")
                }
)

@NiagaraProperty(
        name="LastFiredState",
        type="BBoolean",
        defaultValue = "BBoolean.FALSE",
        flags = Flags.READONLY | Flags.TRANSIENT,
        facets=
                {
                        @Facet(name="BFacets.TRUE_TEXT", value="BString.make(\"ON\")"),
                        @Facet(name="BFacets.FALSE_TEXT", value="BString.make(\"OFF\")")
                }
)

@NiagaraAction(
        name="updateCount",
        flags=Flags.ASYNC | Flags.SUMMARY
)

@NiagaraTopic(
        name="mytopic",
        eventType="BBoolean",
        flags=Flags.SUMMARY
)
public class BPracService extends BAbstractService implements BIRestrictedComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.prac.BPracService(480646958)1.0$ @*/
/* Generated Tue Feb 11 19:17:54 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "worker"

  /**
   * Slot for the {@code worker} property.
   * @see #getWorker
   * @see #setWorker
   */
  public static final Property worker = newProperty(0, new BPracWorker(), null);

  /**
   * Get the {@code worker} property.
   * @see #worker
   */
  public BPracWorker getWorker() { return (BPracWorker)get(worker); }

  /**
   * Set the {@code worker} property.
   * @see #worker
   */
  public void setWorker(BPracWorker v) { set(worker, v, null); }

  //endregion Property "worker"

  //region Property "state"

  /**
   * Slot for the {@code state} property.
   * @see #getState
   * @see #setState
   */
  public static final Property state = newProperty(Flags.TRANSIENT | Flags.READONLY, BMyState.low, null);

  /**
   * Get the {@code state} property.
   * @see #state
   */
  public BMyState getState() { return (BMyState)get(state); }

  /**
   * Set the {@code state} property.
   * @see #state
   */
  public void setState(BMyState v) { set(state, v, null); }

  //endregion Property "state"

  //region Property "totalCtr"

  /**
   * Slot for the {@code totalCtr} property.
   * @see #getTotalCtr
   * @see #setTotalCtr
   */
  public static final Property totalCtr = newProperty(Flags.SUMMARY | Flags.READONLY, BInteger.DEFAULT.as(BInteger.class).getInt(), null);

  /**
   * Get the {@code totalCtr} property.
   * @see #totalCtr
   */
  public int getTotalCtr() { return getInt(totalCtr); }

  /**
   * Set the {@code totalCtr} property.
   * @see #totalCtr
   */
  public void setTotalCtr(int v) { setInt(totalCtr, v, null); }

  //endregion Property "totalCtr"

  //region Property "threshold"

  /**
   * Slot for the {@code threshold} property.
   * @see #getThreshold
   * @see #setThreshold
   */
  public static final Property threshold = newProperty(0, BInteger.make(5).as(BInteger.class).getInt(), BFacets.make(BFacets.make(BFacets.MIN, 0), BFacets.make(BFacets.MAX, 20)));

  /**
   * Get the {@code threshold} property.
   * @see #threshold
   */
  public int getThreshold() { return getInt(threshold); }

  /**
   * Set the {@code threshold} property.
   * @see #threshold
   */
  public void setThreshold(int v) { setInt(threshold, v, null); }

  //endregion Property "threshold"

  //region Property "LastFiredState"

  /**
   * Slot for the {@code LastFiredState} property.
   * @see #getLastFiredState
   * @see #setLastFiredState
   */
  public static final Property LastFiredState = newProperty(Flags.READONLY | Flags.TRANSIENT, BBoolean.FALSE.as(BBoolean.class).getBoolean(), BFacets.make(BFacets.make(BFacets.TRUE_TEXT, BString.make("ON")), BFacets.make(BFacets.FALSE_TEXT, BString.make("OFF"))));

  /**
   * Get the {@code LastFiredState} property.
   * @see #LastFiredState
   */
  public boolean getLastFiredState() { return getBoolean(LastFiredState); }

  /**
   * Set the {@code LastFiredState} property.
   * @see #LastFiredState
   */
  public void setLastFiredState(boolean v) { setBoolean(LastFiredState, v, null); }

  //endregion Property "LastFiredState"

  //region Action "updateCount"

  /**
   * Slot for the {@code updateCount} action.
   * @see #updateCount()
   */
  public static final Action updateCount = newAction(Flags.ASYNC | Flags.SUMMARY, null);

  /**
   * Invoke the {@code updateCount} action.
   * @see #updateCount
   */
  public void updateCount() { invoke(updateCount, null, null); }

  //endregion Action "updateCount"

  //region Topic "mytopic"

  /**
   * Slot for the {@code mytopic} topic.
   * @see #fireMytopic
   */
  public static final Topic mytopic = newTopic(Flags.SUMMARY, null);

  /**
   * Fire an event for the {@code mytopic} topic.
   * @see #mytopic
   */
  public void fireMytopic(BBoolean event) { fire(mytopic, event, null); }

  //endregion Topic "mytopic"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPracService.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
@Override
public Type[] getServiceTypes()
{
    return new Type[] {BPracService.TYPE};
}
    public void doUpdateCount(Context cx) throws IOException {
        int foundCount = 0;
        try {
            BIFile file = BajaFileUtil.createFileToOverwrite(outputFileOrd, cx);

            try (
                    OutputStream out = file.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(out);
            ) {
                BITable<BRectangle> table = (BITable<BRectangle>) BOrd.make("bql:select * from prac:Rectangle").get(Sys.getStation(), cx);
                try (TableCursor<BRectangle> cursor = table.cursor())
                {
                    for (BRectangle rectangle : cursor) {
                        foundCount++;
                        System.out.println("Found here ");
                        logger.log(Level.FINE, "Found BRectangle comp in the station " + foundCount);
                    }
                }
                printWriter.println("Total BRectangle found in the station " + foundCount);
                logger.log(Level.INFO, "Total BRectangle found in the station " + foundCount);
                setTotalCtr(foundCount);
                if(getTotalCtr()>getThreshold())
                {
                    fireMytopic(BBoolean.TRUE);
                    setLastFiredState(true);
                }
                else
                {
                    fireMytopic(BBoolean.FALSE);
                    setLastFiredState(false);
                }
                if(getTotalCtr()<=5)
                    this.setState(BMyState.low);
                else if(getTotalCtr()<=10)
                this.setState(BMyState.med);
                else
                    this.setState(BMyState.high);
                printWriter.flush();
            }
        }
        catch(Exception e)
        {

        }
    }

    @Override
    public IFuture post(Action action, BValue value, Context cx)
    {
        if(updateCount.equals(action))
        {
            getWorker().postAsync(new Invocation(this,action,value,cx));
        }
        return null;
    }

    private BOrd outputFileOrd = BOrd.make("file:^RectangleCount.txt");
    Logger logger = Logger.getLogger("prac_logger");
}
