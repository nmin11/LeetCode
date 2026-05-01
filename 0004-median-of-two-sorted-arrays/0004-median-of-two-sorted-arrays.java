class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int left = 0;
        int right = nums1.length;
        int m = nums1.length;
        int n = nums2.length;
        int maxLeft1 = Integer.MIN_VALUE;
        int minRight1 = Integer.MAX_VALUE;
        int maxLeft2 = Integer.MIN_VALUE;
        int minRight2 = Integer.MAX_VALUE;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            maxLeft1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            minRight1 = i == m ? Integer.MAX_VALUE : nums1[i];
            maxLeft2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            minRight2 = j == n ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                break;
            } else if (maxLeft1 > minRight2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        if ((m + n) % 2 == 1) {
            return Math.max(maxLeft1, maxLeft2);
        } else {
            return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
        }
    }
}