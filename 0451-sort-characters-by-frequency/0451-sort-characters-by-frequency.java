class Solution {
    public String frequencySort(String s) {
        //use hashmap to store character and frequency count integer
        HashMap<Character,Integer> map = new HashMap<>();
        //frequncy count of a character by traversing whole string 
        for(char ch : s.toCharArray()){
            //key - value ==> character - frequency count
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        //to sort the characters use list bcz hasmap wont do sort
        ArrayList<Character> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list,(a,b)-> map.get(b)-map.get(a));
        //AFTER SOrting use string builder to print the list
        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            int freq = map.get(ch);
            while(freq>0){
                sb.append(ch);
                freq--;
            }
        }
        return sb.toString();
    }
}