package com.zalando.testtasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMazeAssassinGuardWalkthrough {
    @Test
    public void solution_whenMapIsCorrectAndImpenetrableMaze_thenResultFalse() {
        boolean result = MazeAssassinGuardWalkthrough.solution(new String[]{"X.....>", "..v..X.", ".>..X..", "A......"});
        assertFalse(result);
    }

    @Test
    public void solution_whenMapIsCorrectAndNotWalkableMaze_thenResultTrue() {
        boolean result = MazeAssassinGuardWalkthrough.solution(new String[]{"...Xv", "AX..^", "XX..."});
        assertTrue(result);
    }

    @Test
    public void solution_whenMapIsCorrectAndNotWalkableMaze_thenResultFalse() {
        boolean result = MazeAssassinGuardWalkthrough.solution(new String[]{"...", ">.A"});
        assertFalse(result);
    }
}
