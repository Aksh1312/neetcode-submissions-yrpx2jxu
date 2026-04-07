class Solution {
    private String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null||digits.length()==0)return result;
        letter(result,new StringBuilder(),0,digits);
        return result;
    }
    private void letter(List<String> result,StringBuilder current,int index,String digits){
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }
        String digit=map[digits.charAt(index)-'0'];
        for(char ch:digit.toCharArray()){
            current.append(ch);
            letter(result,current,index+1,digits);
            current.deleteCharAt(current.length()-1);
        }
    }
}
