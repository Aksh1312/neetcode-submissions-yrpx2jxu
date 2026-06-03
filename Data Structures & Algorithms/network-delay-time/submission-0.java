class Solution {
    public class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int[] dij(HashMap<Integer,List<int[]>> list,int src,int n){
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->(a.distance-b.distance));
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int n1=curr.node;
            int d1=curr.distance;
            if(d1>dist[n1])continue;
            for(int[] nei : list.getOrDefault(n1, new ArrayList<>())){
                int n2=nei[0];
                int d2=nei[1];
                if(d1+d2<dist[n2]){
                    dist[n2]=d1+d2;
                    q.offer(new Pair(n2,dist[n2]));
                }
            }
        }
        return dist;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> map=new HashMap<>();
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            if(!map.containsKey(u))map.put(u,new ArrayList<>());
            map.get(u).add(new int[]{v,w});
        }
        int[]dist=dij(map,k,n);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            if(dist[i]>max)max=dist[i];
        }
        return max;
    }
}
