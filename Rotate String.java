// 法1: shift所有可能性
class Solution {
    public boolean rotateString(String A, String B) {
        // corner case: 當A="" B=""
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        
        for (int i = 0; i < A.length(); i++) {
            String shiftA = A.substring(i, A.length()) + A.substring(0, i);
            if (shiftA.compareTo(B) == 0) {
                return true;
            }
        }
        return false;
    }
}

// 法2: 把一個字串複製兩次, 就包含所有shift的可能性
class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}