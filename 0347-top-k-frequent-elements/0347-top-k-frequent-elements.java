class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (int el : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(el);
            List<Integer> els = buckets.getOrDefault(frequency, new ArrayList<>());
            els.add(el);
            buckets.put(frequency, els);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int frequency = nums.length; frequency >= 0 && idx < k; frequency--) {
            if (buckets.get(frequency) != null) {
                for (int el : buckets.get(frequency)) {
                    result[idx] = el;
                    idx++;
                }
            }
        }

        return result;
    }
}