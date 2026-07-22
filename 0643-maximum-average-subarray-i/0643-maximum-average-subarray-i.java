class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            int windowsize = right - left + 1;
            if(windowsize < k){
                right++;
            }
            else if(windowsize == k){
                maxSum = Math.max(maxSum, sum);
                sum-=nums[left];
                
                left++;
                right++;
            }
        }
        return (double)maxSum/k;
        
    }
}