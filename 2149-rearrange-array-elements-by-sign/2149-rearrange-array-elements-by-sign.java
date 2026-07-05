class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positivieNum = 0;
        int negativeNum = 1;
        int[] arr = new int[nums.length];
        for(int num : nums){
            if(num>0){
                arr[positivieNum] = num;
                positivieNum+=2;
            }
            else if(num<0){
                arr[negativeNum] = num;
                negativeNum+=2;
            }
        }

        return arr;
    }
}