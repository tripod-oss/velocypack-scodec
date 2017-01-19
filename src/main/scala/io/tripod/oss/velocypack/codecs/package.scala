package io.tripod.oss.velocypack

import scodec.{Attempt, Codec, Err}
import scodec.codecs.ListCodec

/**
  * Created by njouanin on 19/01/17.
  */
package object codecs {

  def listOfNWithDecrement[A](countCodec: Codec[Int],
                              decrement: Int,
                              valueCodec: Codec[A]): Codec[List[A]] =
    countCodec
      .flatZip { count =>
        new ListCodec(valueCodec, Some(count - decrement))
      }
      .narrow[List[A]](
        {
          case (cnt, xs) =>
            if (xs.size == cnt) Attempt.successful(xs)
            else
              Attempt.failure(Err(
                s"Insufficient number of elements: decoded ${xs.size} but should have decoded $cnt"))
        },
        xs => (xs.size, xs)
      )
      .withToString(s"listOfN($countCodec, $valueCodec)")

  def filterArrayOptionals[A](vpCodec: Codec[A]) =
    new FilterArrayOptionals(vpCodec)
}
