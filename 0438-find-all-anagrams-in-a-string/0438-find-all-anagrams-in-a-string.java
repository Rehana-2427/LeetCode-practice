class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int left = 0;
        int right = 0;
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(right<s.length()){
            char  rightChar = s.charAt(right);
            if(map.containsKey(rightChar)){
                if(map.get(rightChar)>0){
                    count--;
                }
                map.put(rightChar,map.get(rightChar)-1);
            }
            right++;

            if(count==0){
                result.add(left);
            }

            if(right-left==p.length()){
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)>=0){
                        count++;
                    }
                    map.put(leftChar,map.get(leftChar)+1);
                }
                left++;
            }

        }
        return result;
    }
}