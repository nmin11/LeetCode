class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxCount = 0;
        for (int f : freq) {
            maxCount = Math.max(maxCount, f);
        }

        int maxCountTask = 0;
        for (int f : freq) {
            if (f == maxCount) {
                maxCountTask++;
            }
        }

        int frameTime = (maxCount - 1) * (n + 1) + maxCountTask;

        return Math.max(frameTime, tasks.length);
    }
}