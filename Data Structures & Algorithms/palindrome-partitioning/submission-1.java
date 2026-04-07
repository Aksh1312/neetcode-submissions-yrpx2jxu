class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        part(s,new ArrayList<>(),0,result);
        return result;
    }
    private void part(String s,List<String> list,int start,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int end=start;end<s.length();end++){
            String a=s.substring(start,end+1);
            if(isPalindrome(a)){
                list.add(a);
                part(s,list,end+1,result);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--))return false;
        }
        return true;
    }
}
