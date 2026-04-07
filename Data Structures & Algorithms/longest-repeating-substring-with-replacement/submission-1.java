class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int maxlen=0,maxfreq=0,left=0;
        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'A']++;
            maxfreq=Math.max(count[s.charAt(right)-'A'],maxfreq);
            while((right-left+1)-maxfreq>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxlen=Math.max(maxlen,(right-left+1));
        }
        return maxlen;
    }
}
