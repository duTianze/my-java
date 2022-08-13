package com.dutianze.designpattern.structural.decorator;

/**
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
