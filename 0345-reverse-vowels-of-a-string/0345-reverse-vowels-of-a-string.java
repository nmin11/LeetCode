class Solution {
    Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (vowelSet.contains(chars[left]) && vowelSet.contains(chars[right])) {
                swap(chars, left, right);
                left++;
                right--;
            } else if (vowelSet.contains(chars[left])) {
                right--;
            } else if (vowelSet.contains(chars[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}