class Twitter {
    int times=0;
    private class Tweet{
        int id;
        int time;
        Tweet(int id,int time){
            this.id=id;
            this.time=time;
        }
    }
    private HashMap<Integer,Set<Integer>>set;
    private HashMap<Integer,List<Tweet>>list;
    public Twitter() {
        set=new HashMap<>();
        list=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        list.putIfAbsent(userId,new ArrayList<>());
        list.get(userId).add(new Tweet(tweetId,times++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->(b.time-a.time));
        if(list.containsKey(userId)){
            pq.addAll(list.get(userId));
        }
        if(set.containsKey(userId)){
            for(int val:set.get(userId)){
                if(list.containsKey(val)){
                    pq.addAll(list.get(val));
                }
            }
        }
        List<Integer> a=new ArrayList<>();
        int count=0;
        while(!pq.isEmpty()&&count<10){
            a.add(pq.poll().id);
            count++;
        }
        return a;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        set.putIfAbsent(followerId,new HashSet<>());
        set.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(set.containsKey(followerId)){
            set.get(followerId).remove(followeeId);
        }
    }
}
