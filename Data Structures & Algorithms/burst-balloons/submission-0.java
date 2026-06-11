class Solution {
    int[][] dp;
    public int fun(int i,int j,List<Integer> arr){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=arr.get(i-1)*arr.get(ind)*arr.get(j+1)+fun(i,ind-1,arr)+fun(ind+1,j,arr);
            min=Math.max(min,cost);
        }  
        return dp[i][j]=min;   
    }
    public int maxCoins(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        dp=new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length+1;i++)Arrays.fill(dp[i],-1);
        arr.add(1);
        for(int i:nums)arr.add(i);
        arr.add(1);
        return fun(1,nums.length,arr);
    }
}
