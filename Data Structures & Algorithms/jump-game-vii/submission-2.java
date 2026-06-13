class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        q.offer(0);
        int farthest=1;
        while(!q.isEmpty()){
            int i=q.poll();
            if(i==n-1)return true;
            int start=Math.max(farthest,i+minJump);
            int end=Math.min(n-1,i+maxJump);
            for(int j=start;j<=end;j++){
                if(!visited[j]&&s.charAt(j)=='0'){
                    visited[j]=true;
                    q.offer(j);
                }
            }
            farthest=Math.max(farthest,end+1);
        }
        return false;
    }
}