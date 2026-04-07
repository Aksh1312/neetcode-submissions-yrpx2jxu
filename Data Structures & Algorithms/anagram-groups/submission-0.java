class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String st:strs){
            char[] a=st.toCharArray();
            Arrays.sort(a);
            String b=new String(a);
            if(map.containsKey(b)){
                map.get(b).add(st);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(st);
                map.put(b,list);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> a:map.values()){
            ans.add(a);
        }
        return ans;
    }
}
