/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.comm;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingNetworkResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedSetLightResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulDiscoverResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingNetworkResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulSetLightResponse;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.getMessageAsString;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.makeMap;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.setLinkMessageFromString;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.baja.control.BEnumWritable;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.BTrafficLightServerDevice;
import com.tridiumuniversity.trafficLightServer.comm.BTrafficLightServerTcpCommConfig;
import com.tridiumuniversity.trafficLightServer.comm.TrafficLightServerListener;
import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerDiscoverReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerGetIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingIntersectionReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerPingNetworkReq;
import com.tridiumuniversity.trafficLightServer.message.req.TrafficLightServerSetLightReq;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerDiscoverResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerGenericErrorResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerGetIntersectionResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerPingIntersectionResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerPingNetworkResp;
import com.tridiumuniversity.trafficLightServer.message.resp.TrafficLightServerSetLightResp;
import com.tridiumuniversity.trafficLightServer.point.BTrafficLightServerProxyExt;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.com.tridiumuniversity.trafficLightServer.BTestTrafficLightServerNetwork;

import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.datatypes.BAddress;

@NiagaraType
@Test
public class BTrafficLightServerListenerTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.comm.BTrafficLightServerListenerTest(2979906276)1.0$ @*/
/* Generated Tue Jan 02 15:33:49 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerListenerTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeMethod
  public void setup()
  {
    network = new BTestTrafficLightServerNetwork();
    BTrafficLightServerTcpCommConfig commConfig = new BTrafficLightServerTcpCommConfig();
    network.add("commConfig", commConfig);
    listener = new TrafficLightServerListener(commConfig);
  }

  //region ping network
  public void disabledNetworkCausesPingNetworkFailure()
    throws Exception
  {
    network.setEnabled(false);
    listener.receiveMessage(new TrafficLightServerPingNetworkReq(new BAddress()));

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerPingNetworkResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedPingNetworkResponse(), "Ping network request with disabled network should result in ping failure response");
  }

  public void networkWithNonOkStatusCausesPingNetworkFailure()
    throws Exception
  {
    network.setStatus(BStatus.down);
    listener.receiveMessage(new TrafficLightServerPingNetworkReq(new BAddress()));

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerPingNetworkResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedPingNetworkResponse(), "Ping network request when network status is not ok should result in ping failure response");
  }

  public void testSuccessfulNetworkPing()
    throws Exception
  {
    listener.receiveMessage(new TrafficLightServerPingNetworkReq(new BAddress()));

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerPingNetworkResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulPingNetworkResponse(), "Ping network request with enabled network with ok status should result in successful ping network response");
  }

//endregion ping network
//region ping intersection

  public void pingIntersectionWithNoIntersectionIdCausesGenericErrorResponse()
  {
    listener.receiveMessage(new TrafficLightServerPingIntersectionReq(new BAddress()));

    NMessage response = network.getLastMessage();
    Assert.assertTrue(response instanceof TrafficLightServerGenericErrorResp, "Response should be of the correct type");
  }

  public void pingIntersectionWithMissingDeviceCausesPingIntersectionFailureResponse()
    throws Exception
  {
    TrafficLightServerPingIntersectionReq request = new TrafficLightServerPingIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "ping a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerPingIntersectionResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedPingIntersectionResponse("a"), "Ping intersection request with missing device should result in failed ping intersection response");
  }

  public void testSuccessfulPingIntersectionResponse()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    TrafficLightServerPingIntersectionReq request = new TrafficLightServerPingIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "ping a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerPingIntersectionResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulPingIntersectionResponse("a"), "Ping intersection request with device enabled and with ok status should result in successful ping intersection response");
  }

//endregion ping intersection
//region get intersection

  public void getIntersectionWithNoIntersectionIdCausesGenericErrorResponse()
  {
    listener.receiveMessage(new TrafficLightServerGetIntersectionReq(new BAddress()));

    NMessage response = network.getLastMessage();
    Assert.assertTrue(response instanceof TrafficLightServerGenericErrorResp, "Response should be of the correct type");
  }

  public void getIntersectionWithMissingDeviceCausesGetIntersectionFailureResponse()
    throws Exception
  {
    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "get a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerGetIntersectionResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedGetIntersectionResponse(),
      "Get intersection request with missing device should result in failed get intersection response"
    );
  }

  public void getIntersectionWithDownDeviceCausesGetIntersectionFailureResponse()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    device.setEnabled(false);
    network.add("device", device);

    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "get a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerGetIntersectionResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedGetIntersectionResponse(),
      "Get intersection request with down device should result in failed get intersection response"
    );
  }

  public void testSuccessfulGetIntersectionWithNoPoints()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "get a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerGetIntersectionResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulGetIntersectionResponse(Collections.emptyMap()),
      "Get intersection request for existing device should result in successful get intersection response"
    );
  }

  public void testSuccessfulGetIntersectionWithPoints()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    BEnumWritable point1 = new BEnumWritable();
    BEnumWritable point2 = new BEnumWritable();
    BEnumWritable point3 = new BEnumWritable();
    BEnumWritable point4 = new BEnumWritable();

    point1.set("proxyExt", new BTrafficLightServerProxyExt());
    point2.set("proxyExt", new BTrafficLightServerProxyExt());
    point3.set("proxyExt", new BTrafficLightServerProxyExt());
    point4.set("proxyExt", new BTrafficLightServerProxyExt());

    point1.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point2.setOut(new BStatusEnum(BTrafficLightState.yellow, BStatus.ok));
    point3.setOut(new BStatusEnum(BTrafficLightState.green, BStatus.ok));
    point4.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));

    device.getPoints().add("n", point1);
    device.getPoints().add("s", point2);
    device.getPoints().add("e", point3);
    device.getPoints().add("w", point4);

    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "get a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerGetIntersectionResp, "Response should be of the correct type");

    Map<String, BTrafficLightState> expectedMap = makeMap(
      new String[]{ "n", "s", "e", "w" },
      new BTrafficLightState[]{ BTrafficLightState.red, BTrafficLightState.yellow, BTrafficLightState.green, BTrafficLightState.red }
    );
    Assert.assertEquals(responseString, makeSuccessfulGetIntersectionResponse(expectedMap),
      "Get intersection request for existing device should result in successful get intersection response"
    );
  }

  public void testSuccessfulGetIntersectionWithMultipleDevices()
    throws Exception
  {
    BTrafficLightServerDevice device1 = new BTrafficLightServerDevice();
    device1.setIntersectionId("a");
    network.add("device1", device1);

    BTrafficLightServerDevice device2 = new BTrafficLightServerDevice();
    device2.setIntersectionId("b");
    network.add("device2", device2);

    BEnumWritable device1Point1 = new BEnumWritable();
    BEnumWritable device1Point2 = new BEnumWritable();
    BEnumWritable device2Point1 = new BEnumWritable();
    BEnumWritable device2Point2 = new BEnumWritable();

    device1Point1.set("proxyExt", new BTrafficLightServerProxyExt());
    device1Point2.set("proxyExt", new BTrafficLightServerProxyExt());
    device2Point1.set("proxyExt", new BTrafficLightServerProxyExt());
    device2Point2.set("proxyExt", new BTrafficLightServerProxyExt());

    device1Point1.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    device1Point2.setOut(new BStatusEnum(BTrafficLightState.yellow, BStatus.ok));
    device2Point1.setOut(new BStatusEnum(BTrafficLightState.green, BStatus.ok));
    device2Point2.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));

    device1.getPoints().add("n", device1Point1);
    device1.getPoints().add("s", device1Point2);
    device2.getPoints().add("n", device2Point1);
    device2.getPoints().add("s", device2Point2);

    TrafficLightServerGetIntersectionReq request = new TrafficLightServerGetIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "get a");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerGetIntersectionResp, "Response should be of the correct type");

    Map<String, BTrafficLightState> expectedMap = makeMap(
      new String[]{ "n", "s" },
      new BTrafficLightState[]{ BTrafficLightState.red, BTrafficLightState.yellow }
    );
    Assert.assertEquals(responseString, makeSuccessfulGetIntersectionResponse(expectedMap),
      "Get intersection request for existing device should result in successful get intersection response"
    );

    request = new TrafficLightServerGetIntersectionReq(new BAddress());
    setLinkMessageFromString(request, "get b");
    listener.receiveMessage(request);

    response = network.getLastMessage();
    responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerGetIntersectionResp, "Response should be of the correct type");

    expectedMap = makeMap(
      new String[]{ "n", "s" },
      new BTrafficLightState[]{ BTrafficLightState.green, BTrafficLightState.red }
    );
    Assert.assertEquals(responseString, makeSuccessfulGetIntersectionResponse(expectedMap),
      "Get intersection request for existing device should result in successful get intersection response"
    );
  }

//endregion get intersection
//region set light

  public void setLightWithNoInfoCausesGenericErrorResponse()
  {
    listener.receiveMessage(new TrafficLightServerSetLightReq(new BAddress()));

    NMessage response = network.getLastMessage();
    Assert.assertTrue(response instanceof TrafficLightServerGenericErrorResp, "Response should be of the correct type");
  }

  public void setLightWithMissingDeviceCausesSetLightFailureResponse()
    throws Exception
  {
    TrafficLightServerSetLightReq request = new TrafficLightServerSetLightReq(new BAddress());
    setLinkMessageFromString(request, "set a n green");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerSetLightResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedSetLightResponse(),
      "set light request with missing device should result in failed set light response"
    );
  }

  public void setLightWithDownDeviceCausesSetLightFailureResponse()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    device.setEnabled(false);
    network.add("device", device);

    TrafficLightServerSetLightReq request = new TrafficLightServerSetLightReq(new BAddress());
    setLinkMessageFromString(request, "set a n green");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerSetLightResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedSetLightResponse(),
      "set light request with down device should result in failed set light response"
    );
  }

  public void setLightWithMissingPointCausesSetLightFailureResponse()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    TrafficLightServerSetLightReq request = new TrafficLightServerSetLightReq(new BAddress());
    setLinkMessageFromString(request, "set a n green");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerSetLightResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeFailedSetLightResponse(),
      "set light request for existing device with missing point should result in failed set light response"
    );
  }

  public void testSuccessfulSetLight()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    BEnumWritable point1 = new BEnumWritable();
    BEnumWritable point2 = new BEnumWritable();
    BEnumWritable point3 = new BEnumWritable();
    BEnumWritable point4 = new BEnumWritable();

    point1.set("proxyExt", new BTrafficLightServerProxyExt());
    point2.set("proxyExt", new BTrafficLightServerProxyExt());
    point3.set("proxyExt", new BTrafficLightServerProxyExt());
    point4.set("proxyExt", new BTrafficLightServerProxyExt());

    point1.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point2.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point3.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point4.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));

    device.getPoints().add("n", point1);
    device.getPoints().add("s", point2);
    device.getPoints().add("e", point3);
    device.getPoints().add("w", point4);

    TrafficLightServerSetLightReq request = new TrafficLightServerSetLightReq(new BAddress());
    setLinkMessageFromString(request, "set a n green");
    listener.receiveMessage(request);

    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);
    Assert.assertTrue(response instanceof TrafficLightServerSetLightResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulSetLightResponse(new TrafficLightProtocol.SetLightRequestInfo("a", "n", BTrafficLightState.green)),
      "set light request for existing device with missing point should result in failed set light response"
    );

    Assert.assertEquals(point1.getFallback().getEnum().getOrdinal(), BTrafficLightState.green.getOrdinal(), "Specified light should have been set");
    Assert.assertNotEquals(point2.getFallback().getEnum().getOrdinal(), BTrafficLightState.green.getOrdinal(), "Other lights should not have been set");
    Assert.assertNotEquals(point3.getFallback().getEnum().getOrdinal(), BTrafficLightState.green.getOrdinal(), "Other lights should not have been set");
    Assert.assertNotEquals(point4.getFallback().getEnum().getOrdinal(), BTrafficLightState.green.getOrdinal(), "Other lights should not have been set");
  }

//endregion set light
//region discover

  public void testDiscoverWithNoDevices()
    throws Exception
  {
    listener.receiveMessage(new TrafficLightServerDiscoverReq(new BAddress()));
    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);

    Assert.assertTrue(response instanceof TrafficLightServerDiscoverResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulDiscoverResponse(Collections.emptyMap()));
  }

  public void testDiscoverWithNoPoints()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    listener.receiveMessage(new TrafficLightServerDiscoverReq(new BAddress()));
    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);

    Assert.assertTrue(response instanceof TrafficLightServerDiscoverResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulDiscoverResponse(Collections.singletonMap("a", Collections.emptyList())));
  }

  public void testDiscoverWithOnePoint()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    BEnumWritable point = new BEnumWritable();
    point.set("proxyExt", new BTrafficLightServerProxyExt());
    point.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    device.getPoints().add("n", point);

    listener.receiveMessage(new TrafficLightServerDiscoverReq(new BAddress()));
    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);

    Assert.assertTrue(response instanceof TrafficLightServerDiscoverResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulDiscoverResponse(Collections.singletonMap("a", Collections.singletonList("n"))));
  }

  public void testDiscoverWithMultiplePoints()
    throws Exception
  {
    BTrafficLightServerDevice device = new BTrafficLightServerDevice();
    device.setIntersectionId("a");
    network.add("device", device);

    BEnumWritable point1 = new BEnumWritable();
    BEnumWritable point2 = new BEnumWritable();
    BEnumWritable point3 = new BEnumWritable();
    BEnumWritable point4 = new BEnumWritable();

    point1.set("proxyExt", new BTrafficLightServerProxyExt());
    point2.set("proxyExt", new BTrafficLightServerProxyExt());
    point3.set("proxyExt", new BTrafficLightServerProxyExt());
    point4.set("proxyExt", new BTrafficLightServerProxyExt());

    point1.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point2.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point3.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    point4.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));

    device.getPoints().add("n", point1);
    device.getPoints().add("s", point2);
    device.getPoints().add("e", point3);
    device.getPoints().add("w", point4);

    listener.receiveMessage(new TrafficLightServerDiscoverReq(new BAddress()));
    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);

    Assert.assertTrue(response instanceof TrafficLightServerDiscoverResp, "Response should be of the correct type");
    Assert.assertEquals(responseString, makeSuccessfulDiscoverResponse(Collections.singletonMap("a", Arrays.asList("n", "s", "e", "w"))));
  }

  public void testDiscoverWithMultipleDevices()
    throws Exception
  {
    BTrafficLightServerDevice device1 = new BTrafficLightServerDevice();
    device1.setIntersectionId("a");
    network.add("device1", device1);

    BTrafficLightServerDevice device2 = new BTrafficLightServerDevice();
    device2.setIntersectionId("b");
    network.add("device2", device2);

    BEnumWritable device1Point1 = new BEnumWritable();
    BEnumWritable device1Point2 = new BEnumWritable();
    BEnumWritable device2Point1 = new BEnumWritable();
    BEnumWritable device2Point2 = new BEnumWritable();

    device1Point1.set("proxyExt", new BTrafficLightServerProxyExt());
    device1Point2.set("proxyExt", new BTrafficLightServerProxyExt());
    device2Point1.set("proxyExt", new BTrafficLightServerProxyExt());
    device2Point2.set("proxyExt", new BTrafficLightServerProxyExt());

    device1Point1.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    device1Point2.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    device2Point1.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));
    device2Point2.setOut(new BStatusEnum(BTrafficLightState.red, BStatus.ok));

    device1.getPoints().add("n", device1Point1);
    device1.getPoints().add("s", device1Point2);
    device2.getPoints().add("n", device2Point1);
    device2.getPoints().add("s", device2Point2);

    listener.receiveMessage(new TrafficLightServerDiscoverReq(new BAddress()));
    NMessage response = network.getLastMessage();
    String responseString = getMessageAsString(response);

    Assert.assertTrue(response instanceof TrafficLightServerDiscoverResp, "Response should be of the correct type");

    @SuppressWarnings("unchecked")
    Map<String, List<String>> expectedMap = makeMap(new String[]{ "a", "b" }, new List[]{ Arrays.asList("n", "s"), Arrays.asList("n", "s") });
    Assert.assertEquals(responseString, makeSuccessfulDiscoverResponse(expectedMap));
  }

//endregion discover
//region misc

  public void unrecognizedRequestCausesGenericErrorResponse()
  {
    listener.receiveMessage(new UnrecognizedRequest(new BAddress()));
    NMessage response = network.getLastMessage();
    Assert.assertTrue(response instanceof TrafficLightServerGenericErrorResp, "Unrecognized message types should result in generic error response");
  }

  private static final class UnrecognizedRequest
    extends NMessage
  {
    public UnrecognizedRequest(BAddress address)
    {
      super(address);
    }

    @Override
    public void fromInputStream(InputStream in)
    {

    }
  }

//endregion misc

  private BTestTrafficLightServerNetwork network;
  private TrafficLightServerListener listener;
}
