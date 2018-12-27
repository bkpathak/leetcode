class Solution {
    public double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + " " + p[1]);
        }
        double result = Double.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    continue;
                }
                for (int[] p3 : points) {
                    if (dist(p1, p3) + dist(p2, p3) != dist(p1, p2)) {
                        continue;
                    }
                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    if (!set.contains(x + " " + y)) {
                        continue;
                    }
                    double area = Math.sqrt(dist(p1, p3)) * Math.sqrt(dist(p2, p3));
                    if (Double.compare(area, 0) == 0) {
                        continue;
                    }
                    result = Math.min(result, area);
                }
            }
        }
        return Double.compare(Double.MAX_VALUE, result) == 0 ? 0 : result;
    }
    private int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}