class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkint=new Stack<>();
        Stack<String> stkstr=new Stack<>();
        String current="";
        int num=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='['){
                stkint.push(num);
                stkstr.push(current);
                current="";
                num=0;
            }
            else if(ch==']'){
                int repeat=stkint.pop();
                StringBuilder st=new StringBuilder(stkstr.pop());
                for(int i=0;i<repeat;i++){
                    st.append(current);
                }
                current=st.toString();
            }
            else{
                current+=ch;
            }
        }
        return current;
    }
}