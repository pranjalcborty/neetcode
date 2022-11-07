class Solution {
    public boolean isValidSudoku(char[][] board) {
//         Map<String, Map<Character, Integer>> map = new HashMap();
        
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 char currentChar = board[i][j];
                
//                 if (currentChar == '.') {
//                     continue;
//                 }
                
//                 String columnId = "column" + j;
//                 String rowId = "row" + i;
//                 String squareId = String.format("square%d-%d", (i / 3), (j / 3));
                
//                 if (map.containsKey(columnId)) {                    
//                     if (map.get(columnId).containsKey(currentChar)) {
//                         return false;
//                     } else {
//                         map.get(columnId).put(currentChar, 1);
//                     }
//                 } else {
//                     Map<Character, Integer> subMap = new HashMap();
//                     subMap.put(currentChar, 1);
                    
//                     map.put(columnId, subMap);
//                 }
                
//                 if (map.containsKey(rowId)) {                    
//                     if (map.get(rowId).containsKey(currentChar)) {
//                         return false;
//                     } else {
//                         map.get(rowId).put(currentChar, 1);
//                     }
//                 } else {
//                     Map<Character, Integer> subMap = new HashMap();
//                     subMap.put(currentChar, 1);
                    
//                     map.put(rowId, subMap);
//                 }
                
//                 if (map.containsKey(squareId)) {
//                     Map<Character, Integer> subMap = map.get(squareId);
                    
//                     if (map.get(squareId).containsKey(currentChar)) {
//                         return false;
//                     } else {
//                         map.get(squareId).put(currentChar, 1);
//                     }
//                 } else {
//                     Map<Character, Integer> subMap = new HashMap();
//                     subMap.put(currentChar, 1);
                    
//                     map.put(squareId, subMap);
//                 }
//             }
//         }
      
//       return true;
        
        return solutionWithSet(board);
    }
    
    public boolean solutionWithSet(char[][] board) {
        Set<String> solution = new HashSet();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (!solution.add("row - " + i + " val " + board[i][j]) ||
                    !solution.add("col - " + j + " val " + board[i][j]) ||
                    !solution.add("sq - " + (i / 3) + "," + (j / 3) + " val " + board[i][j])) {
                    
                    return false;
                }
            }
        }
        
        return true;
    }
}
