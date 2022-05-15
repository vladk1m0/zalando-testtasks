package com.zalando.testtasks;

public class StringTransformABCD {

    public static String solution(String A) {
        if (A == null || A.length() < 2) {
            return A;
        }

        char[] chars = A.toCharArray();
        int[] state = new int[3];
        int l = A.length();
        int s,k = 0;
        do {
            state[0] = 0;
            state[1] = 0;
            state[2] = 0;
            s = 0;

            for (int i = 0; i < l; i++) {
                char c = chars[i];
                if (c == 'A' || c == 'B') {
                    s = findPair(state, c, i, s);
                } else if (c == 'C' || c == 'D') {
                    s = findPair(state, c+1, i, s);
                } else if (c == '-') {
                    continue;
                }
                if (s == 2) {
                    chars[state[1]] = '-';
                    chars[state[2]] = '-';
                    k += 2;
                }
            }
        } while (k != 0 && k < l -1);

        StringBuilder R = new StringBuilder();
        for (char c: chars) {
            if (c != '-') {
                R.append(c);
            }
        }
        return R.toString();
    }

    private static int findPair(int[] b, int c, int i, int s) {
        if (s == 0) {
            b[0] = c;
            b[1] = i;
            return  1;
        } else if (Math.abs(c - b[0]) == 1) {
            b[2] = i;
            return  2;
        } else {
            b[0] = c;
            b[1] = i;
        }
        return 1;
    }
}
