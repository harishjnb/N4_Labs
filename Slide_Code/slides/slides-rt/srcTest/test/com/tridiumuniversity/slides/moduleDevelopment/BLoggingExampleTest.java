/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.moduleDevelopment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;

import com.tridiumuniversity.slides.moduleDevelopment.BLoggingExample;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BLoggingExampleTest
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.moduleDevelopment.BLoggingExampleTest(2979906276)1.0$ @*/
/* Generated Fri Oct 06 14:53:48 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BLoggingExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  // The logging is done in started(), so to test it we need that method to be called. We could call it ourselves,
  // but it's more realistic to set up a test station and add an instance of BLoggingExample. Then the framework will
  // call started() for us. The code in setup() and cleanup() does that
  public void connectsOnStarted()
  {
    BLoggingExample loggingExample = new BLoggingExample();

    // In the java.util.logging framework, there are several major components to logging: Loggers, LogRecords, and Handlers.
    //   * A LogRecord is a single log message, together with its logging level and some additional information.
    //   * A Logger creates instances of LogRecord. However, a Logger has a log level defined and will not create LogRecords
    //     when the level of the LogRecord is below the Logger's level. The default Logger level is INFO, so by default
    //     a Logger will not create LogRecords with levels below INFO.
    //   * A Handler processes LogRecords that have been created by Loggers. A Handler also has a log level defined and
    //     will not process a LogRecord when the level of the LogRecord is below the Handler's level. The default Handler
    //     level is ALL, so LogRecords of any level will be processed.
    //
    // So to test that you're logging a message (regardless of the level at which the message is logged):
    //   1. Create a custom Handler that captures the log message for your testing.
    //   2. Set the Logger level to ALL
    //   3. Add the Handler to the Logger
    //   4. Invoke the behavior that causes logging
    //   5. Remove the Handler from the Logger
    //   6. Reset the Logger level to what it was before the test
    LogHandler logHandler = new LogHandler();
    Logger logger = Logger.getLogger("slides");
    Level oldLevel = logger.getLevel();
    logger.setLevel(Level.ALL);
    logger.addHandler(logHandler);

    try
    {
      stationHandler.getStation().add("loggingExample", loggingExample);
      Assert.assertTrue(logHandler.getLogMessages().contains("Connecting to " + loggingExample.getUrl()), "Message indicating connecting to url should be logged");
      Assert.assertTrue(logHandler.getLogMessages().stream().anyMatch(s -> s.startsWith("Connected to " + loggingExample.getUrl())), "Message indicating connected to url should be logged");
    }
    finally
    {
      logger.removeHandler(logHandler);
      logger.setLevel(oldLevel);
      logHandler.close();
    }
  }

  private static class LogHandler extends Handler
  {
    @Override
    public void publish(LogRecord record)
    {
      logMessages.add(record.getMessage());
    }

    @Override
    public void flush()
    {
    }

    @Override
    public void close() throws SecurityException
    {
      logMessages.clear();
    }

    public List<String> getLogMessages()
    {
      return logMessages;
    }

    private final List<String> logMessages = new ArrayList<>();
  }
}
