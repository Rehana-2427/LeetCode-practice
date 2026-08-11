class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int right = 0;
        int tCount = 0;
        int fCount = 0;
        int maxLength = 0;
        while (right < answerKey.length()) {
             if (answerKey.charAt(right) == 'T') {
                tCount++;
            } 
            else {
                fCount++;
            }
             while (tCount > k && fCount > k) {

                if (answerKey.charAt(left) == 'T') {
                    tCount--;
                } else {
                    fCount--;
                }

                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
            right++;

        }
        return maxLength;

    }
}