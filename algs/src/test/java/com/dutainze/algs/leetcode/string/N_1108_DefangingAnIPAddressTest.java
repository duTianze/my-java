package com.dutainze.algs.leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/3/31
 */
class N_1108_DefangingAnIPAddressTest {

    private final N_1108_DefangingAnIPAddress solution = new N_1108_DefangingAnIPAddress();

    @Test
    void defangIPaddr() {
        String address = "255.100.50.0";
        String excepted = "255[.]100[.]50[.]0";

        String result = solution.defangIPaddr(address);
        String resultSimple = solution.defangIPaddrSimple(address);
        String resultStream = solution.defangIPaddrStream(address);

        Assertions.assertThat(result).isEqualTo(excepted);
        Assertions.assertThat(resultSimple).isEqualTo(excepted);
        Assertions.assertThat(resultStream).isEqualTo(excepted);
    }
}
