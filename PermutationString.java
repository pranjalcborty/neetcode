class Solution {
    public boolean checkInclusion(String s1, String s2) {
//         int[] count = new int[26];
//         for (int i = 0; i < s1.length(); i++) {
//             char thisChar = s1.charAt(i);
//             count[thisChar - 'a']++;
//         }
        
//         int left = 0;
//         int right = 0;
//         int len = s1.length();
//         while (right < s2.length()) {
//             char rightChar = s2.charAt(right);
//             if (count[rightChar - 'a'] >= 1) {
//                 len--;
//             }
            
//             right++;
//             count[rightChar - 'a']--;
            
//             if (len == 0) {
//                 return true;
//             }
            
//             char leftChar = s2.charAt(left);
//             if (right - left == s1.length()) {
//                 if (count[leftChar - 'a'] >= 0) {
//                     len++;
//                 }
                
//                 left++;
//                 count[leftChar - 'a']++;
//             }
//         }
      
//       return false;
        
        return altSol(s1, s2);
    }
    
    public boolean altSol(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {            
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            matches += s1Count[i] == s2Count[i] ? 1 : 0;
        }
        
        int left = 0;
        int right = s1.length();
        
        while (right < s2.length()) {
            if (matches == 26) {
                return true;
            }
            
            char rightChar = s2.charAt(right);
            s2Count[rightChar - 'a']++;
            
            if (s2Count[rightChar - 'a'] == s1Count[rightChar - 'a']) {
                matches++;
            } else if (s2Count[rightChar - 'a'] == (s1Count[rightChar - 'a'] + 1)) {
                matches--;
            }
            
            char leftChar = s2.charAt(left);
            s2Count[leftChar - 'a']--;
            
            if (s2Count[leftChar - 'a'] == s1Count[leftChar - 'a']) {
                matches++;
            } else if (s2Count[leftChar - 'a'] == (s1Count[leftChar - 'a'] - 1)) {
                matches--;
            }
            
            right++;
            left++;
        }
        
        return matches == 26;
    }
}
