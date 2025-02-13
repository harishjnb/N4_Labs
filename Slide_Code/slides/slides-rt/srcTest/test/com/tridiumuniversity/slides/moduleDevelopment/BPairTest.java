/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.moduleDevelopment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BDouble;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.moduleDevelopment.BPair;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@Test
public class BPairTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.moduleDevelopment.BPairTest(2979906276)1.0$ @*/
/* Generated Tue Jul 23 16:13:40 EDT 2024 by Slot-o-Matic (c) Tridium, Inc. 2012-2024 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPairTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void testGetters()
  {
    BPair pair = BPair.make(BDouble.make(1), BDouble.make(2));
    Assert.assertEquals(pair.getFirst(), BDouble.make(1), "getFirst should return first element of pair");
    Assert.assertEquals(pair.getSecond(), BDouble.make(2), "getSecond should return second element of pair");
  }

  public void testEncodeToString()
  {
    BPair pair = BPair.make(BDouble.make(1), BDouble.make(2));
    Assert.assertEquals(pair.encodeToString(), "(1.00,2.00)", "encodeToString should return doubles separated by comma and surrounded by parens");
  }

  public void testDecodeFromString()
  {
    BPair pair = BPair.DEFAULT.decodeFromString("(1,2)");
    Assert.assertEquals(pair.getFirst(), BDouble.make(1), "decodeFromString should decode correctly formatted BPair");
    Assert.assertEquals(pair.getSecond(), BDouble.make(2), "decodeFromString should decode correctly formatted BPair");
  }

  public void testEncode()
    throws IOException
  {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOut = new DataOutputStream(byteArrayOutputStream);
    BPair pair = BPair.make(BDouble.make(1), BDouble.make(2));
    pair.encode(dataOut);

    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    DataInputStream dataIn = new DataInputStream(byteArrayInputStream);
    Assert.assertEquals(dataIn.readUTF(), "(1.00,2.00)", "encode should write UTF string with doubles separated by comma and surrounded by parens");
  }

  public void testDecode()
    throws IOException
  {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOut = new DataOutputStream(byteArrayOutputStream);
    dataOut.writeUTF("(1,2)");

    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    DataInputStream dataIn = new DataInputStream(byteArrayInputStream);
    BPair pair = BPair.DEFAULT.decode(dataIn);

    Assert.assertEquals(pair.getFirst(), BDouble.make(1), "decode should decode correctly formatted BPair");
    Assert.assertEquals(pair.getSecond(), BDouble.make(2), "decode should decode correctly formatted BPair");
  }

  public void testEqualPairs()
  {
    BPair one = BPair.make(BDouble.make(1), BDouble.make(2));
    BPair two = BPair.make(BDouble.make(1), BDouble.make(2));
    Assert.assertEquals(one, two, "equals should return true for equal pairs");
    Assert.assertEquals(one.hashCode(), two.hashCode(), "hashCode should be equal for equal pairs");
  }
}
