class Solution {
    public boolean exist(char[][] board, String word) {
            // sen the values to a fn dfs
        // create dfs on grid
        // search the word along with the validity
        // check if the next one is wheter nelow or next
        // if true call again

        // else move

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y){
        if(index == word.length()) return true;

        if( x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) return false;
        char visited = board[x][y];

        board[x][y] = '#';

        boolean found = dfs(board, word, index + 1, x + 1, y) ||
                        dfs(board, word, index + 1, x - 1, y) ||
                        dfs(board, word, index + 1, x, y + 1) ||
                        dfs(board, word, index + 1, x, y - 1);
        board[x][y] = visited;

        return found;

    }
}