class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String st=new String(ch);
            if(map.containsKey(st)){
                map.get(st).add(str);
            }
            else{
                List<String> l=new ArrayList<>();
                l.add(str);
                map.put(st,l);
            }
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}
