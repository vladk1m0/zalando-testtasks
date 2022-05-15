package com.zalando.testtasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringTransformABCDT {
    @Test
    public void solution_whenInCBACD_thenResultEqC() {
        assertEquals("C", StringTransformABCD.solution("CBACD"));
    }

    @Test
    public void solution_whenInCABABD_thenResultEmptyStr() {
        assertEquals("", StringTransformABCD.solution("CABABD"));
    }

    @Test
    public void solution_whenInACBDACBD_thenResultACBDACBD() {
        assertEquals("ACBDACBD", StringTransformABCD.solution("ACBDACBD"));
    }
}
