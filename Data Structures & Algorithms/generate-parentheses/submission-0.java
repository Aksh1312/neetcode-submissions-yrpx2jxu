class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        gen(result,"",0,0,n);
        return result;
    }
    private void gen(List<String> result,String str,int open,int close,int n){
        if(n*2==str.length()){
            result.add(str);
            return;
        }
        if(open<n)gen(result,str+"(",open+1,close,n);
        if(close<open)gen(result,str+")",open,close+1,n);
    }
}
