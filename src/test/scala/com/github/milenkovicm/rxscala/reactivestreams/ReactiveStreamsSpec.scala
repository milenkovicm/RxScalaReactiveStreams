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

import java.util.concurrent.{CountDownLatch, TimeUnit}

import org.reactivestreams.Subscription
import org.scalatest.{Matchers, WordSpec}
import rx.lang.scala.Observable

class ReactiveStreamsSpec  extends WordSpec with Matchers {


  "Rx Subscriber" should {
    "be casted to Reactive Stream Subscriber" in {

      import RxReactiveStreams.asSubscriber

      val latch = new CountDownLatch(1)
      val reactiveStreamPublisher = new org.reactivestreams.Publisher[String] {
        override def subscribe(s: org.reactivestreams.Subscriber[_ >: String]): Unit = {
          s.onNext("hello")
          s.onComplete()
        }
      }

      val rxSubscriber = new rx.lang.scala.Subscriber[String]() {
        override def onNext(value: String): Unit = latch.countDown()
      }

      reactiveStreamPublisher.subscribe(rxSubscriber)

      latch.await(5, TimeUnit.SECONDS) shouldBe true

    }
  }

  "Reactive Stream Publisher" should {
    "be casted to Rx Observable" in {

      import RxReactiveStreams.asObservable

      val latch = new CountDownLatch(1)
      val reactiveStreamPublisher = new org.reactivestreams.Publisher[String] {
        override def subscribe(s: org.reactivestreams.Subscriber[_ >: String]): Unit = {
          s.onNext("hello")
          s.onComplete()
        }
      }
      val rxSubscriber = new rx.lang.scala.Subscriber[String]() {
        override def onNext(value: String): Unit = latch.countDown()
      }

      reactiveStreamPublisher.subscribe(rxSubscriber)
      latch.await(5, TimeUnit.SECONDS) shouldBe true

    }
  }

  "Reactive Stream Subscriber" should {
    "be casted to Rx Subscriber"  in {
      import RxReactiveStreams.asPublisher

      val latch = new CountDownLatch(1)
      val reactiveStreamSubscriber = new org.reactivestreams.Subscriber[String] {
        override def onError(t: Throwable): Unit = println("onError")
        override def onSubscribe(s: Subscription): Unit = s.request(1)
        override def onComplete(): Unit = println("onComplete")
        override def onNext(t: String): Unit = latch.countDown()
      }

      Observable.just("hello").subscribe(reactiveStreamSubscriber)

      latch.await(5, TimeUnit.SECONDS) shouldBe true
    }
  }
}
