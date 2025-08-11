class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
                int left = i;
                int right = Math.min(i + k - 1, chars.length - 1);

                while (left < right) {
                    char tmp = chars[left];
                    chars[left++] = chars[right];
                    chars[right--] = tmp;
                }
        }

        return new String(chars);
    }
}