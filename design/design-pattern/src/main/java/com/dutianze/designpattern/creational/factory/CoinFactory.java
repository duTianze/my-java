package com.dutianze.designpattern.creational.factory;

import com.dutianze.designpattern.creational.factory.coin.Coin;
import com.dutianze.designpattern.creational.factory.coin.CoinType;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#getInstance--">java.util.Calendar#getInstance()</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-">java.util.ResourceBundle#getBundle()</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getInstance--">java.text.NumberFormat#getInstance()</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html#forName-java.lang.String-">java.nio.charset.Charset#forName()</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/net/URLStreamHandlerFactory.html">java.net.URLStreamHandlerFactory#createURLStreamHandler(String)</a> (returns different singleton objects, depending on a protocol)</li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html#of(E">java.util.EnumSet#of()</a>)</li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/JAXBContext.html#createMarshaller--">javax.xml.bind.JAXBContext#createMarshaller()</a> and other similar methods.</li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/9/8
 */
public class CoinFactory {

  public static Coin getCoin(CoinType type) {
    return type.getConstructor().get();
  }
}
