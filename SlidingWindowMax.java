class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        
        int[] solution = new int[nums.length - k + 1];
        Deque<Integer> deq = new ArrayDeque();
        
        int solutionIdx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!deq.isEmpty() && deq.peek() < i - k + 1) {
                deq.poll();
            }
            
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }
            
            deq.offer(i);
            if (i >= k - 1) {
                solution[solutionIdx] = nums[deq.peek()];
                solutionIdx++;
            }
        }
        
        return solution;
    }
}
