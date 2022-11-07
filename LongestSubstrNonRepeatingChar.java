class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        char[] c = s.toCharArray();
        
        int max = 0;
        
        int left = 0;
        for (int right = 0; right < c.length; right++) {
            char thisChar = c[right];
            while (set.contains(thisChar)) {
                set.remove(c[left]);
                left++;
            }
            
            set.add(thisChar);
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
