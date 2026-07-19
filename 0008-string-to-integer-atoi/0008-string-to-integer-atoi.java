class Solution {
    public int myAtoi(String s) {
        //whitespace ignore
        s=s.trim();
        //if s is empty return 0
        if(s.isEmpty()){
            return 0;
        }
        //signedness(if no sign is there then +ve sign)
        int i=0;
        int sign=1;
        if(s.charAt(i)=='-' || s.charAt(i) == '+'){
            sign = (s.charAt(i)=='-')?-1:1;
            i++;
        }
        //conversion
        long num = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            num=(num*10)+(s.charAt(i) - '0');
            //rounding
            if(num*sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(num*sign <Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign*num);
    }
}