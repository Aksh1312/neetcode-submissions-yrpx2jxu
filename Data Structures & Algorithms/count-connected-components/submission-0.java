class Solution {
    public int countComponents(int n, int[][] edges) {
        int comp=0;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] e:edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,list);
                comp++;
            }
        }
        return comp;
    }
    private void dfs(int i,boolean[] visited,List<List<Integer>> list){
        visited[i]=true;
        for(int g:list.get(i)){
            if(!visited[g]){
                dfs(g,visited,list);
            }
        }
        return;
    }
}
