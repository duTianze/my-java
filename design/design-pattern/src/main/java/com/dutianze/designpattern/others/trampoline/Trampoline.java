package com.dutianze.designpattern.others.trampoline;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://github.com/aol/cyclops-react">cyclops-react</a></li>
 * </ul>
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="https://medium.com/@johnmcclean/trampolining-a-practical-guide-for-awesome-java-developers-4b657d9c3076">Trampolining: a practical guide for awesome Java Developers</a></li>
 * <li><a href="http://mindprod.com/jgloss/trampoline.html">Trampoline in java </a></li>
 * <li><a href="https://www.slideshare.net/mariofusco/lazine">Laziness, trampolines, monoids and other functional amenities: this is not your father&#39;s Java</a></li>
 * <li><a href="https://github.com/bodar/totallylazy/blob/master/src/com/googlecode/totallylazy/Trampoline.java">Trampoline implementation</a></li>
 * <li><a href="https://stackoverflow.com/questions/189725/what-is-a-trampoline-function">What is a trampoline function?</a></li>
 * <li><a href="https://www.amazon.com/gp/product/1617293563/ref=as_li_qf_asin_il_tl?ie=UTF8&amp;tag=javadesignpat-20&amp;creative=9325&amp;linkCode=as2&amp;creativeASIN=1617293563&amp;linkId=ad53ae6f9f7c0982e759c3527bd2595c">Modern Java in Action: Lambdas, streams, functional and reactive programming</a></li>
 * <li><a href="https://www.amazon.com/gp/product/1617291994/ref=as_li_qf_asin_il_tl?ie=UTF8&amp;tag=javadesignpat-20&amp;creative=9325&amp;linkCode=as2&amp;creativeASIN=1617291994&amp;linkId=e3e5665b0732c59c9d884896ffe54f4f">Java 8 in Action: Lambdas, Streams, and functional-style programming</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/21
 */
public interface Trampoline<T> {

  T get();

  default Trampoline<T> next() {
    return null;
  }

  default T compute() {
    Trampoline<T> trampoline = this;
    while (trampoline.next() != null) {
      trampoline = trampoline.next();
    }
    return trampoline.get();
  }

  static <T> Trampoline<T> done(final T result) {
    return () -> result;
  }

  static <T> Trampoline<T> more(final Trampoline<Trampoline<T>> trampoline) {
    return new Trampoline<>() {

      @Override
      public T get() {
        return null;
      }

      public Trampoline<T> next() {
        return trampoline.get();
      }
    };
  }
}