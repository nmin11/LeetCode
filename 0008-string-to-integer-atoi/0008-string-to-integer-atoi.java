class Solution {
    public int myAtoi(String s) {
        int result = 0;

        if (s.isEmpty()) return result;

        int idx = 0;
        int len = s.length();
        boolean isNegative = false;

        while (idx < len && s.charAt(idx) == ' ') {
            idx++;
        }
        
        if (idx == len) return result;

        if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
            isNegative = (s.charAt(idx) == '-') ? true : false;
            idx++;
        }

        while (idx < len && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            idx++;
        }

        return (isNegative) ? -result : result;
    }
}