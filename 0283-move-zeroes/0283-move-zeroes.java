import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int first=0;
        int last=nums.length;
        for(int i=0;i<last;i++){
            if(nums[i]!=0){
                nums[first]=nums[i];
                first++;
            }
        }
        while(first<last){
            nums[first]=0;
            first++;
        }
        System.out.println(Arrays.toString(nums));
    }
}