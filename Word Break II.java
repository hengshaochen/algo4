class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, dict, map);
    }
    
    List<String> dfs(String s, Set<String> dict, Map<String, List<String>> map) {
        // base case
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> curRes = new ArrayList<>();
        
        if (dict.contains(s)) {
            System.out.println(s);
            curRes.add(s);
            map.put(s, new ArrayList<>(curRes));
            // return map.get(s);  不能直接return, pineapple已經在字典裡，不能直接return, 因為可以再切成pine和apple
        }
        
        // 展開recursive
        for (int i = 1; i < s.length(); i++) {
            // 如果右邊子串不在dict中, 不可能組成
            String right = s.substring(i, s.length());
            if (!dict.contains(right)) {
                continue;
            }
            
            // 右邊在dict, 左邊遞歸求子問題，看看能不能組成
            String left = s.substring(0, i);
            List<String> leftRes = dfs(left, dict, map);
            
            // leftRes 和 right組合起來放入curRes
            // for(String ss : ll) words.add(temp + (ss.equals("") ? "" : " ") + ss);
            for (String curLeft : leftRes) {
                curRes.add(curLeft + " " + right);
            }
        }
        
        map.put(s, new ArrayList<>(curRes));
        return map.get(s);
    }
}