class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        com(n,k,1,new ArrayList<>(),result);
        return result;
    }
    private void com(int n,int k,int index,List<Integer> current,List<List<Integer>> result){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<=n;i++){
            current.add(i);
            com(n,k,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
}