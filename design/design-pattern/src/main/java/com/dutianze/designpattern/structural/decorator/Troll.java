package com.dutianze.designpattern.structural.decorator;

/**
 * 穿衣服是使用装饰的一个例子。 觉得冷时， 你可以穿一件毛衣。 如果穿毛衣还觉得冷， 你可以再套上一件夹克。
 * <p>
 * 如果遇到下雨， 你还可以再穿一件雨衣。 所有这些衣物都 “扩展”了你的基本行为，但它们并不是你的一部分，
 * <p>
 * 如果你不再需要某件衣物， 可以方便地随时脱掉。
 * <p>
 *
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html">java.io.InputStream</a>, <a href="http://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html">java.io.OutputStream</a>,
 * <a href="http://docs.oracle.com/javase/8/docs/api/java/io/Reader.html">java.io.Reader</a> and <a href="http://docs.oracle.com/javase/8/docs/api/java/io/Writer.html">java.io.Writer</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#synchronizedCollection-java.util.Collection-">java.util.Collections#synchronizedXXX()</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#unmodifiableCollection-java.util.Collection-">java.util.Collections#unmodifiableXXX()</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#checkedCollection-java.util.Collection-java.lang.Class-">java.util.Collections#checkedXXX()</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/13
 */
public interface Troll {

  void attack();

  int getAttackPower();

  void fleeBattle();
}
