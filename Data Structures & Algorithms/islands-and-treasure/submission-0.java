class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)q.offer(new int[]{i,j});
            }
        }
        int[][] d={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] t=q.poll();
            int r=t[0];
            int c=t[1];
            for(int[] dir:d){
                int rc=r+dir[0];
                int cc=c+dir[1];
                if(rc>=0&&cc>=0&&rc<grid.length&&cc<grid[0].length&&grid[rc][cc]==2147483647){
                    grid[rc][cc]=grid[r][c]+1;
                    q.offer(new int[]{rc,cc});
                }
            }
        }
    }
}
