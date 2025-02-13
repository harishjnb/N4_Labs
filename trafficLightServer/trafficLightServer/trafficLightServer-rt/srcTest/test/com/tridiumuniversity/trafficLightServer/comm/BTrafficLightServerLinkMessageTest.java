/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.comm;

import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.LINK_MESSAGE_END_BYTE;
import static test.com.tridiumuniversity.trafficLightServer.util.TestUtils.LINK_MESSAGE_START_BYTE;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.trafficLightServer.comm.TrafficLightServerLinkMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tridium.ndriver.comm.NMessage;

@NiagaraType
@Test
public class BTrafficLightServerLinkMessageTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.trafficLightServer.comm.BTrafficLightServerLinkMessageTest(2979906276)1.0$ @*/
/* Generated Wed Jan 03 13:52:28 EST 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrafficLightServerLinkMessageTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void cannotReceiveMessageWithoutStartByte()
    throws IOException
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    ByteArrayInputStream inputStream = new ByteArrayInputStream("0123456789".getBytes());
    Assert.assertFalse(linkMessage.receive(inputStream), "receive should return false when there is no start byte");
  }

  public void cannotReceiveMessageWhenEndByteIsBeforeStartByte()
    throws IOException
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    ByteArrayInputStream inputStream = new ByteArrayInputStream((LINK_MESSAGE_END_BYTE + "0123456789" + LINK_MESSAGE_START_BYTE).getBytes());
    Assert.assertFalse(linkMessage.receive(inputStream), "receive should return false when end byte is before start byte");
  }

  public void cannotReceiveMessageThatExceedsMaxLength()
    throws IOException
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(5);
    ByteArrayInputStream inputStream = new ByteArrayInputStream((LINK_MESSAGE_START_BYTE + "0123456789" + LINK_MESSAGE_END_BYTE).getBytes());
    Assert.assertFalse(linkMessage.receive(inputStream), "receive should return false when the message exceeds the maximum length");
  }

  public void cannotReceiveMessageWithMultipleStartBytes()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    ByteArrayInputStream inputStream = new ByteArrayInputStream((LINK_MESSAGE_START_BYTE + "01234" + LINK_MESSAGE_START_BYTE + "56789").getBytes());
    Assert.assertFalse(linkMessage.receive(inputStream), "receive should return false when there are multiple start bytes");
  }

  public void testSuccessfulReceiveMessage()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    ByteArrayInputStream inputStream = new ByteArrayInputStream((LINK_MESSAGE_START_BYTE + "0123456789" + LINK_MESSAGE_END_BYTE).getBytes());
    Assert.assertTrue(linkMessage.receive(inputStream), "receive should return true for valid message");
    Assert.assertEquals(Arrays.copyOfRange(linkMessage.getByteArray(), 0, 10), "0123456789".getBytes(),
      "bytes stored in link message should be the same as the bytes provided to receive"
    );
  }

  public void sendMessageAddsStartAndEndBytes()
    throws Exception
  {
    TrafficLightServerLinkMessage linkMessage = new TrafficLightServerLinkMessage(100);
    linkMessage.setMessage(new StaticMessage());
    Assert.assertEquals(
      Arrays.copyOfRange(linkMessage.getByteArray(), 0, 7),
      new byte[]{ LINK_MESSAGE_START_BYTE, 1, 2, 3, 4, 5, LINK_MESSAGE_END_BYTE },
      "set message should add start and end bytes to contents of NMessage"
    );
  }

  private final class StaticMessage
    extends NMessage
  {
    @Override
    public boolean toOutputStream(OutputStream os)
      throws IOException
    {
      os.write(new byte[]{ 1, 2, 3, 4, 5 });
      return true;
    }
  }
}
