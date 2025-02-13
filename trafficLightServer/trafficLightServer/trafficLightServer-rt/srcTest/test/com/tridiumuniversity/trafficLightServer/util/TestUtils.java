/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.trafficLightServer.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NMessage;
import com.tridium.ndriver.io.TypedInputStream;

public final class TestUtils
{
  public static <K, V> Map<K, V> makeMap(K[] keys, V[] values)
  {
    if (keys.length != values.length)
    {
      throw new RuntimeException("makeMap: keys and values arrays have different lengths");
    }

    Map<K, V> map = new HashMap<>();
    for (int i = 0; i < keys.length; i++)
    {
      map.put(keys[i], values[i]);
    }
    return map;
  }

  public static String nullTerminate(String s)
  {
    return s + '\0';
  }

  public static void setLinkMessageFromString(NMessage message, String messageContents)
    throws Exception
  {
    String nullTerminatedMessageContents = messageContents + '\0';
    TypedInputStream stream = new TypedInputStream(nullTerminatedMessageContents.getBytes());
    message.fromInputStream(stream);
  }

  public static String getMessageAsString(NMessage message)
    throws Exception
  {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    message.toOutputStream(outputStream);
    return outputStream.toString();
  }

  public static void setLinkMessageFromString(LinkMessage message, String messageContents)
    throws Exception
  {
    String messageContentsWithStartAndEnd = LINK_MESSAGE_START_BYTE + messageContents + LINK_MESSAGE_END_BYTE;
    ByteArrayInputStream stream = new ByteArrayInputStream(messageContentsWithStartAndEnd.getBytes());
    message.receive(stream);
  }

  public static final char LINK_MESSAGE_START_BYTE = 0;
  public static final char LINK_MESSAGE_END_BYTE = 23;
}
