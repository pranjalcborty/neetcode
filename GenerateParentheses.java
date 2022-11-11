class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList();
        
        dfs(0, 0, "", n, solution);
        
        return solution;
    }
    
    public void dfs(int left, int right, String s, 
                    int n, List<String> solution) {
        
        if (s.length() == n * 2) {
            solution.add(s);
            return;
        }
        
        if (left < n) {
            dfs(left + 1, right, s + "(", n, solution);
        }
        
        if (right < left) {
            dfs(left, right + 1, s + ")", n, solution);
        }
    }
}
