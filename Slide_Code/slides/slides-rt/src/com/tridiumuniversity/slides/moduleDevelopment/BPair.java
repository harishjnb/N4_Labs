/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package com.tridiumuniversity.slides.moduleDevelopment;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.NoSlotomatic;
import javax.baja.sys.BDouble;
import javax.baja.sys.BSimple;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NoSlotomatic
public final class BPair
  extends BSimple
{
  public static BPair make(BDouble one, BDouble two)
  {
    return new BPair(one, two);
  }

  private BPair(BDouble one, BDouble two)
  {
    this.one = one;
    this.two = two;
  }

  public BDouble getFirst()
  {
    return one;
  }

  public BDouble getSecond()
  {
    return two;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (!(obj instanceof BPair))
    {
      return false;
    }
    BPair other = (BPair) obj;
    return one.equals(other.one) && two.equals(other.two);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(one, two);
  }

  @Override
  public void encode(DataOutput out)
    throws IOException
  {
    out.writeUTF(encodeToString());
  }

  @Override
  public BPair decode(DataInput in)
    throws IOException
  {
    return decodeFromString(in.readUTF());
  }

  @Override
  public String encodeToString()
  {
    return String.format("(%s,%s)", one, two);
  }

  @Override
  public BPair decodeFromString(String s)
  {
    String withoutParens = s.substring(1, s.length() - 1);
    StringTokenizer stringTokenizer = new StringTokenizer(withoutParens, ",");
    String oneToken = stringTokenizer.nextToken();
    String twoToken = stringTokenizer.nextToken();
    return make(BDouble.make(oneToken), BDouble.make(twoToken));
  }

  public static final BPair DEFAULT = BPair.make(BDouble.DEFAULT, BDouble.DEFAULT);

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPair.class);

  private final BDouble one;
  private final BDouble two;
}
