class TimeMap {
    Map<String,List<int[]>> timeMap=new HashMap<>();
    Map<Integer,String> map=new HashMap<>(); 
    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key,k->new ArrayList<>()).add(new int[]{timestamp});
        map.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        int t=-1;
        if(!timeMap.containsKey(key))return "";
        List<int[]> list=timeMap.get(key);
        int left=0,right=list.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(list.get(mid)[0]<=timestamp){
                t=list.get(mid)[0];
                left=mid+1;
            }
            else right=mid-1;
        }
        return t==-1?"":map.get(t);
    }
}
