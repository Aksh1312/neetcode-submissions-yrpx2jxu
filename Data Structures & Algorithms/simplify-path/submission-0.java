class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk=new Stack<>();
        String[] parts=path.split("/");
        for(String s:parts){
            if(s.equals("")||s.equals("."))continue;
            else if(s.equals("..")){
                if(!stk.isEmpty())stk.pop();
            }
            else stk.push(s);
        }
        StringBuilder result=new StringBuilder();
        for(String a:stk){
            result.append("/").append(a);
        }
        return result.length()==0?"/":result.toString();
    }
}