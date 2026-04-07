class Solution {

    public String encode(List<String> strs) {
        String encode="";
        for(String str:strs){
            int len=str.length();
            encode+=len+"#"+str;
        }
        return encode;
    }

    public List<String> decode(String str) {
        List<String> decode=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len=Integer.valueOf(str.substring(i,j));
            j++;
            decode.add(str.substring(j,j+len));
            i=j+len;
        }
        return decode;
    }
}
