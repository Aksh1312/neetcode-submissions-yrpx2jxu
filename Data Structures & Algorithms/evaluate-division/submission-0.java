class Solution {
    class Pair{
        String n;
        double w;
        Pair(String n,double w){
            this.n=n;
            this.w=w;
        }
    }
    public double[] calcEquation(List<List<String>> l, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> map=new HashMap<>();
        for(int i=0;i<l.size();i++){
            String a=l.get(i).get(0);
            String b=l.get(i).get(1);
            double weight=values[i];
            map.putIfAbsent(a,new ArrayList<>());
            map.putIfAbsent(b,new ArrayList<>());
            map.get(a).add(new Pair(b,weight));
            map.get(b).add(new Pair(a,1.0/weight));
        }
        double[] res=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            if(!map.containsKey(a)||!map.containsKey(b)){
                res[i]=-1.0;
            }
            else if(a.equals(b))res[i]=1.0;
            else{
                HashSet<String> visited=new HashSet<>();
                res[i]=dfs(map,a,b,1.0,visited);
            }
        }
        return res;
    }
    private double dfs(HashMap<String,List<Pair>> map,String src,String dest,double p,HashSet<String> visited){
        if(src.equals(dest))return p;
        visited.add(src);
        for(Pair n1:map.get(src)){
            if(!visited.contains(n1.n)){
                double ans=dfs(map,n1.n,dest,p*n1.w,visited);
                if(ans!=-1.0)return ans;
            }
        }
        return -1.0;
    }
}