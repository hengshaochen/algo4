class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cur : cpdomains) {
            String[] s = cur.split(" ");
            int count = Integer.valueOf(s[0]);
            String[] ss = s[1].split("\\.");  // escape
            
            String sub = new String();
            for (int i = ss.length - 1; i >= 0; i--) {
                sub = ss[i] + (sub.equals("") ? "" : "." + sub);  // 如果當前sub是最尾巴，不用.
                if (!map.containsKey(sub)) {
                    map.put(sub, count);
                } else {
                    map.put(sub, map.get(sub) + count);
                }
            }
        }
        
        // output
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }
        return ans;
    }
}