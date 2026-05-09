class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curSum = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            
            if (map.containsKey(curSum - k)) {
                cnt += map.get(curSum - k);
            }

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return cnt;
    }
}