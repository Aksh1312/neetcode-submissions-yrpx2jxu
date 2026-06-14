class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count=new int[26];
        for(int i=0;i<s.length();i++)count[s.charAt(i)-'a']=i;
        List<Integer> list=new ArrayList<>();
        int end=0,start=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,count[s.charAt(i)-'a']);
            if(i==end){
                list.add(end-start+1);
                start=end+1;
            }
        }
        return list;
    }
}
