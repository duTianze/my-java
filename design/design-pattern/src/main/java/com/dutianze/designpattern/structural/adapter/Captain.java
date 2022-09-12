package com.dutianze.designpattern.structural.adapter;

import com.dutianze.designpattern.structural.adapter.boat.RowingBoat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2 id="real-world-examples">Real-world examples</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList%28T...%29">java.util.Arrays#asList()</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#list-java.util.Enumeration-">java.util.Collections#list()</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#enumeration-java.util.Collection-">java.util.Collections#enumeration()</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/adapters/XmlAdapter.html#marshal-BoundType-">javax.xml.bind.annotation.adapters.XMLAdapter</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/11
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Captain {

  private RowingBoat rowingBoat;

  void row() {
    rowingBoat.row();
  }
}