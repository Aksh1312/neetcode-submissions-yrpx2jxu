class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        for(int[] interval:intervals){
            if(interval[1]<newInterval[0]){
                list.add(interval);
            }
            else if(newInterval[1]<interval[0]){
                list.add(newInterval);
                newInterval=interval;
            }
            else{
                newInterval[0]=Math.min(interval[0],newInterval[0]);
                newInterval[1]=Math.max(interval[1],newInterval[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
