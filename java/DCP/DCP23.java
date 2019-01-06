/*
This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
*/

// "static void main" must be defined in a public class.
// "static void main" must be defined in a public class.
class Point{
    int x;
    int y;
    int dist;
    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class Main {
   /* public static int findMinDist(int[][]M, Point s, Point e, int pathLength) {
        if (s.x == e.x && s.y == e.y) return pathLength;
        if (s.x < 0 || s.x >= M.length || s.y < 0 || s.y >= M[0].length || M[s.x][s.y] == 0) return Integer.MAX_VALUE;
        
        Point[] points = new Point[]{new Point(-1,0), new Point(0, 1), new Point(1,0), new Point(0,-1)}; 
        int minDist = Integer.MAX_VALUE;
        M[s.x][s.y] = 0;
        for (Point p: points) {
            //System.out.println("X : " + (s.x + p.x) + "  Y: " + (s.y + p.y));
            Point newP = new Point(s.x + p.x, s.y + p.y);
            
            int dist = findMinDist(M,newP, e, pathLength + 1);
            minDist = Math.min(minDist, dist);
        }
        M[s.x][s.y] = 1;
        return minDist;
    }*/
    
    public static int findMinDistLee(int[][]M, Point s, Point e) {
        int m = M.length, n = M[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Queue<Point> q = new LinkedList<>();
        visited[s.x][s.y] = true;
        q.add(s);
        int row[] = { -1, 0, 0, 1 };
	    int col[] = { 0, -1, 1, 0 };
        int minDist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            // Pop t fron the top of the queue
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            
            if (x == e.x && y == e.y) {
                minDist = p.dist;
            }
            
            // Check all the four possible directions
            
            for (int k = 0; k < 4; k++) {
                if (isValid(M, visited, x + row[k], y + col[k] )) {
                    visited[x + row[k]][y + col[k]] = true;
                    q.add(new Point( x + row[k], y + col[k], dist + 1));
                }
            }
        }
        
        return minDist;
        
    }
    
    public static boolean isValid(int[][] M,boolean[][] V, int i, int j) {
        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length || V[i][j] || M[i][j] == 0) return false;
        return true;
    }
    public static void main(String[] args) {
         int[][] mat =new int[][] { 
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
    }; 
        
        Point source = new Point(0,0, 0); 
        Point dest = new Point(3,4, Integer.MAX_VALUE);
        System.out.println(findMinDistLee(mat, source, dest));
    }
}