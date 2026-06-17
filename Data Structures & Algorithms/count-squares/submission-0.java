class CountSquares {
    HashMap<String,Integer> map;
    public CountSquares() {
        map=new HashMap<>();
    }
    
    public void add(int[] point) {
        String val=point[0]+","+point[1];
        map.put(val,map.getOrDefault(val,0)+1);
    }
    
    public int count(int[] point) {
        int x=point[0];
        int y=point[1];
        int ans=0;
        for(String key:map.keySet()){
            String[] parts=key.split(",");
            int nx=Integer.parseInt(parts[0]);
            int ny=Integer.parseInt(parts[1]);
            if(x==nx||y==ny)continue;
            if(Math.abs(x-nx)!=Math.abs(y-ny)){
                continue;
            }
            String p1=nx+","+y;
            String p2=x+","+ny;
            ans+=map.get(key)*map.getOrDefault(p1,0)*map.getOrDefault(p2,0);
        }
        return ans;
    }
}
