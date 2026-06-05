class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row=topo(k,rowConditions);
        List<Integer> col=topo(k,colConditions);
        if(row.size()==0||col.size()==0)return new int[0][0];
        int[] rowp=new int[k+1];
        int[] colp=new int[k+1];
        for(int i=0;i<k;i++){
            rowp[row.get(i)]=i;
            colp[col.get(i)]=i;
        }
        int[][] ans=new int[k][k];
        for(int num=1;num<=k;num++){
            ans[rowp[num]][colp[num]]=num;
        }
        return ans;
    }
    public static List<Integer> topo(int k,int[][] arr){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=k;i++)graph.add(new ArrayList<>());
        int[] indegree=new int[k+1];
        for(int[] a:arr){
            int u=a[0];
            int v=a[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=k;i++){
            if(indegree[i]==0)q.offer(i);
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(int nei:graph.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0)q.offer(nei);
            }
        }
        return list;
    }
}