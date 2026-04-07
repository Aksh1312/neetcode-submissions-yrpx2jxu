class Solution {
    int val=0;
    private int dfs(int[][] grid,int row,int col){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]==0)return 0;
        grid[row][col]=0;
        val++;
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
        return val;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int m=grid[0].length;
        int n=grid.length;
        for(int i=0;i<n;i++){
            val=0;
            for(int j=0;j<m;j++){
                val=dfs(grid,i,j);
                if(max<val)max=val;
            }
        }
        return max;
    }
}
