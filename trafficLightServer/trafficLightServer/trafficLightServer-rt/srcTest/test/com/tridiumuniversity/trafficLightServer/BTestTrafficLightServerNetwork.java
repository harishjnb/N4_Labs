/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer;

import com.tridium.ndriver.comm.NMessage;
import com.tridiumuniversity.trafficLightServer.BTrafficLightServerNetwork;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BTestTrafficLightServerNetwork
  extends BTrafficLightServerNetwork
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.BTestTrafficLightServerNetwork(2979906276)1.0$ @*/
/* Generated Tue Jan 02 16:11:12 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTestTrafficLightServerNetwork.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void sendMessage(NMessage message)
  {
    lastMessage = message;
  }

  public NMessage getLastMessage()
  {
    return lastMessage;
  }
  private NMessage lastMessage;
}
