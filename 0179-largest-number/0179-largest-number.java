class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        if (n == 1 && nums[0] == 0) return "0";

        String[] numsStr = new String[n];

        for (int i = 0; i < n; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : numsStr) sb.append(s);

        String result = sb.toString();

        return result.charAt(0) == '0' ? "0" : result;
    }
}