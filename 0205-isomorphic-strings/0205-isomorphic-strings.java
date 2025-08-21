class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> isomorphicMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (isomorphicMap.containsKey(sChar)) {
                if (isomorphicMap.get(sChar) != tChar) {
                    return false;
                }
            } else if (isomorphicMap.containsValue(tChar)) {
                return false;
            } else {
                isomorphicMap.put(sChar, tChar);
            }
        }

        return true;
    }
}