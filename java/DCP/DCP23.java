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
class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int findMinDist(int[][]M, Point s, Point e, int pathLength) {
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
        
        Point source = new Point(0,0); 
        Point dest = new Point(3,4);
        System.out.println(findMinDist(mat, source, dest, 0));
    }
}