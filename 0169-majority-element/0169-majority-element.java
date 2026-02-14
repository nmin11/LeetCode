class Solution {
    public int majorityElement(int[] nums) {
        int cur = 0, cnt = 0;

        for (int num : nums) {
            if (cnt == 0) {
                cur = num;
                cnt++;
            } else if (cur == num) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return cur;
    }
}