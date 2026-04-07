class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] a=new int[n][2];
        PriorityQueue<int[]> min=new PriorityQueue<>((x,b)->x[0]-b[0]);
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<profits.length;i++){
            min.offer(new int[] {capital[i],profits[i]});
        }
        int curr=w;
        for(int i=0;i<k;i++){
            while(!min.isEmpty()&&min.peek()[0]<=curr){
                max.offer(min.poll()[1]);
            }
            if(max.isEmpty())break;
            curr+=max.poll();
        }
        return curr;
    }
}