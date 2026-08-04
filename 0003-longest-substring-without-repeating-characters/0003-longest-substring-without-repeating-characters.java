class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int right =0;
        int maxlength=0;
        HashMap<Character,Integer> map = new HashMap();
        while(right<n){
            char rightChar=s.charAt(right);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            while(map.get(rightChar)>1){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);
            right++;
            
        }
        return maxlength;
    }
}