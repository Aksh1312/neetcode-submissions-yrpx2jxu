class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0)return "";
        HashMap<Character,Integer> tmap=new HashMap<>();
        for(char c:t.toCharArray())tmap.put(c,tmap.getOrDefault(c,0)+1);
        int right=0,left=0,formed=0,req=tmap.size(),min=Integer.MAX_VALUE,start=0;
        HashMap<Character,Integer> smap=new HashMap<>();
        while(right<s.length()){
            char a=s.charAt(right);
            smap.put(a,smap.getOrDefault(a,0)+1);
            if(tmap.containsKey(a) && tmap.get(a).intValue()==smap.get(a).intValue()){
                formed++;
            }
            while(formed==req){
                if(right-left+1<min){
                    min=right-left+1;
                    start=left;
                }
                char p=s.charAt(left);
                smap.put(p,smap.getOrDefault(p,0)-1);
                if(tmap.containsKey(p)&&smap.get(p).intValue()<tmap.get(p).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}
