class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(heights, pac, i, 0);
        }
        for(int j=0;j<m;j++){
            dfs(heights, pac, 0, j);
        }
        for(int i=0;i<n;i++){
            dfs(heights, atl, i, m-1);
        }
        for(int j=0;j<m;j++){
            dfs(heights, atl, n-1, j);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] h, boolean[][] vis, int r, int c){
        vis[r][c] = true;
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr>=0 && nc>=0 && nr<h.length && nc<h[0].length
               && !vis[nr][nc]
               && h[nr][nc] >= h[r][c]){
                dfs(h, vis, nr, nc);
            }
        }
    }
}