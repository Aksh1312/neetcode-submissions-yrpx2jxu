class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endWord))return level;
                char[] ch=s.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char ori=ch[j];
                    for(char k='a';k<='z';k++){
                        ch[j]=k;
                        String a=new String(ch);
                        if(set.contains(a)){
                            q.offer(a);
                            set.remove(a);
                        }
                    }
                    ch[j]=ori;
                }
            }
            level++;
        } 
        return 0;
    }
}
