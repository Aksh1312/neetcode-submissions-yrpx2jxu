class Solution {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        String s1=s.toLowerCase();
        while(left<right){
            while(left<right && !((s1.charAt(left)>='a' && s1.charAt(left)<='z')||(s1.charAt(left) >= '0' && s1.charAt(left) <= '9')))left++;
            while(left<right && !((s1.charAt(right)>='a' && s1.charAt(right)<='z')||(s1.charAt(left) >= '0' && s1.charAt(left) <= '9')))right--;
            if(s1.charAt(left)!=s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
