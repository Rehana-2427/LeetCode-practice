class Solution {

    static final int MOD = 1_000_000_007;
    static final int MAX = 100001;

    static long[] powerOf10 = new long[MAX];

    // Precompute powers of 10 modulo MOD
    static {
        powerOf10[0] = 1;

        for (int i = 1; i < MAX; i++) {
            powerOf10[i] = (powerOf10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Prefix sum of all digits
        int[] prefixDigitSum = new int[n + 1];

        // Prefix count of non-zero digits
        int[] prefixNonZeroCount = new int[n + 1];

        // Prefix number formed after removing zeros
        long[] prefixNumber = new long[n + 1];

        // Build prefix arrays
        for (int i = 1; i <= n; i++) {

            int digit = s.charAt(i - 1) - '0';

            prefixDigitSum[i] = prefixDigitSum[i - 1] + digit;

            prefixNonZeroCount[i] =
                    prefixNonZeroCount[i - 1] + (digit != 0 ? 1 : 0);

            if (digit != 0) {
                prefixNumber[i] =
                        (prefixNumber[i - 1] * 10 + digit) % MOD;
            } else {
                prefixNumber[i] = prefixNumber[i - 1];
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            // Number of non-zero digits in the query
            int nonZeroDigits =
                    prefixNonZeroCount[right + 1] - prefixNonZeroCount[left];

            // Sum of digits in the query
            int digitSum =
                    prefixDigitSum[right + 1] - prefixDigitSum[left];

            // Number after removing zeros
            long number =
                    (prefixNumber[right + 1]
                    - (prefixNumber[left] * powerOf10[nonZeroDigits]) % MOD
                    + MOD) % MOD;

            answer[i] = (int) ((number * digitSum) % MOD);
        }

        return answer;
    }
}