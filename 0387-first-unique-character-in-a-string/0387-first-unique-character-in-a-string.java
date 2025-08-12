import java.util.Map;
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}