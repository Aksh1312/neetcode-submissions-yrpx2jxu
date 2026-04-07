class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk=new Stack<>();
        int val=0;
        for(String c:operations){
            if(c.equals("D")){
                int d=stk.peek();
                stk.push(d*2);
            }
            else if(c.equals("+")){
                int a=stk.pop();
                int b=stk.peek();
                int c1=a+b;
                stk.push(a);
                stk.push(c1);
            }
            else if(c.equals("C")){
                stk.pop();
            }
            else{
                stk.push(Integer.parseInt(c));
            }
        }
        while(!stk.isEmpty()){
            val+=stk.pop();
        }
        return val;
    }
}