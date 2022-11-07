class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int maxLen = 0;
        
        for (int i: nums) {
            set.add(i);
        }
        
        for (int i: nums) {            
            if (!set.contains(i - 1)) {
                int length = 1;
                
                i++;
                while (set.contains(i)) {
                    length++;
                    i++;
                }
                
                maxLen = length > maxLen ? length : maxLen;
            }
            
        }
        
        return maxLen;
    }
}
