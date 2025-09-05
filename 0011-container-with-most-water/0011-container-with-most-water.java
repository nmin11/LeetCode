class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int curWater = 0;
        int mostWater = 0;

        while (left < right) {
            curWater = Math.min(height[left], height[right]) * (right - left);
            mostWater = Math.max(mostWater, curWater);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return mostWater;
    }
}