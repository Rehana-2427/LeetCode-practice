class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a = 1;
        int b = 2;
        int count = 3;
        while(count<=n){
            int t = b;
            b= a+b;
            a=t;
            count++;
        }
        return b;
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(n));
    }
}