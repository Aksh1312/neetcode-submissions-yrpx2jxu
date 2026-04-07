class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String st=new String(ch);
            if(map.containsKey(st)){
                map.get(st).add(str);
            }
            else{
                List<String> st1=new ArrayList<>();
                st1.add(str);
                map.put(st,st1);
            }
        }
        List<List<String>> list=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}
