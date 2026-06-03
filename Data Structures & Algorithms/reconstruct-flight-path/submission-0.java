class Solution {
    Map<String,PriorityQueue<String>> map=new HashMap<>();
    List<String> list=new ArrayList<>();
    public void fun(String str){
        PriorityQueue<String> pq=map.get(str);
        while(pq!=null&&!pq.isEmpty()){
            String next=pq.poll();
            fun(next);
        }
        list.add(str);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> l:tickets){
            String u=l.get(0);
            String v=l.get(1);
            map.putIfAbsent(u,new PriorityQueue<>());
            map.get(u).add(v);
        }
        fun("JFK");
        Collections.reverse(list);
        return list;
    }
}
