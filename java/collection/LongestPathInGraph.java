public class LongestPathInGrap {
    List<String> findLongestPath (String[][] pairs) {
        // Check for null
        if (pairs == null || pairs.length == 0) return null;
        Map<String, List<String>> graph = new HashMap<>();
        
        // Create Graph
        for (String[] p : pairs) {
            if (!graph.containsKey(p[0])) {
                graph.put(p[0], new ArrayList<String>());
            }
            graph.get(p[0]).add(p[1]);
        }
        
        ArrayList<String> longestPath = new ArrayList<>();
        
        //Call the DFS for each node 
        for (String key: graph.keySet()) {
            ArrayList<String> currPath = new ArrayList<String>();
            // add source city to the list
            currPath.add(key);
            dfs(graph,key, currPath, longestPath);
        }
        return longestPath;
    }
    
    void dfs (Map<String, List<String>> graph, String city, ArrayList<String> currPath, ArrayList<String> longestPath) {
        // Check if the city has neighboring city or not
        if (graph.get(city) != null) {
            for (String neighborCity: graph.get(city)) {
                // add neighbor city to the list
                currPath.add(neighborCity);
                dfs (graph, neighborCity, currPath, longestPath);
                // Check if the currPath is longest
                if (currPath.size() > longestPath.size()) {
                    longestPath.clear();
                    longestPath.addAll(currPath);
                }
                // remove the last added city
                currPath.remove(currPath.size() - 1);
            } 
        }
    }
    public static void main(String[] args) {
        // Assumption there shouldn't be a cyle in the graph
        String[][] cityPair = new String[][]{ {"SF", "GOOG"}, 
                                             {"GOOG", "MS"}, 
                                             {"GOOG", "UBER"}, 
                                             {"UBER", "SAP"}, 
                                             {"UBER", "MCF"}, 
                                             {"MCF", "ORCL"}, 
                                             {"ORCL", "SV"} };
        
        LongestPathInGrap sol = new LongestPathInGrap();
        System.out.println(sol.findLongestPath(cityPair));
    }
}