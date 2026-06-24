class Solution {
    public boolean isPowerOfTwo(int n) {
         if (n <= 0) {
            return false;
        }
        if(n==1){
            return true;
        }
         // Optimized Loop: Instead of looping up to 'n' (which causes timeouts),
        // we only loop up to 30 because 2^31 overflows a standard Java int.
        for(int i=1;i<=30;i++){
            if(n==Math.pow(2,i)){
                return true;
            }
        }
        return false;
    }
}
