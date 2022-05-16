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
            long qbf = buildBloomFilter(queries[i]);
            for (String s : strings) {
                if (queries[i].length() != s.length()) {
                    continue;
                }

                long sbf = buildBloomFilter(s);
                if ((qbf - sbf) == 0) {
                    output[i]++;
                }
            }
        }
        return output;
    }

    private static long buildBloomFilter(String s) {
        long b = 0L;
        for (char c: s.toCharArray()) {
            b |= 1L << (c % 64);
        }
        return b;
    }
}
