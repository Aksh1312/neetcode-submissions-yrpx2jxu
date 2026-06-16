class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            str.append((char)('A'+columnNumber%26));
            columnNumber/=26;
        }
        return str.reverse().toString();
    }
}