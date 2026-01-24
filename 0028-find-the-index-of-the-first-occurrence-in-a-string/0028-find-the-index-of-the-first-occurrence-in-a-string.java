class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) return -1;

        for (int i = 0; i <= hLen - nLen; i++) {
            boolean hasFound = true;

            for (int j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    hasFound = false;
                    break;
                }
            }

            if (hasFound) return i;
        }

        return -1;
    }
}