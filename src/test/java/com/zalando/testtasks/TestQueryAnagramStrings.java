package com.zalando.testtasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestQueryAnagramStrings {

    @Test
    void solution_whenQaS202_thenResultIsOk() {
        int[] result = QueryAnagramStrings.solution(
                new String[]{"qwe", "ewq", "wtf", "ert", "rte"},
                new String[]{"qwe", "wer", "rte"}
        );

        assertArrayEquals(new int[]{2,0,2}, result);
    }

    @Test
    void solution_whenQaS000_thenResultIsOk() {
        int[] result = QueryAnagramStrings.solution(
                new String[]{"qwe", "ewq", "wtf", "ert", "rte"},
                new String[]{"abc", "cde", "edf"}
        );

        assertArrayEquals(new int[]{0,0,0}, result);
    }
}