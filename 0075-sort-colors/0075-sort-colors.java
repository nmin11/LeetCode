class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == 0) {
                int tmp = nums[red];
                nums[red++] = nums[white];
                nums[white++] = tmp;
            } else if (nums[white] == 1) {
                white++;
            } else {
                int tmp = nums[white];
                nums[white] = nums[blue];
                nums[blue--] = tmp;
            }
        }
    }
}