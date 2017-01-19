package io.tripod.oss.velocypack

import io.tripod.oss.velocypack.codecs.FilterArrayOptionals
import scodec.Codec
import scodec.bits._
import scodec.codecs._
import scodec.codecs.literals._
import io.tripod.oss.velocypack.codecs._

sealed trait VPValue

case class VPNone()
case class EmptyArray()
case class VPArray(subvals: List[VPValue]) extends VPValue

object VPNone {
  implicit val discriminator = Discriminator[VPValue, VPNone, Byte] = Discriminator(hex"00")
  implicit val codec = ignore(0).as[VPNone]
}

object EmptyArray {
  implicit val discriminator = Discriminator[VPValue, VPNone, Byte] = Discriminator(hex"01")
  implicit val codec = ignore(0).as[EmptyArray]
}

object ArrayWithoutIndexTable1Byte {
  implicit val discriminator = Discriminator[VPValue, VPNone, Byte] = Discriminator(hex"02")
  implicit val codec = listOfNWithDecrement(uintL(1), 2, filterArrayOptionals(VPValue.codec.auto)).as[VPArray]
}

object ArrayWithoutIndexTable2Byte {
  implicit val discriminator = Discriminator[VPValue, VPNone, Byte] = Discriminator(hex"03")
  implicit val codec = listOfNWithDecrement(uint2L, 3, filterArrayOptionals(VPValue.codec.auto)).as[VPArray]
}

object ArrayWithoutIndexTable4Byte {
  implicit val discriminator = Discriminator[VPValue, VPNone, Byte] = Discriminator(hex"04")
  implicit val codec = listOfNWithDecrement(uint4L, 5, filterArrayOptionals(VPValue.codec.auto)).as[VPArray]
}

object ArrayWithoutIndexTable8Byte {
  implicit val discriminator = Discriminator[VPValue, VPNone, Byte] = Discriminator(hex"05")
  implicit val codec = listOfNWithDecrement(uint8L, 9, filterArrayOptionals(VPValue.codec.auto)).as[VPArray]
}

object VPValue {
  implicit val discriminated: Discriminated[VPValue, Byte] = Discriminated(ubyte(1))
  implicit val codec = Codec.coproduct[VPValue].discriminatedBy(ubyte(1))
}

