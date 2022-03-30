package com.dutainze.algs.leetcode.string;

import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/defanging-an-ip-address/">1108. Defanging an IP Address</a>
 * <h2>Easy</h2>
 * <pre>
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * Constraints:
 *
 *     The given address is a valid IPv4 address.
 * </pre>
 *
 * @author dutianze
 * @date 2022/3/31
 */
public class N_1108_DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        for (char c : address.toCharArray()) {
            builder.append(c == '.' ? "[.]" : c);
        }
        return builder.toString();
    }

    public String defangIPaddrSimple(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public String defangIPaddrStream(String address) {
        return address.chars()
                      .mapToObj(e -> (char) e)
                      .flatMap(e -> {
                          if (e.equals('.')) {
                              return Stream.of('[', ".", "]");
                          }
                          return Stream.of(e);
                      })
                      .collect(Collector.of(StringBuilder::new,
                                            StringBuilder::append,
                                            StringBuilder::append,
                                            StringBuilder::toString));
    }
}
