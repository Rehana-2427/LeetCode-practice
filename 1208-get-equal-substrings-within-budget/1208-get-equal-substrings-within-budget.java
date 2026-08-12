class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;

        int totalCost = 0;
        int maxLength = 0;
        while (right < s.length()) {
         totalCost += Math.abs(s.charAt(right) - t.charAt(right));
         while (totalCost > maxCost) {
                totalCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength,right - left + 1);
            right++;
        }

        return maxLength;
    }
}