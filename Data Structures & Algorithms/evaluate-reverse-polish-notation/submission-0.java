class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<>();
        for(String a:tokens){
            if(a.equals("+")||a.equals("-")||a.equals("*")||a.equals("/")){
                int b=stk.pop();
                int c=stk.pop();
                int result=0;
                switch(a){
                    case "+":result=c+b;break;
                    case "-":result=c-b;break;
                    case "*":result=c*b;break;
                    case "/":result=c/b;break;
                }
                stk.push(result);
            }
            else{
                stk.push(Integer.parseInt(a));
            }
        }
        return stk.pop();
    }
}
