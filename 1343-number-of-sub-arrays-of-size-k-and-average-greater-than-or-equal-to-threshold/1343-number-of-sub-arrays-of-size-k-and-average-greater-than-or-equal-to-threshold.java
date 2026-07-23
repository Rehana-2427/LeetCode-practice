class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while(right<nums.length){
            sum+=nums[right];
            int windowsize = right - left + 1;
            if(windowsize < k){
                right++;
            }
            else if(windowsize == k){
                
                if(sum/k >= threshold){
                    count++;
                }
                sum-=nums[left];
                left++;
                right++;

            }
        
        }
     

        return count;

    }
}