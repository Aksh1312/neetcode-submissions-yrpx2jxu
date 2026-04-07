class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)fresh++;
            }
        }
        int min=0;
        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean set=false;
            for(int i=0;i<size;i++){
                int[] a=q.poll();
                    for(int[] d:dir){
                        int r=a[0]+d[0],c=a[1]+d[1];
                        if(r>=0&&c>=0&&r<n&&c<m&&grid[r][c]==1){
                            grid[r][c]=2;
                            q.add(new int[]{r,c});
                            set=true;
                            fresh--;
                        }
                    }
                }
                if(set)min++;
            }
        return fresh==0?min:-1;
    }
}
