class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        
        int max = 0;
        int maxFreq = 0;
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char thisChar = s.charAt(right);
            
            if (map.containsKey(thisChar)) {
                map.put(thisChar, map.get(thisChar) + 1);
            } else {
                map.put(thisChar, 1);
            }
            
            int windowSize = right - left + 1;
            maxFreq = Math.max(maxFreq, map.get(thisChar));
            
            if ((windowSize - maxFreq) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            
            int updatedWindowSize = right - left + 1;
            if (updatedWindowSize > max) {
                max = updatedWindowSize;
            }
        }
        
        return max;
    }
}
