class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder revBuilder = new StringBuilder(s);
        String rev = revBuilder.reverse().toString();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // regionMatches(int toffset, String other, int ooffset, int len)
            if (rev.regionMatches(i, s, 0, len - i)) {
                return rev + s.substring(len - i);
            }
        }
        return "";
    }
}