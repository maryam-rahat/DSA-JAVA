class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set <Integer> visited = new HashSet<>();
        return dfs(graph,source, destination, visited);
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, Set <Integer> visited){
        if(current == destination) return true;

        visited.add(current);

        for(int neighbor: graph.getOrDefault(current, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                if(dfs(graph, neighbor, destination, visited)) return true;
            }
        }
        return false;
    }
}