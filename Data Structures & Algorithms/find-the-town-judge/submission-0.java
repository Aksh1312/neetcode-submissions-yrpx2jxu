class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] out=new int[n+1];
        int[] in=new int[n+1];
        for(int[] t:trust){
            int a=t[0];
            int b=t[1];
            out[a]++;
            in[b]++;
        }
        for(int i=1;i<=n;i++){
            if(out[i]==0&&in[i]==n-1)return i;
        }
        return -1;
    }
}