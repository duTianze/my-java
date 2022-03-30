package com.dutainze.algs.leetcode.string;

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
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                builder.append("[.]");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String defangIPaddrSimple(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
