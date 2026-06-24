class Solution {
    public boolean isPowerOfTwo(int n) {
         if (n <= 0) {
            return false;
        }
        if(n==1){
            return true;
        }
        for(int i=1;i<=30;i++){
            if(n==Math.pow(2,i)){
                return true;
            }
        }
        return false;
    }
}