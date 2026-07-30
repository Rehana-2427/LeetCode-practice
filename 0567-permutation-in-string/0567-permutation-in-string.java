class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int count = s1.length();
        if(s2.length()<s1.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(right<s2.length()){
            char rightChar = s2.charAt(right);
            if(map.containsKey(rightChar)){
                if(map.get(rightChar)>0){
                   count--;
                }
                 map.put(rightChar,map.get(rightChar)-1);
            }
            right++;
            if(count==0){
                return true;
            }
            if(right-left==s1.length()){
                char leftChar = s2.charAt(left);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)>=0){
                        count++;
                    }
                    map.put(leftChar,map.get(leftChar)+1);
                }
                left++;
            }
           
        }
         return false;
    }
}