class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;

        boolean[] isPangram = new boolean[26];
        int cnt = 0;

        for (char c : sentence.toCharArray()) {
            int idx = c - 'a';
            if (!isPangram[idx]) {
                isPangram[idx] = true;
                cnt++;
                if (cnt == 26) return true;
            }
        }

        return false;
    }
}