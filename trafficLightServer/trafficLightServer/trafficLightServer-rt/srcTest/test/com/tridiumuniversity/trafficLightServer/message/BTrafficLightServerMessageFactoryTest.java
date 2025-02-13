/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.comm.TrafficLightServerLinkMessage;
import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightServerMessageFactory;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerDiscoverReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerGetIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingNetworkReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerSetLightReq;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.com.tridiumuniversity.trafficLightServer.util.TestUtils;

import com.tridium.ndriver.comm.NMessage;

@NiagaraType
@Test
public class BTrafficLightServerMessageFactoryTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.BTrafficLightServerMessageFactoryTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 13:02:51 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerMessageFactoryTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testPingNetworkRequest()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    TestUtils.setLinkMessageFromString(linkMessage, "ping");

    TrafficLightServerMessageFactory messageFactory = new TrafficLightServerMessageFactory();
    NMessage message = messageFactory.makeMessage(linkMessage);
    Assert.assertTrue(
      message instanceof TrafficLightServerPingNetworkReq,
      "ping network request should create correct NMessage subclass"
    );
  }

  public void testPingIntersectionRequest()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    TestUtils.setLinkMessageFromString(linkMessage, "ping a");

    TrafficLightServerMessageFactory messageFactory = new TrafficLightServerMessageFactory();
    NMessage message = messageFactory.makeMessage(linkMessage);
    Assert.assertTrue(
      message instanceof TrafficLightServerPingIntersectionReq,
      "ping intersection request should create correct NMessage subclass"
    );
    Assert.assertEquals(((TrafficLightServerPingIntersectionReq)message).getIntersectionId(), "a",
      "ping intersection requests should be parsed correctly"
    );
  }

  public void testGetIntersectionRequest()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    TestUtils.setLinkMessageFromString(linkMessage, "get a");

    TrafficLightServerMessageFactory messageFactory = new TrafficLightServerMessageFactory();
    NMessage message = messageFactory.makeMessage(linkMessage);
    Assert.assertTrue(
      message instanceof TrafficLightServerGetIntersectionReq,
      "get intersection request should create correct NMessage subclass"
    );
    Assert.assertEquals(((TrafficLightServerGetIntersectionReq)message).getIntersectionId(), "a",
      "get intersection requests should be parsed correctly"
    );
  }

  public void testSetLightRequest()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    TestUtils.setLinkMessageFromString(linkMessage, "set b s yellow");

    TrafficLightServerMessageFactory messageFactory = new TrafficLightServerMessageFactory();
    NMessage message = messageFactory.makeMessage(linkMessage);
    Assert.assertTrue(
      message instanceof TrafficLightServerSetLightReq,
      "set light request should create correct NMessage subclass"
    );

    TrafficLightServerSetLightReq request = (TrafficLightServerSetLightReq)message;
    Assert.assertEquals(request.getLightRequestInfo().getIntersectionId(), "b",
      "set light requests should be parsed correctly"
    );
    Assert.assertEquals(request.getLightRequestInfo().getLightId(), "s",
      "set light requests should be parsed correctly"
    );
    Assert.assertEquals(request.getLightRequestInfo().getState(), BTrafficLightState.yellow,
      "set light requests should be parsed correctly"
    );
  }

  public void testDiscoverRequest()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    TestUtils.setLinkMessageFromString(linkMessage, "discover");

    TrafficLightServerMessageFactory messageFactory = new TrafficLightServerMessageFactory();
    NMessage message = messageFactory.makeMessage(linkMessage);
    Assert.assertTrue(message instanceof TrafficLightServerDiscoverReq);
  }

  public void testUnrecognizedRequest()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    TestUtils.setLinkMessageFromString(linkMessage, "unknown request");

    TrafficLightServerMessageFactory messageFactory = new TrafficLightServerMessageFactory();
    Assert.assertNull(
      messageFactory.makeMessage(linkMessage),
      "NMessage subclasses should not be instantiated for unknown requests"
    );
  }
}
