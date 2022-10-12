class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid.length == 0) return 0;
        
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ArrayList<Integer> rowCol = new ArrayList<>();
                rowCol.add(i);
                rowCol.add(j);
                if (grid[i][j] == '1' && !visited.contains(rowCol)) {
                    breadthFirstSearch(visited, rowCol, grid);
                    islands++;
                    System.out.println(islands);
                }
            }
        }
        return islands;
        
    }
    
    private void breadthFirstSearch (HashSet<ArrayList<Integer>> visited, ArrayList<Integer> rowCol, char[][] grid) {
        Queue<ArrayList<Integer>> rcQueue = new LinkedList<>();
        
        visited.add(rowCol);
        rcQueue.offer(rowCol);
        
        while (!rcQueue.isEmpty()) {
            ArrayList<Integer> poppedRowCol = rcQueue.remove();
            int row = poppedRowCol.get(0);
            int col = poppedRowCol.get(1);
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            
            for (int[] direction : directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                ArrayList<Integer> newRowCol = new ArrayList<>();
                newRowCol.add(r);
                newRowCol.add(c);
                if ((r < grid.length && r >= 0)
                    && (c < grid[0].length && c >= 0)
                    && grid[r][c] == '1'
                    && !visited.contains(newRowCol)) {
                        rcQueue.add(newRowCol);
                        visited.add(newRowCol);
                    }
            }
        }
    }
}