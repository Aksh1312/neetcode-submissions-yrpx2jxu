class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left=0,maxlength=0;
        for(int right=0;right<s.length();right++){
            char a=s.charAt(right);
            while(set.contains(a)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(a);
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}
