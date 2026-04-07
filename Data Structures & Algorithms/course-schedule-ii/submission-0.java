class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] order=new int[numCourses];
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }
        int index=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            order[index++]=curr;
            for(int i:graph.get(curr)){
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            }
        }
        if(index==numCourses)return order;
        return new int[0];
    }
}
