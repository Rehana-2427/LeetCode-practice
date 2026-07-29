class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Frequency map of p
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            if (map.containsKey(rightChar)) {
                if (map.get(rightChar) > 0) {
                    count--;
                }
                map.put(rightChar, map.get(rightChar) - 1);
            }

            right++;

            if (count == 0) {
                result.add(left);
            }

            // Maintain fixed window
            if (right - left == p.length()) {

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) >= 0) {
                        count++;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }

                left++;
            }
        }

        return result;
    }
}