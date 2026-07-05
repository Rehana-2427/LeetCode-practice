class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 0, count2 = 0;
        int element1 = 0, element2 = 0;

        // First Pass: Find possible candidates
        for (int num : nums) {

            if (element1 == num) {
                count1++;
            }
            else if (element2 == num) {
                count2++;
            }
            else if (count1 == 0) {
                element1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                element2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Second Pass: Verify actual frequency
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == element1) {
                count1++;
            }
            else if (num == element2) {
                count2++;
            }
        }

        List<Integer> list = new ArrayList<>();

        if (count1 > nums.length / 3) {
            list.add(element1);
        }

        if (count2 > nums.length / 3) {
            list.add(element2);
        }

        return list;
    }
}