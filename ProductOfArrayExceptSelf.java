class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodprev = new int[nums.length];
        prodprev[0] = nums[0];
        for (int i = 1; i < prodprev.length; i++) {
            prodprev[i] = nums[i] * prodprev[i-1];
        }
        
        int[] prodnext = new int[nums.length];
        prodnext[nums.length - 1] = nums[nums.length - 1];
        for (int i = prodnext.length - 2; i >= 0; i--) {
            prodnext[i] = nums[i] * prodnext[i+1];
        }
        
        int[] solution = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prev = i == 0 ? 1 : prodprev[i - 1];
            int next = i == nums.length - 1 ? 1 : prodnext[i + 1];
            
            solution[i] = prev * next;
        }
        
        // return alternateSolution(nums);
        return solution;
    }
    
    public int[] alternateSolution(int[] nums) {
        int[] solution = new int[nums.length];
        solution[0] = 1;
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            solution[i] = prefix;
            prefix = nums[i] * prefix;
        }
        
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            solution[i] = postfix * solution[i];
            postfix = nums[i] * postfix;
        }
        
        return solution;
    }
}
