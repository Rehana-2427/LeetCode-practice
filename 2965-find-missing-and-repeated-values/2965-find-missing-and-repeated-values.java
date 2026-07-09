class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;

        // ---------------- Frequency Array Approach ----------------

        // int total = n * n;
        // int[] freq = new int[total + 1];

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         freq[grid[i][j]]++;
        //     }
        // }

        // int repeated = 0;
        // int missing = 0;

        // for (int i = 1; i <= total; i++) {
        //     if (freq[i] == 2)
        //         repeated = i;
        //     else if (freq[i] == 0)
        //         missing = i;
        // }

        // return new int[]{repeated, missing};

        // ---------------- Math Formula Approach ----------------

        int total = n * n;

        long expectedSum = (long) total * (total + 1) / 2;
        long expectedSquareSum = (long) total * (total + 1) * (2L * total + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = grid[i][j];

                actualSum += value;
                actualSquareSum += (long) value * value;
            }
        }

        // x = repeated
        // y = missing

        // x - y
        long diff = actualSum - expectedSum;

        // x² - y²
        long squareDiff = actualSquareSum - expectedSquareSum;

        // (x²-y²)/(x-y) = x+y
        long sum = squareDiff / diff;

        // x = ((x+y)+(x-y))/2
        int repeated = (int) ((sum + diff) / 2);

        // y = x-(x-y)
        int missing = (int) (repeated - diff);

        return new int[]{repeated, missing};
    }
}