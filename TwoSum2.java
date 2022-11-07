class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                solution[0] = map.get(numbers[i]) + 1;
                solution[1] = i + 1;
                
                return solution;
            }
            
            map.put(target - numbers[i], i);
        }
        
        return solution;
    }
}
