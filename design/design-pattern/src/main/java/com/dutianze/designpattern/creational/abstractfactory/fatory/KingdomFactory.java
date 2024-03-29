package com.dutianze.designpattern.creational.abstractfactory.fatory;

import com.dutianze.designpattern.creational.abstractfactory.fatory.impl.ElfKingdomFactory;
import com.dutianze.designpattern.creational.abstractfactory.fatory.impl.OrcKingdomFactory;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.Army;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.Castle;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.King;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.Kingdom;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilderFactory.html">javax.xml.parsers.DocumentBuilderFactory</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/xml/transform/TransformerFactory.html#newInstance--">javax.xml.transform.TransformerFactory</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/xml/xpath/XPathFactory.html#newInstance--">javax.xml.xpath.XPathFactory</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/6
 */
public interface KingdomFactory {

  Castle createCastle();

  King createKing();

  Army createArmy();

  default Kingdom createKingdom() {
    return new Kingdom(this);
  }

  enum KingdomType {
    ELF, ORC
  }

  static KingdomFactory makeFactory(KingdomType type) {
    return switch (type) {
      case ELF -> new ElfKingdomFactory();
      case ORC -> new OrcKingdomFactory();
    };
  }
}
