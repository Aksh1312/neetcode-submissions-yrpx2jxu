class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> str=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')st.push(i);
            else if(s.charAt(i)=='*')str.push(i);
            else{
                if(!st.isEmpty())st.pop();
                else if(!str.isEmpty())str.pop();
                else return false;
            }
        }
        while(!st.isEmpty()&&!str.isEmpty()){
            if(st.peek()>str.peek())return false;
            st.pop();
            str.pop();
        }
        if(st.isEmpty())return true;
        return false;
    }
}
