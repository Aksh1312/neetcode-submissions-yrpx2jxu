class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] a=new int[26];
        for(int i=0;i<order.length();i++){
            a[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++){
            if(!fun(words[i],words[i+1],a))return false;
        }
        return true;
    }
    private boolean fun(String word1,String word2,int[] a){
        int len=Math.min(word1.length(),word2.length());
        for(int i=0;i<len;i++){
            char p=word1.charAt(i);
            char q=word2.charAt(i);
            if(p!=q)return a[p-'a']<a[q-'a'];
        }
        return word1.length()<=word2.length();
    }
}