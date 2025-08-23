class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char tChar = t.charAt(i);
            if (!sMap.containsKey(tChar)) return false;
            int sCnt = sMap.get(tChar);
            if (sCnt == 0) return false;
            sMap.put(tChar, sCnt - 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }
}