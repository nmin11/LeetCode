class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tail = new ArrayList<>();

        for (int num : nums) {
            int pos = binarySearch(tail, num);

            if (pos == tail.size()) {
                tail.add(num);
            } else {
                tail.set(pos, num);
            }
        }

        return tail.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        int low = 0;
        int high = list.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == num) {
                return mid;
            } else if (list.get(mid) < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}