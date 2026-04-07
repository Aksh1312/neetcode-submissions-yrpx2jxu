class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total=0,n=matchsticks.length;
        for(int i:matchsticks)total+=i;
        if(total%4!=0)return false;
        int target=total/4;
        int[] sides=new int[4];
        Arrays.sort(matchsticks);
        for(int i=0;i<matchsticks.length/2;i++){
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[matchsticks.length-i-1];
            matchsticks[matchsticks.length-i-1]=temp;
        }
        return make(matchsticks,0,sides,target);
    }
    private boolean make(int[] matchsticks,int index,int[] sides,int target){
        if(index==matchsticks.length){
            return sides[0]==target&&sides[1]==target&&
            sides[2]==target&&sides[3]==target;
        }
        for(int i=0;i<4;i++){
            if(sides[i]+matchsticks[index]>target)continue;
            sides[i]+=matchsticks[index];
            if(make(matchsticks,index+1,sides,target))return true;
            sides[i]-=matchsticks[index];
        }
        return false;
    }
}