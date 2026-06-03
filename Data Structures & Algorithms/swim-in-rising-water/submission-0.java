class Solution {
    class Pair{
        int row;
        int col;
        int maxHei;
        Pair(int row,int col,int maxHei){
            this.row=row;
            this.col=col;
            this.maxHei=maxHei;
        }
    }
    public int swimInWater(int[][] grid) {
        int[][] dir={{0,-1},{-1,0},{1,0},{0,1}};
        int n=grid.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.maxHei-b.maxHei);
        pq.offer(new Pair(0,0,grid[0][0]));
        boolean[][] visited=new boolean[grid.length][grid.length];
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int nr=curr.row;
            int nc=curr.col;
            int cost=curr.maxHei;
            if(visited[nr][nc])continue;
            visited[nr][nc]=true;
            if(nr==n-1&&nc==n-1)return cost;
            for(int[] d:dir){
                int r=nr+d[0];
                int c=nc+d[1];
                if(r<0||r>=n||c<0||c>=n)continue;
                if(visited[r][c])continue;
                int max=Math.max(cost,grid[r][c]);
                pq.offer(new Pair(r,c,max));
            }
        }
        return -1;
    }
}
