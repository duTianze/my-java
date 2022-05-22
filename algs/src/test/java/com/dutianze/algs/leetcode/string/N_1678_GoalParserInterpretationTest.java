package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/22
 */
class N_1678_GoalParserInterpretationTest {

    private final N_1678_GoalParserInterpretation solution = new N_1678_GoalParserInterpretation();

    @Test
    void interpret() {
        String interpret = solution.interpret("G()(al)");
        Assertions.assertEquals("Goal", interpret);
    }
}