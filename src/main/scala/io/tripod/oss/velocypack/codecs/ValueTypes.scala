package io.tripod.oss.velocypack.codecs

import scodec.bits._
import scodec.codecs._
import scodec.codecs.literals._

/**
  * Created by njouanin on 19/01/17.
  */
class ValueTypes {
  val none = constant(hex"00")
  val emptyArray = constant(hex"01")
  val arrayWithoutIndex1Byte = constant(hex"02")
  val arrayWithoutIndex2Bytes = constant(hex"03")
  val arrayWithoutIndex4Bytes = constant(hex"04")
  val arrayWithoutIndex8Bytes = constant(hex"05")
  val arrayWith1ByteIndex = constant(hex"06")
  val arrayWith2BytesIndex = constant(hex"07")
  val arrayWith4BytesIndex = constant(hex"08")
  val arrayWith8BytesIndex = constant(hex"09")
  val emptyObject = constant(hex"0a")
  val objectWith1ByteIndex = constant(hex"0b")
  val objectWith2BytesIndex = constant(hex"0c")
  val objectWith4BytesIndex = constant(hex"0d")
  val objectWith8BytesIndex = constant(hex"0e")
  val compactArray = constant(hex"13")
  val compactObject = constant(hex"14")
  val illegal = constant(hex"17")
  val `null` = constant(hex"18")
  val `false` = constant(hex"19")
  val `true` = constant(hex"1a")
  val double = constant(hex"1b")
  val utcDate = constant(hex"1c")
  val external = constant(hex"1d")
  val minKey = constant(hex"1e")
  val maxKey = constant(hex"1f")
  val signedInt = constant(bin"00100")
  val unsignedInt = constant(bin"00101")
  val smallIntegers = constant(bin"0011")
}
