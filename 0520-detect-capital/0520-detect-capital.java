class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCnt = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) upperCnt++;
        }

        return upperCnt == 0 ||
               upperCnt == word.length() ||
               (upperCnt == 1 && Character.isUpperCase(word.charAt(0)));
    }
}