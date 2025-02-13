/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.message;

import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.isDiscoverRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.isGetIntersectionRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.isPingIntersectionRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.isPingNetworkRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.isSetLightRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedDiscoverResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedPingNetworkResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeFailedSetLightResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeGenericErrorResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulDiscoverResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulGetIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingIntersectionResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulPingNetworkResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.makeSuccessfulSetLightResponse;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.parseGetIntersectionRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.parsePingIntersectionRequest;
import static com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol.parseSetLightRequest;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.makeMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.message.BTrafficLightState;
import com.tridiumuniversity.trafficLightServer.message.TrafficLightProtocol;
import org.testng.Assert;
import org.testng.annotations.Test;

@NiagaraType
@Test
public class BTrafficLightProtocolTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.message.BTrafficLightProtocolTest(2979906276)1.0$ @*/
/* Generated Thu Jan 04 09:58:59 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightProtocolTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void testMakeGenericErrorResponse()
  {
    String genericErrorString = makeGenericErrorResponse();
    Assert.assertEquals(genericErrorString, EXPECTED_GENERIC_ERROR_STRING,
      "generic error string should be as expected"
    );
  }

  public void testIsPingNetworkRequest()
  {
    Assert.assertFalse(isPingNetworkRequest(""), "empty string is not a ping network request");
    Assert.assertFalse(
      isPingNetworkRequest(BAD_PING_REQUEST),
      BAD_PING_REQUEST + " is not a ping network request"
    );
    Assert.assertTrue(
      isPingNetworkRequest(PING_NETWORK_REQUEST),
      PING_NETWORK_REQUEST + " is a ping network request"
    );
  }

  public void testMakeSuccessfulPingNetworkResponse()
  {
    Assert.assertEquals(makeSuccessfulPingNetworkResponse(), SUCCESSFUL_PING_NETWORK_RESPONSE,
      "successful ping network response is not as expected"
    );
  }

  public void testMakeFailedPingNetworkResponse()
  {
    Assert.assertEquals(makeFailedPingNetworkResponse(), FAILED_PING_NETWORK_RESPONSE,
      "failed ping network response is not as expected"
    );
  }

  public void testIsPingIntersectionRequest()
  {
    Assert.assertFalse(isPingIntersectionRequest(""), "empty string is not a ping intersection request");
    Assert.assertFalse(
      isPingIntersectionRequest(BAD_PING_REQUEST),
      BAD_PING_REQUEST + " is not a ping intersection request"
    );
    Assert.assertTrue(
      isPingIntersectionRequest(PING_INTERSECTION_REQUEST),
      PING_NETWORK_REQUEST + " is a ping intersection request"
    );
  }

  public void testParsePingIntersectionRequest()
  {
    Assert.assertFalse(
      parsePingIntersectionRequest("").isPresent(),
      "empty string is not a ping intersection request"
    );
    Assert.assertFalse(
      parsePingIntersectionRequest(BAD_PING_REQUEST).isPresent(),
      BAD_PING_REQUEST + " is not a ping intersection request"
    );

    Optional<String> intersectionIdOpt = parsePingIntersectionRequest(PING_INTERSECTION_REQUEST);
    Assert.assertTrue(
      intersectionIdOpt.isPresent(),
      PING_INTERSECTION_REQUEST + " is a ping intersection request"
    );
    Assert.assertEquals(intersectionIdOpt.get(), INTERSECTION_ID,
      "ping intersection parsing should return the correct intersection id"
    );

    intersectionIdOpt = parsePingIntersectionRequest(PING_INTERSECTION_REQUEST_UPPERCASE);
    Assert.assertTrue(
      intersectionIdOpt.isPresent(),
      "the intersection id in ping intersection parsing should be case insensitive"
    );
    Assert.assertEquals(intersectionIdOpt.get(), INTERSECTION_ID,
      "ping intersection parsing should convert all intersection ids to lowercase"
    );
  }

  public void testMakeSuccessfulPingIntersectionResponse()
  {
    Assert.assertEquals(makeSuccessfulPingIntersectionResponse(INTERSECTION_ID), SUCCESSFUL_PING_INTERSECTION_RESPONSE,
      "successful ping intersection response is not as expected"
    );
  }

  public void testMakeFailedPingIntersectionResponse()
  {
    Assert.assertEquals(makeFailedPingIntersectionResponse(INTERSECTION_ID), FAILED_PING_INTERSECTION_RESPONSE,
      "failed ping intersection response is not as expected"
    );
  }

  public void testIsGetIntersectionRequest()
  {
    Assert.assertFalse(
      isGetIntersectionRequest(""),
      "empty string is not a get intersection request"
    );
    Assert.assertFalse(
      isGetIntersectionRequest(BAD_GET_INTERSECTION_REQUEST),
      BAD_GET_INTERSECTION_REQUEST + " is not a get intersection request"
    );
    Assert.assertTrue(
      isGetIntersectionRequest(GET_INTERSECTION_REQUEST),
      GET_INTERSECTION_REQUEST + " is a get intersection request"
    );
  }

  public void testParseGetIntersectionRequest()
  {
    Assert.assertFalse(
      parseGetIntersectionRequest("").isPresent(),
      "empty string is not a get intersection request"
    );
    Assert.assertFalse(
      parseGetIntersectionRequest(BAD_GET_INTERSECTION_REQUEST).isPresent(),
      BAD_GET_INTERSECTION_REQUEST + " is not a get intersection request"
    );

    Optional<String> intersectionIdOpt = parseGetIntersectionRequest(GET_INTERSECTION_REQUEST);
    Assert.assertTrue(
      intersectionIdOpt.isPresent(),
      GET_INTERSECTION_REQUEST + " is a get intersection request"
    );
    Assert.assertEquals(intersectionIdOpt.get(), INTERSECTION_ID,
      "get intersection parsing should return the correct intersection id"
    );

    intersectionIdOpt = parseGetIntersectionRequest(GET_INTERSECTION_REQUEST_UPPERCASE);
    Assert.assertTrue(
      intersectionIdOpt.isPresent(),
      "the intersection id in get intersection parsing should be case insensitive"
    );
    Assert.assertEquals(intersectionIdOpt.get(), INTERSECTION_ID,
      "get intersection parsing should convert all intersection ids to lowercase"
    );
  }

  public void testMakeSuccessfulGetIntersectionResponse()
  {
    Map<String, BTrafficLightState> lightStates = makeMap(
      new String[]{ "n", "s", "e", "w" },
      new BTrafficLightState[]{ BTrafficLightState.red, BTrafficLightState.yellow, BTrafficLightState.green, BTrafficLightState.red }
    );

    String responseString = makeSuccessfulGetIntersectionResponse(lightStates);

    Assert.assertTrue(
      responseString.startsWith("get "),
      "get intersection response should have expected prefix"
    );

    String[] tokens = responseString.substring("get ".length()).split("\t");
    Assert.assertEquals(tokens.length, 4,
      "get intersection response should include tab-delimited entries for each lightId"
    );

    Assert.assertTrue(
      Arrays.asList(tokens).contains("n red"),
      "get intersection response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(tokens).contains("s yellow"),
      "get intersection response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(tokens).contains("e green"),
      "get intersection response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(tokens).contains("w red"),
      "get intersection response should contain value for each lightId"
    );
  }

  public void testMakeFailedGetIntersectionResponse()
  {
    Assert.assertEquals(makeFailedGetIntersectionResponse(), FAILED_GET_INTERSECTION_RESPONSE,
      "failed get intersection response should be as expected"
    );
  }

  public void testIsSetLightRequest()
  {
    Assert.assertFalse(
      isSetLightRequest(""),
      "empty string is not a set light request"
    );
    Assert.assertFalse(
      isSetLightRequest(BAD_SET_LIGHT_REQUEST),
      BAD_SET_LIGHT_REQUEST + " is not a set light request"
    );
    Assert.assertTrue(
      isSetLightRequest(SET_LIGHT_REQUEST),
      SET_LIGHT_REQUEST + " is a set light request"
    );
  }

  public void testParseSetLightRequest()
  {
    Assert.assertFalse(
      parseSetLightRequest("").isPresent(),
      "empty string is not a set light request"
    );
    Assert.assertFalse(
      parseSetLightRequest(BAD_SET_LIGHT_REQUEST).isPresent(),
      BAD_SET_LIGHT_REQUEST + " is not a set light request"
    );

    Optional<TrafficLightProtocol.SetLightRequestInfo> setLightRequestInfoOpt = parseSetLightRequest(SET_LIGHT_REQUEST);
    Assert.assertTrue(
      setLightRequestInfoOpt.isPresent(),
      SET_LIGHT_REQUEST + " is a set light request"
    );
    Assert.assertEquals(setLightRequestInfoOpt.get(), new TrafficLightProtocol.SetLightRequestInfo(INTERSECTION_ID, LIGHT_ID, TRAFFIC_LIGHT_STATE),
      "set light parsing should return the correct info"
    );

    setLightRequestInfoOpt = parseSetLightRequest(SET_LIGHT_REQUEST_UPPERCASE);
    Assert.assertTrue(
      setLightRequestInfoOpt.isPresent(),
      "the intersection id and light id in set light parsing should be case insensitive"
    );
    Assert.assertEquals(setLightRequestInfoOpt.get(), new TrafficLightProtocol.SetLightRequestInfo(INTERSECTION_ID, LIGHT_ID, TRAFFIC_LIGHT_STATE),
      "set light parsing should convert all intersection ids to lowercase"
    );
  }

  public void testMakeSuccessfulSetLightResponse()
  {
    Assert.assertEquals(
      makeSuccessfulSetLightResponse(new TrafficLightProtocol.SetLightRequestInfo(INTERSECTION_ID, LIGHT_ID, TRAFFIC_LIGHT_STATE)),
      SUCCESSFUL_SET_LIGHT_RESPONSE,
      "successful set light response should be as expected"
    );
  }

  public void testMakeFailedSetLightResponse()
  {
    Assert.assertEquals(makeFailedSetLightResponse(), FAILED_SET_LIGHT_RESPONSE,
      "failed set light response should be as expected"
    );
  }

  public void testIsDiscoverRequest()
  {
    Assert.assertFalse(
      isDiscoverRequest(""),
      "empty string is not a discover request"
    );
    Assert.assertFalse(
      isDiscoverRequest(BAD_DISCOVER_REQUEST),
      BAD_DISCOVER_REQUEST + " is not a discover request"
    );
    Assert.assertTrue(
      isDiscoverRequest(DISCOVER_REQUEST),
      DISCOVER_REQUEST + " is a discover request"
    );
  }

  public void testMakeSuccessfulDiscoverResponse()
  {
    @SuppressWarnings("unchecked")
    Map<String, List<String>> intersectionIdToLightIdsMap = makeMap(
      new String[]{ "a", "b", "c" },
      new List[]{ Arrays.asList("n", "s"), Arrays.asList("e", "w"), Arrays.asList("n", "s", "e", "w") }
    );

    String responseString = makeSuccessfulDiscoverResponse(intersectionIdToLightIdsMap);

    Assert.assertTrue(
      responseString.startsWith("discover "),
      "discover response should have expected prefix"
    );

    String[] lightsByIntersection = responseString.substring("discover ".length()).split("\t");
    Assert.assertEquals(lightsByIntersection.length, 8,
      "discover response should include tab-delimited entries for each lightId"
    );

    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("a n"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("a s"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("b e"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("b w"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("c n"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("c s"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("c e"),
      "discover response should contain value for each lightId"
    );
    Assert.assertTrue(
      Arrays.asList(lightsByIntersection).contains("c w"),
      "discover response should contain value for each lightId"
    );
  }

  public void testMakeFailedDiscoverResponse()
  {
    Assert.assertEquals(makeFailedDiscoverResponse(), FAILED_DISCOVER_RESPONSE,
      "failed discover response should be as expected"
    );
  }

  private static final String INTERSECTION_ID = "a";
  private static final String LIGHT_ID = "n";
  private static final BTrafficLightState TRAFFIC_LIGHT_STATE = BTrafficLightState.green;
  private static final String EXPECTED_GENERIC_ERROR_STRING = "error";
  private static final String PING_NETWORK_REQUEST = "ping";
  private static final String BAD_PING_REQUEST = "badping";
  private static final String SUCCESSFUL_PING_NETWORK_RESPONSE = "ping ok";
  private static final String FAILED_PING_NETWORK_RESPONSE = "ping error";
  private static final String PING_INTERSECTION_REQUEST = "ping " + INTERSECTION_ID;
  private static final String PING_INTERSECTION_REQUEST_UPPERCASE = "ping " + INTERSECTION_ID.toUpperCase();
  private static final String SUCCESSFUL_PING_INTERSECTION_RESPONSE = "ping " + INTERSECTION_ID + " ok";
  private static final String FAILED_PING_INTERSECTION_RESPONSE = "ping " + INTERSECTION_ID + " error";
  private static final String GET_INTERSECTION_REQUEST = "get " + INTERSECTION_ID;
  private static final String BAD_GET_INTERSECTION_REQUEST = "badget " + INTERSECTION_ID;
  private static final String GET_INTERSECTION_REQUEST_UPPERCASE = "get " + INTERSECTION_ID.toUpperCase();
  private static final String FAILED_GET_INTERSECTION_RESPONSE = "get error";
  private static final String SET_LIGHT_REQUEST = String.format("set %s %s %s", INTERSECTION_ID, LIGHT_ID, TRAFFIC_LIGHT_STATE.getTag());
  private static final String BAD_SET_LIGHT_REQUEST = "badset a n green";
  private static final String SET_LIGHT_REQUEST_UPPERCASE = String.format("set %s %s %s", INTERSECTION_ID.toUpperCase(), LIGHT_ID.toUpperCase(), TRAFFIC_LIGHT_STATE.getTag());
  private static final String SUCCESSFUL_SET_LIGHT_RESPONSE = String.format("set %s %s %s ok", INTERSECTION_ID, LIGHT_ID, TRAFFIC_LIGHT_STATE.getTag());
  private static final String FAILED_SET_LIGHT_RESPONSE = "set error";
  private static final String DISCOVER_REQUEST = "discover";
  private static final String BAD_DISCOVER_REQUEST = "baddiscover";
  private static final String FAILED_DISCOVER_RESPONSE = "discover error";
}
