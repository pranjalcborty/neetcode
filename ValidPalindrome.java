class Solution {
    public boolean isPalindrome(String s) {        
        int top = 0;
        int bottom = s.length() - 1;
        
        while (top <= bottom) {
            char satop = Character.toLowerCase(s.charAt(top));
            char sabottom = Character.toLowerCase(s.charAt(bottom));
            
            if (isAlphanumeric(satop) && isAlphanumeric(sabottom)) {
                if (satop != sabottom) {
                    return false;
                }
            }
            
            if (!isAlphanumeric(satop) && isAlphanumeric(sabottom)) {
                bottom++;
            }
            
            if (!isAlphanumeric(sabottom) && isAlphanumeric(satop)) {
                top--;
            }
            
            top++;
            bottom--;
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        
        return false;
    }
}
