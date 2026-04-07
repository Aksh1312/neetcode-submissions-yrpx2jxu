class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max=new PriorityQueue(Collections.reverseOrder());
        for(int num:stones){
            max.offer(num);
        }
        while(max.size()>1){
            int y=max.poll();
            int x=max.poll();
            if(y!=x)max.offer(y-x);
        }
        return max.isEmpty()?0:max.peek();
    }
}
