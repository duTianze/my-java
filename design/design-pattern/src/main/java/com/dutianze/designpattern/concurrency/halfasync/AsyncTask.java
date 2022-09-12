package com.dutianze.designpattern.concurrency.halfasync;

import java.util.concurrent.Callable;

/**
 * <h2 id="real-world-examples">Real world examples</h2>
 * <ul>
 * <li><a href="https://www.dre.vanderbilt.edu/~schmidt/PDF/PLoP-95.pdf">BSD Unix networking subsystem</a></li>
 * <li><a href="http://www.omg.org/news/meetings/workshops/presentations/realtime2001/4-3_Pyarali_thread-pool.pdf">Real Time CORBA</a></li>
 * <li><a href="https://developer.android.com/reference/android/os/AsyncTask">Android AsyncTask framework</a></li>
 * </ul>
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="https://www.dre.vanderbilt.edu/~schmidt/PDF/PLoP-95.pdf">Douglas C. Schmidt and Charles D. Cranor - Half Sync/Half Async</a></li>
 * <li><a href="https://www.amazon.com/gp/product/0471606952/ref=as_li_tl?ie=UTF8&amp;camp=1789&amp;creative=9325&amp;creativeASIN=0471606952&amp;linkCode=as2&amp;tag=javadesignpat-20&amp;linkId=889e4af72dca8261129bf14935e0f8dc">Pattern Oriented Software Architecture Volume 2: Patterns for Concurrent and Networked Objects</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/9/8
 */
public interface AsyncTask<O> extends Callable<O> {

  void onPreCall();

  void onPostCall(O result);

  void onError(Throwable throwable);

  @Override
  O call() throws Exception;
}
