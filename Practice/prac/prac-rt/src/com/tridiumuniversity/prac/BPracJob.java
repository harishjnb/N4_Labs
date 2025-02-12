package com.tridiumuniversity.prac;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.file.BIFile;
import javax.baja.file.BajaFileUtil;
import javax.baja.job.BSimpleJob;
import javax.baja.job.JobCancelException;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@NiagaraType
public class BPracJob extends BSimpleJob {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.prac.BPracJob(2979906276)1.0$ @*/
/* Generated Tue Feb 11 18:47:37 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPracJob.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public BPracJob()
    {
    }

    public BPracJob(BOrd rcvFileOrd)
    {
        this.outputFileOrd = rcvFileOrd;
    }

    public void run(Context cx) throws IOException
    {
        int ct = 0;
        BIFile outputFile = BajaFileUtil.createFileToOverwrite(outputFileOrd,cx);
        try(
                OutputStream out = outputFile.getOutputStream();
                PrintWriter printWriter = new PrintWriter(out);
                )
        {
            BITable<BRectangle> table = (BITable<BRectangle>) BOrd.make("bql:select * from prac:Rectangle").get(Sys.getStation(),cx);
            try(TableCursor<BRectangle> cursor = table.cursor())
            {
                for(BRectangle comp : cursor)
                {
                    if(!isAlive())
                        throw new JobCancelException();
                    ct++;
                }
                heartbeat();
                logger.log(Level.INFO,"Count is "+ct);
                printWriter.println("Total count of rectangles is "+ct);
            }
            printWriter.flush();
        }
    }

    private BOrd outputFileOrd = null;
    Logger logger = Logger.getLogger("prac_job_logger");
}
