class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for (String s: strs) {
            char[] sa = s.toCharArray();
            Arrays.sort(sa);
            String ssorted = new String(sa);
            
            if (map.containsKey(ssorted)) {
                map.get(ssorted).add(s);
            } else {
                List<String> list = new ArrayList();
                list.add(s);
                
                map.put(ssorted, list);
            }
        }
        
        return new ArrayList(map.values());
    }
}
