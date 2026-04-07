class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)return Arrays.asList(0);
        List<List<Integer>> graph=new ArrayList<>();
        int[] degree=new int[n];
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1)q.offer(i);
        }
        int remain=n;
        while(remain>2){
            int a=q.size();
            remain-=a;
            for(int i=0;i<a;i++){
                int leaf=q.poll();
                for(int neighbour:graph.get(leaf)){
                    degree[neighbour]--;
                    if(degree[neighbour]==1)q.offer(neighbour);
                }
            }
        }
        return new ArrayList<>(q);
    }
}