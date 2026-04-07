class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        for(int i=1;i<=edges.length;i++){
            parent[i]=i;
        }
        for(int[] e:edges){
            int pu=e[0];
            int pv=e[1];
            int u=find(pu,parent);
            int v=find(pv,parent);
            if(u==v)return e;
            parent[u]=v;
        }
        return new int[0];
    }
    private int find(int a,int[] parent){
        if(parent[a]!=a)parent[a]=find(parent[a],parent);
        return parent[a];
    }
}
