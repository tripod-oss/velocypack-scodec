package io.tripod.oss.velocypack.codecs

import scodec.{Attempt, Codec, DecodeResult, Err, SizeBound}
import scodec.bits.BitVector
import scodec.bits._

private[velocypack] class FilterArrayOptionals[A](vpCodec: Codec[A])
    extends Codec[A] {
  def sizeBound: SizeBound = vpCodec.sizeBound
  def encode(value: A): Attempt[BitVector] = vpCodec.encode(value)
  def decode(bits: BitVector): Attempt[DecodeResult[A]] =
    vpCodec.decode(bits.bytes.dropWhile(b ⇒ b == 0).bits)
}
