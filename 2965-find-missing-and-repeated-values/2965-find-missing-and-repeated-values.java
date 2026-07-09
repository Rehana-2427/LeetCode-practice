class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // int[] flatArray = java.util.Arrays.stream(grid)
        //                 .flatMapToInt(java.util.Arrays::stream)
        //                 .toArray();
        // int n = flatArray.length;

        int n = grid.length;
        int total = n * n;

        int[] freq = new int[total + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

    
        int repeated = 0;
        int missed = 0;
        for(int i=1;i<=total;i++){
            if(freq[i]==0){
                missed = i;
            }
            else if(freq[i] == 2){
                repeated = i;
            }
        }
        int[] result = new int[2];
        for(int i=0;i<2;i++){
            result[0]=repeated;
            result[1] = missed;
        }
        return result;

    }
}