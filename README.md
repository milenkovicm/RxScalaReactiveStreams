# RxScala wrapper for RxJavaReactiveStreams ![travis-ci](https://travis-ci.org/milenkovicm/RxScalaReactiveStreams.svg)

Library provides three implicit methods for conversion between [RxScala](https://github.com/ReactiveX/RxScala) 
and [ReactiveStreams](http://www.reactive-streams.org/) classes. 

It is based on [RxJavaReactiveStreams](https://github.com/ReactiveX/RxJavaReactiveStreams) 

Implicit methods:

```scala
implicit def asObservable[T](p: Publisher[T]): Observable[T] = toObservable(p)
implicit def asPublisher[T](o: Observable[T]): Publisher[_ <: T] = toPublisher(o)
implicit def asSubscriber[T](s: Subscriber[T]): org.reactivestreams.Subscriber[_ >: T] = toSubscriber(s)
```

are defined in `com.github.milenkovicm.rxscala.reactivestreams.RxReactiveStreams`

## LICENSE

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.