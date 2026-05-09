class Solution {
    int[] prefixSum;
    Random random = new Random();

    public Solution(int[] w) {
        int[] arr = new int[w.length];
        int cur = 0;
        
        for (int i = 0; i < w.length; i++) {
            cur += w[i];
            arr[i] = cur;
        }

        prefixSum = arr;
    }
    
    public int pickIndex() {
        int picked = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int left = 0;
        int right = prefixSum.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (picked > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */