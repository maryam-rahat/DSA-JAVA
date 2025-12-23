class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
         
        boolean [] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int [][] isConnected, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}