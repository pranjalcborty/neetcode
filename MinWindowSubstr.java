// Guys, when dealing with Integer (not the primitive), don't forget to use <integerObj>.intValue() (or .equals if comparing).
// https://stackoverflow.com/questions/10002037/comparing-integer-values-in-java-strange-behavior/10002066#10002066

class Solution {
    public String minWindow(String s, String t) {
        if (s.equals(t) || t.isEmpty()) {
            return t;
        }
        
        if (s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> countT = new HashMap();
        Map<Character, Integer> countS = new HashMap();
        
        for (int i = 0; i < t.length(); i++) {
            countT.merge(t.charAt(i), 1, Integer::sum);
        }
        
        int left = 0;
        int right = 0;
        
        int minLength = s.length() + 1;
        int minLeft = s.length();
        
        int matches = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            
            countS.merge(c, 1, Integer::sum);
            
            if (countT.containsKey(c) && countS.get(c).intValue() == countT.get(c).intValue()) {
                matches++;
            }
            
            while (matches == countT.size() && left <= right) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minLeft = left;
                }
                
                char leftMostChar = s.charAt(left);
                countS.put(leftMostChar, countS.get(leftMostChar) - 1);
                
                if (countT.containsKey(leftMostChar) 
                    && countS.get(leftMostChar).intValue() < countT.get(leftMostChar).intValue()) {
                    
                    matches--;
                }

                left++;
            }
            
            right++;
        }
        
        return minLength == (s.length() + 1) 
            ? "" 
            : s.substring(minLeft, minLeft + minLength);
    }
}
