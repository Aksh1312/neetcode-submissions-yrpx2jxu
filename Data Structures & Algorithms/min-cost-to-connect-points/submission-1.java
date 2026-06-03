class Solution {
    class Pair{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[] visited=new boolean[points.length];
        int cost=0,connected=0;
        pq.offer(new Pair(0,0));
        while(connected<points.length){
            Pair curr=pq.poll();
            int node=curr.node;
            int dist=curr.cost;
            if(visited[node])continue;
            visited[node]=true;
            cost+=dist;
            connected++;
            for(int next=0;next<points.length;next++){
                if(!visited[next]){
                    int dis=Math.abs(points[node][0]-points[next][0])+Math.abs(points[node][1]-points[next][1]);
                    pq.add(new Pair(next,dis));
                }
            }
        }
        return cost;
    }
}
