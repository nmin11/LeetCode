class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (pairIdx.containsKey(complement)) {
                return new int[] { i, pairIdx.get(complement) };
            }
            pairIdx.put(nums[i], i);
        }

        return new int[] {};
    }
}