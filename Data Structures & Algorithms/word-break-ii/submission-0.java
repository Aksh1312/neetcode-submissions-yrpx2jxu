class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        return backtrack(s,set,0);
    }
    private List<String> backtrack(String s,Set<String> dict,int start){
        List<String> result=new ArrayList<>();
        if(start==s.length()){
            result.add("");
            return result;
        }
        for(int end=start+1;end<=s.length();end++){
            String word=s.substring(start,end);
            if(dict.contains(word)){
                List<String> subList=backtrack(s,dict,end);
                for(String sub:subList){
                    if(sub.isEmpty())result.add(word);
                    else result.add(word+" "+sub);
                }
            }
        }
        return result;
    }
}