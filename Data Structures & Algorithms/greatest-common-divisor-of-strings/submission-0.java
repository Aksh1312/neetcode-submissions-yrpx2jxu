class Solution {
    public String gcdOfStrings(String str1, String str2) {
        while(!str1.isEmpty()&&!str2.isEmpty()){
            if(str1.length()<str2.length()){
                String temp=str1;
                str1=str2;
                str2=temp;
            }
            if(!str1.startsWith(str2))return "";
            str1=str1.substring(str2.length());
        }
        return str1.isEmpty()?str2:str1;
    }
}