class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead=new HashSet<>(Arrays.asList(deadends));
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        if(dead.contains("0000"))return -1;
        q.add("0000");
        visited.add("0000");
        int turns=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(target))return turns;
                for(int j=0;j<4;j++){
                    char[] arr=s.toCharArray();
                    arr[j]=(char)((arr[j]-'0'+1)%10+'0');
                    String up=new String(arr);
                    if(!dead.contains(up)&&!visited.contains(up)){
                        q.add(up);
                        visited.add(up);
                    }
                    arr=s.toCharArray();
                    arr[j]=(char)((arr[j]-'0'+9)%10+'0');
                    String down=new String(arr);
                    if(!dead.contains(down)&&!visited.contains(down)){
                        q.add(down);
                        visited.add(down);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}