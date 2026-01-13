class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original_color = image[sr][sc];

        if (original_color == color) return image;

        dfs(image, sr, sc, original_color, color);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int original_color, int color){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || original_color != image[x][y]) return;

        image[x][y] = color;
        dfs(image, x+1, y, original_color, color);
        dfs(image, x-1, y, original_color, color);
        dfs(image, x, y+1, original_color, color);
        dfs(image, x, y-1, original_color, color);
    }
}