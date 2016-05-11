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