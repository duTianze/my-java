package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author dutianze
 * @date 2022/3/12
 */
class N_1920_BuildArrayFromPermutationTest {

    private final N_1920_BuildArrayFromPermutation solution = new N_1920_BuildArrayFromPermutation();

    @ParameterizedTest
    @MethodSource(value = "methods")
    void buildArrayTest(String method) {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] expected = {0, 1, 2, 4, 5, 3};

        int[] actual = ReflectionTestUtils.invokeMethod(solution, method, (Object) nums);

        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<String> methods() {
        return Arrays.stream(N_1920_BuildArrayFromPermutation.class.getDeclaredMethods())
                     .filter(m -> Modifier.isPublic(m.getModifiers()))
                     .map(Method::getName);
    }
}
