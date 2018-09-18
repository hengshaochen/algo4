class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, dict, map);
    }
    
    boolean dfs(String s, Set<String> dict, Map<String, Boolean> map) {
        // base case
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (dict.contains(s)) {
            map.put(s, true);
            return true;
        }
        
        // recursive
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            
            boolean leftSubProblem = dfs(left, dict, map);
            if (leftSubProblem && dict.contains(right)) {
                map.put(s, true);
                return true;
            }
        }
        
        map.put(s, false);
        return false;
    }
}