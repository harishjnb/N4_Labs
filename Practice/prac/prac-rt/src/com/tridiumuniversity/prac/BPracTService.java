package com.tridiumuniversity.prac;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.file.BIFile;
import javax.baja.file.BajaFileUtil;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BIRestrictedComponent;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@NiagaraType
@NiagaraAction(
        name="updateCount",
        flags = Flags.ASYNC
)
public class BPracTService extends BAbstractService implements BIRestrictedComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.prac.BPracTService(353036027)1.0$ @*/
/* Generated Fri Feb 14 07:09:06 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

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
  public static final Type TYPE = Sys.loadType(BPracTService.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
@Override
public Type[] getServiceTypes()
{
    return new Type[] {BPracTService.TYPE};
}

    @Override
    public IFuture post(Action action, BValue value, Context cx)
    {
        if(updateCount.equals(action))
        {
            Thread t = new Thread(() -> {
                try {
                    doUpdateCount(cx);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, "calcRectThread");
            t.start();
        }
        return null;
    }

    public void doUpdateCount(Context cx) throws IOException
    {
        myUpdateCountFunc(cx);
    }

    private void myUpdateCountFunc(Context cx) throws IOException
    {
        int foundCount=0;
        BIFile outputFile = BajaFileUtil.createFileToOverwrite(BOrd.make("file:^RectangleThread"),cx);
        try(
                OutputStream out = outputFile.getOutputStream();
                PrintWriter printWriter = new PrintWriter(out);
                ) {
            BITable<BRectangle> table = (BITable<BRectangle>) BOrd.make("bql:select * from prac:Rectangle").get(Sys.getStation(), cx);
            try (TableCursor<BRectangle> cursor = table.cursor()) {
                for (BRectangle rectangle : cursor) {
                    foundCount++;
                    System.out.println("Found here ");
                    logger.log(Level.FINE, "Found BRectangle comp in the station " + foundCount);
                }
            }
            printWriter.println("Total rectangles in thread based approach is " + foundCount);
            printWriter.flush();
        }

    }
    Logger logger = Logger.getLogger("Prac_Thread_based_service");
}
