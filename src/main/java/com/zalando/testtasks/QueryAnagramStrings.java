package com.zalando.testtasks;

public class QueryAnagramStrings {

    public static int[] solution(String[] strings, String[] queries) {

        if (strings == null || strings.length == 0) {
            return new int[]{};
        }

        if (queries == null || queries.length == 0) {
            return new int[]{};
        }

        int[] output = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long qlh = getLongHash(queries[i]);
            for (String s : strings) {
                if (queries[i].length() != s.length()) {
                    continue;
                }

                long slh = getLongHash(s);
                if ((qlh - slh) == 0) {
                    output[i]++;
                }
            }
        }
        return output;
    }

    private static long getLongHash(String s) {
        long lh = 0L;
        for (char c: s.toCharArray()) {
            lh |= 1L << (c % 64);
        }
        return lh;
    }
}
