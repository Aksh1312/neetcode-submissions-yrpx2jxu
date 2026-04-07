class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)return false;
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] p:edges){
            list.get(p[1]).add(p[0]);
            list.get(p[0]).add(p[1]);
        }
        if(!dfs(0,-1,list,visited))return false;
        for(boolean i:visited){
            if(!i)return false;
        }
        return true;
    }
    private boolean dfs(int node,int parent,List<List<Integer>> list,boolean[] visited){
        if(visited[node])return false;
        visited[node]=true;
        for(int n:list.get(node)){
            if(n==parent)continue;
            if(!(dfs(n,node,list,visited)))return false;
        }
        return true;
    }
}
