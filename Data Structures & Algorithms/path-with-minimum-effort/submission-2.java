class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dir=new int[n][m];
        for(int[] row:dir){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int[][] d={{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int[]{0,0,0});
        dir[0][0]=0;
        while(!q.isEmpty()){
            int[] a=q.poll();
            int effort=a[0];
            int r=a[1];
            int c=a[2];
            if(r==n-1&&c==m-1)return effort;
            for(int i=0;i<4;i++){
                int nr=r+d[i][0];
                int nc=c+d[i][1];
                if(nr>=0&&nr<=n-1&&nc>=0&&nc<=m-1){
                    int newEffort=Math.max(effort,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(newEffort<dir[nr][nc]){
                        dir[nr][nc]=newEffort;
                        q.offer(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}