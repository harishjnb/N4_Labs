package com.tridiumuniversity.ramakrishnan_harish_review;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.file.BIFile;
import javax.baja.file.BajaFileUtil;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BIRestrictedComponent;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.io.OutputStream;
import java.io.PrintWriter;

@NiagaraType
@NiagaraProperty(
        name="worker",
        type="BSubWorker",
        defaultValue = "new BSubWorker()"
)

@NiagaraAction(
        name="updateCount",
        flags = Flags.ASYNC
)
public final class BReviewService extends BAbstractService implements BIRestrictedComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.ramakrishnan_harish_review.BReviewService(618378013)1.0$ @*/
/* Generated Sat Feb 08 12:42:55 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "worker"

  /**
   * Slot for the {@code worker} property.
   * @see #getWorker
   * @see #setWorker
   */
  public static final Property worker = newProperty(0, new BSubWorker(), null);

  /**
   * Get the {@code worker} property.
   * @see #worker
   */
  public BSubWorker getWorker() { return (BSubWorker)get(worker); }

  /**
   * Set the {@code worker} property.
   * @see #worker
   */
  public void setWorker(BSubWorker v) { set(worker, v, null); }

  //endregion Property "worker"

  //region Action "updateCount"

  /**
   * Slot for the {@code updateCount} action.
   * @see #updateCount()
   */
  public static final Action updateCount = newAction(Flags.ASYNC, null);

  /**
   * Invoke the {@code updateCount} action.
   * @see #updateCount
   */
  public void updateCount() { invoke(updateCount, null, null); }

  //endregion Action "updateCount"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BReviewService.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public Type[] getServiceTypes()
    {
        return new Type[] {BReviewService.TYPE};
    }

    public void doUpdateCount(Context cx)
    {
      String s1 = "";
      int rectCount = 0;


      try
      {
        BIFile outputFile = BajaFileUtil.createFileToOverwrite(outputFileOrd,cx);

        try (
                OutputStream out = outputFile.getOutputStream();
                PrintWriter printWriter = new PrintWriter(out)
        )
        {
            BITable<BRectangle> table = (BITable<BRectangle>) BOrd.make("bql:select * from ramakrishnan_harish_review:Rectangle").get(Sys.getStation(),cx);
            try(TableCursor<BRectangle> cursor = table.cursor())
            {
              for(BRectangle rectangle : cursor)
              {
                rectCount++;
                System.out.println("rectable detected is "+rectCount);
              }
            }
          printWriter.println(s1+"The number of BRectangle.TYPE found in the station is "+rectCount);

        }
      }
      catch (Exception ex)
      {

      }
    }

  @Override
  public IFuture post(Action action, BValue value, Context cx) {
    if (updateCount.equals(action)) {
//      getWorker().postAsync(new Invocation(this,action,value,cx));
      getWorker().postAsync(new Invocation(this, updateCount,value,cx));
    }

    return null;
  }
  private BOrd outputFileOrd = BOrd.make("file:^RectangleCount.txt");

}
