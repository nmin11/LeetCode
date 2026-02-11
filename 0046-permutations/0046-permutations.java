class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums, new boolean[nums.length]);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> cur, int[] nums, boolean[] used) {
        if (cur.size() == nums.length) {
            results.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            cur.add(nums[i]);
            used[i] = true;

            backtrack(results, cur, nums, used);

            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}