class Solution {
    int[][] dp;
    public int fun(int i,int j,String s,String t){
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=fun(i-1,j-1,s,t)+fun(i-1,j,s,t);
        }
        else{
            return dp[i][j]=fun(i-1,j,s,t);
        }
    }
    public int numDistinct(String s, String t) {
        dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(s.length()-1,t.length()-1,s,t);
    }
}
