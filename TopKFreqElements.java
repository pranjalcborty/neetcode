class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        
        for (int i: nums) {
            countMap.put(i, countMap.containsKey(i) 
                         ? countMap.get(i) + 1 
                         : 1);
        }
        
        List<Map.Entry<Integer, Integer>> sortedEntryList = new ArrayList(countMap.entrySet());
        sortedEntryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        
        int[] solution = new int[k];
        for (int i = 0; i < k; i++) {
            solution[i] = sortedEntryList.get(i).getKey();
        }
        
        return solution;
    }
}
