class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> map = new HashMap();
        
//         for (int i = 0; i < nums.length; i++) {
//             int firstNum = nums[i];
//             int firstIdx = i;
            
//             for (int j = i + 1; j < nums.length; j++) {
//                 if ((target - nums[i]) == nums[j]) {
//                     solution[0] = i;
//                     solution[1] = j;
//                     return solution;
//                 }
//             }
//         }
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                solution[0] = map.get(target - nums[i]);
                solution[1] = i;
                
                return solution;
            }
            
            map.put(nums[i], i);
        }
        
        return solution;
    }
}
