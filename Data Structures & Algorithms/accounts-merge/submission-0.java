class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,String> emailtoname=new HashMap<>();
        HashMap<String,List<String>> graph=new HashMap<>();
        for(List<String> acc:accounts){
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++){
                String email=acc.get(i);
                graph.putIfAbsent(email,new ArrayList<>());
                emailtoname.put(email,name);
                if(i>1){
                    String a=acc.get(i-1);
                    graph.get(a).add(email);
                    graph.get(email).add(a);
                }
            }
        }
        HashSet<String> set=new HashSet<>();
        List<List<String>> result=new ArrayList<>();
        for(String email:graph.keySet()){
            if(!(set.contains(email))){
                List<String> component=new ArrayList<>();
                dfs(email,graph,set,component);
                Collections.sort(component);
                List<String> merged=new ArrayList<>();
                merged.add(emailtoname.get(email));
                merged.addAll(component);
                result.add(merged);
            }
        }
        return result;
    }
    private void dfs(String email,HashMap<String,List<String>> graph,HashSet<String> set,List<String> component){
        set.add(email);
        component.add(email);
        for(String n:graph.get(email)){
            if(!set.contains(n))dfs(n,graph,set,component);
        }
    }
}