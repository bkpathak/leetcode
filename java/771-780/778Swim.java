class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        }); 
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{grid[0][0], 0, 0}); 
        int max = grid[0][0];
        visited[0][0] = true;
        
        int[][] points = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            max = Math.max(max, curr[0]);
            if (curr[1] == n -1 && curr[2] == n-1 ) {
                    return max;
                }
            for (int[] p: points) {
                int x = curr[1] + p[0];
                int y = curr[2] + p[1];
                if (isValid(visited, x, y, n)) {
                    visited[x][y] = true;
                    q.add(new int[]{grid[x][y], x, y});
                }
            }
        }
        return max;
    }
    
    public boolean isValid(boolean[][] v, int x, int y, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n || v[x][y]) return false;
        return true;
    }
}