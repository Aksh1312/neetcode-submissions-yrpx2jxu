class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] c=new int[26];
        for(char ch:tasks){
            c[ch-'A']++;
        }
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,c[i]);
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(max==c[i])count++;
        }
        int ans=(n+1)*(max-1)+count;
        return Math.max(tasks.length,ans);
    }
}
