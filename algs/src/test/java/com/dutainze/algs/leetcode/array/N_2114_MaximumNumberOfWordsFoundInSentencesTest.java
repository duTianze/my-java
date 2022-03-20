package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/3/20
 */
class N_2114_MaximumNumberOfWordsFoundInSentencesTest {

    private final N_2114_MaximumNumberOfWordsFoundInSentences solution = new N_2114_MaximumNumberOfWordsFoundInSentences();

    @Test
    void mostWordsFound() {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int expected = 6;

        int actual = solution.mostWordsFound(sentences);
        Assertions.assertEquals(actual, expected);
    }
}
