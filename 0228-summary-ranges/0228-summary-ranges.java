class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> result = new ArrayList<>();

        while (end < nums.length) {
            while (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
                end++;
            }

            if (start == end) {
                result.add(String.valueOf(nums[start]));
            } else {
                result.add(nums[start] + "->" + nums[end]);
            }

            end++;
            start = end;
        }

        return result;
    }
}