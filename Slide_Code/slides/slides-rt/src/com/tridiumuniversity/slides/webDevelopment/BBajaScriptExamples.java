/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.webDevelopment;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraTopic;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.rpc.NiagaraRpc;
import javax.baja.rpc.Transport;
import javax.baja.rpc.TransportType;
import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Topic;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraAction(
  name = "print",
  parameterType = "BString",
  defaultValue = "BString.make(\"Default Print Value\")"
)
@NiagaraTopic(
  name = "send",
  eventType = "BString"
)
public class BBajaScriptExamples extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumuniversity.slides.webDevelopment.BBajaScriptExamples(2296321040)1.0$ @*/
/* Generated Tue Oct 17 15:08:48 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Action "print"

  /**
   * Slot for the {@code print} action.
   * @see #print(BString parameter)
   */
  public static final Action print = newAction(0, BString.make("Default Print Value"), null);

  /**
   * Invoke the {@code print} action.
   * @see #print
   */
  public void print(BString parameter) { invoke(print, parameter, null); }

  //endregion Action "print"

  //region Topic "send"

  /**
   * Slot for the {@code send} topic.
   * @see #fireSend
   */
  public static final Topic send = newTopic(0, null);

  /**
   * Fire an event for the {@code send} topic.
   * @see #send
   */
  public void fireSend(BString event) { fire(send, event, null); }

  //endregion Topic "send"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBajaScriptExamples.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @NiagaraRpc(
    transports = @Transport(type = TransportType.box)
  )
  public void exampleRpc(String stringToPrint, Context cx)
  {
    System.out.println("RPC method called with argument " + stringToPrint);
  }

  public void doPrint(BString stringtoPrint, Context cx)
  {
    System.out.println("Action invoked with argument " + stringtoPrint.getString());
  }
}
