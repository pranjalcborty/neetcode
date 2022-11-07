class Solution {
    public int trap(int[] height) {
//         int[] maxLeft = new int[height.length];
//         int[] maxRight = new int[height.length];
        
//         int max = 0;
//         for (int i = 1; i < maxLeft.length; i++) {
//             if (height[i - 1] > max) {
//                 max = height[i - 1];
//             }
            
//             maxLeft[i] = max;
//         }
        
//         max = 0;
//         for (int i = maxLeft.length - 2; i >= 0; i--) {
//             if (height[i + 1] > max) {
//                 max = height[i + 1];
//             }
            
//             maxRight[i] = max;
//         }
        
//         int total = 0;
//         for (int i = 1; i < height.length - 1; i++) {
//             int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            
//             if (count > 0) {
//                 total += count;
//             }
//         }
      
//       return total;
        
        return altTrap(height);
    }
    
    public int altTrap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int maxLeft = 0;
        int maxRight = 0;
        
        int count = 0;
        
        while (left <= right) {
            if (maxLeft < maxRight) {
                int capacity = maxLeft - height[left];
                
                if (capacity > 0) {
                    count += capacity;
                } else {
                    maxLeft = height[left];
                }
                
                left++;
            } else {
                int capacity = maxRight - height[right];
                
                if (capacity > 0) {
                    count += capacity;
                } else {
                    maxRight = height[right];
                }
                
                right--;
            }
        }
            
        return count;
    }
}
