class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> available=new PriorityQueue<>();
        for(int i=0;i<n;i++)available.offer(i);
        PriorityQueue<long[]> busy=new PriorityQueue<>(
            (a,b)->{if(a[0]==b[0])return Long.compare(a[1],b[1]);
            else return Long.compare(a[0],b[0]);}
        );
        int room;
        int[] count=new int[n];
        for(int[] meet:meetings){
            int start=meet[0];
            int end=meet[1];
            int dur=end-start;
            while(!busy.isEmpty()&&busy.peek()[0]<=start){
                available.offer((int)busy.poll()[1]);
            }
            if(!available.isEmpty()){
                room=available.poll();
                busy.offer(new long[]{end,room});
            }
            else{
                long[] bus=busy.poll();
                long free=bus[0];
                room=(int)bus[1];
                busy.offer(new long[]{dur+free,room});
            }
            count[room]++;
        }
        int ans=0;
        for(int i=1;i<n;i++){
            if(count[i]>count[ans]){
                ans=i;
            }
        }
        return ans;
    }
}