class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stk.push(c);
            }
            else if(!stk.isEmpty()){
                if(stk.peek()=='('&& c==')'){
                    stk.pop();
                }
                else if(stk.peek()=='{'&& c=='}'){
                    stk.pop();
                }
                else if(stk.peek()=='['&& c==']'){
                    stk.pop();
                }
                else{
                    return false;
                }
            }
            else return false;
        }
        return stk.size()==0?true:false;
    }
}
