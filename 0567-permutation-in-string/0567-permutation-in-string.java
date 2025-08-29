class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < s1Len; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, windowCount)) return true;

        for (int i = s1Len; i < s2Len; i++) {
            windowCount[s2.charAt(i) - 'a']++;
            windowCount[s2.charAt(i - s1Len) - 'a']--;

            if (Arrays.equals(s1Count, windowCount)) return true;
        }

        return false;
    }
}