/*
 * Copyright (c) 2016. Marko Milenkovic ( http://github.com/milenkovicm )
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.milenkovicm.rxscala.reactivestreams

import org.reactivestreams.Publisher
import rx.RxReactiveStreams._
import rx.lang.scala.JavaConversions._
import rx.lang.scala.{Observable, Subscriber}

import scala.language.implicitConversions

object RxReactiveStreams {

  implicit def asObservable[T](p: Publisher[T]): Observable[T] = toObservable(p)
  implicit def asPublisher[T](o: Observable[T]): Publisher[_ <: T] = toPublisher(o)
  implicit def asSubscriber[T](s: Subscriber[T]): org.reactivestreams.Subscriber[_ >: T] = toSubscriber(s)
}
