package com.dutianze.designpattern.structural.proxy;

import lombok.RequiredArgsConstructor;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html">java.lang.reflect.Proxy</a></li>
 * <li><a href="https://commons.apache.org/proper/commons-proxy/">Apache Commons Proxy</a></li>
 * <li>Mocking frameworks <a href="https://site.mockito.org/">Mockito</a>,
 * <a href="https://powermock.github.io/">Powermock</a>, <a href="https://easymock.org/">EasyMock</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/13
 */
@RequiredArgsConstructor
public class Wizard {

  private final String name;

  @Override
  public String toString() {
    return name;
  }
}