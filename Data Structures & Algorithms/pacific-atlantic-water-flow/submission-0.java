class Solution {
    int n, m;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    private boolean checkpacific(int[][] heights, boolean[][] vis, int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m) return false;
        if(vis[i][j]) return false;
        vis[i][j] = true;

        if(i == 0 || j == 0) return true;

        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && c >= 0 && r < n && c < m &&
               heights[r][c] <= heights[i][j]){
                if(checkpacific(heights, vis, r, c))
                    return true;
            }
        }
        return false;
    }

    private boolean checkatlantic(int[][] heights, boolean[][] vis, int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m) return false;
        if(vis[i][j]) return false;
        vis[i][j] = true;

        if(i == n - 1 || j == m - 1) return true;

        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && c >= 0 && r < n && c < m &&
               heights[r][c] <= heights[i][j]){
                if(checkatlantic(heights, vis, r, c))
                    return true;
            }
        }
        return false;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean[][] vis1 = new boolean[n][m];
                boolean[][] vis2 = new boolean[n][m];

                if(checkpacific(heights, vis1, i, j) &&
                   checkatlantic(heights, vis2, i, j)){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}
