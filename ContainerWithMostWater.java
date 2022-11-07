class Solution {
    public int maxArea(int[] height) {
//         int max = 0;
        
//         for (int i = 0; i < height.length; i++) {
//             for (int j = i + 1; j < height.length; j++) {
//                 int mul = Math.min(height[i], height[j]) * (j - i);
                
//                 if (mul > max) {
//                     max = mul;
//                 }
//             }
//         }
      
//       return max;
        
        return altMaxArea(height);
    }
    
    public int altMaxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int max = 0;
        
        while (left < right) {
            int mul = Math.min(height[left], height[right]) * (right - left);
            
            if (mul > max) {
                max = mul;
            }
            
            if (height[left] > height[right]) {
                right--;
                
            } else {
                left++;
            }
        }
        
        return max;
    }
}
