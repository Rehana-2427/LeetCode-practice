class Solution {
    public int maxVowels(String s, int k) {
        int left=0;
        int right =0;
        int count =0;
        int maxCount = Integer.MIN_VALUE;
        while(right<s.length()){
            char rightChar = s.charAt(right);
            if(isVowel(rightChar)){
                count++;
            }
            int windowsize = right-left+1;
            if(windowsize==k){
                maxCount = Math.max(count,maxCount);
                char leftChar = s.charAt(left);
                if(isVowel(leftChar)){
                    count--;
                }
                left++;
            }
            right++; 
        }
       

        return maxCount;
    }
     public boolean isVowel(char ch){
            return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
        }
}