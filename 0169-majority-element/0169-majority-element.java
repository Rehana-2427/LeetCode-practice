class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int majorityElement = 0;
        for(int number : nums){
            if(count == 0){
                majorityElement = number;
            }
            if(majorityElement == number){
                count++;
            }
            else{
                count--;
            }
        }
        return majorityElement;
    }
}