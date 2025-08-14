class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int validCharCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                validCharCount++;
            }
        }

        if (validCharCount == 0) return "";

        char[] chars = new char[validCharCount];
        int validCharIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-') {
                chars[validCharIdx++] = Character.toUpperCase(c);
            }
        }

        int groupCount = (validCharCount + k - 1) / k;
        int resultSize = validCharCount + groupCount - 1;
        char[] result = new char[resultSize];
        int resultIdx = resultSize - 1;
        int charIdx = validCharCount - 1;
        int currentGroupSize = 0;

        while (charIdx >= 0) {
            result[resultIdx--] = chars[charIdx--];
            currentGroupSize++;

            if (currentGroupSize == k && charIdx >= 0) {
                result[resultIdx--] = '-';
                currentGroupSize = 0;
            }
        }

        return new String(result);
    }
}