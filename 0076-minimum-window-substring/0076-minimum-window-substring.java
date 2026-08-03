class Solution {
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map of characters required from t
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        // Current window frequency map
        HashMap<Character, Integer> windowMap = new HashMap<>();

        int required = tMap.size(); // Number of unique characters in t
        int formed = 0;             // Number of characters meeting required frequency

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {

            // Expand window
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // If this character's frequency now matches the required frequency
            if (tMap.containsKey(ch) &&
                windowMap.get(ch).intValue() == tMap.get(ch).intValue()) {

                formed++;
            }

            // Shrink window while it is valid
            while (left <= right && formed == required) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // Window is no longer valid
                if (tMap.containsKey(leftChar) &&
                    windowMap.get(leftChar) < tMap.get(leftChar)) {

                    formed--;
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}