package com.tridiumuniversity.devTrafficLights;

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
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import static java.lang.System.out;
import javax.baja.sys.Type;

@NiagaraType
public class BTrafficLightJob extends BSimpleJob {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.devTrafficLights.BTrafficLightJob(2979906276)1.0$ @*/
/* Generated Fri Feb 07 15:33:01 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightJob.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BTrafficLightJob()
    {
    }

    BTrafficLightJob(BOrd outputFileOrd)
    {
        this.outputFileOrd = outputFileOrd;
    }

    @Override
    public void run(Context cx) throws IOException {
        BIFile outputFile = BajaFileUtil.createFileToOverwrite(outputFileOrd, cx);

        try (
                OutputStream out = outputFile.getOutputStream();
                PrintWriter printWriter = new PrintWriter(out)
        ) {
            String s1 = "";
            BITable<BTrafficLight> table = (BITable<BTrafficLight>) BOrd.make("bql:select from devTrafficLights:TrafficLight").get(Sys.getStation(), cx);
            try (TableCursor<BTrafficLight> cursor = table.cursor()) {
                for (BTrafficLight trafficLight : cursor) {
                    if (!isAlive())
                        throw new JobCancelException();

                    heartbeat();
                    log().message("devTrafficLights", "trafficLightJob.processingTrafficLight", trafficLight.getSlotPath().toString());
                    s1 = s1 + "\n" + trafficLight.getState().toString() + "," + trafficLight.getLastChange().toString();
                    String trafficLightString = String.format(TRAFFIC_LIGHT_FORMAT_STRING, trafficLight.getName(), trafficLight.getState().toString(cx), trafficLight.getLastChange().toString(cx));
                    printWriter.println(trafficLightString);
                }
            }
        } //outer try with resource block

    }
    private BOrd outputFileOrd = null;
    private static final String TRAFFIC_LIGHT_HEADER = "Name,State,Since";
    private static final String TRAFFIC_LIGHT_FORMAT_STRING = "%s,%s,%s";
}
