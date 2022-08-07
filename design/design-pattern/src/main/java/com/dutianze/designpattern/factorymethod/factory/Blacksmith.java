package com.dutianze.designpattern.factorymethod.factory;

import com.dutianze.designpattern.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.factorymethod.weapon.WeaponType;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#getInstance--">java.util.Calendar</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-">java.util.ResourceBundle</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getInstance--">java.text.NumberFormat</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html#forName-java.lang.String-">java.nio.charset.Charset</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/net/URLStreamHandlerFactory.html#createURLStreamHandler-java.lang.String-">java.net.URLStreamHandlerFactory</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html#of-E-">java.util.EnumSet</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/JAXBContext.html#createMarshaller--">javax.xml.bind.JAXBContext</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/7
 */
public interface Blacksmith {

    Weapon manufactureWeapon(WeaponType weaponType);
}
