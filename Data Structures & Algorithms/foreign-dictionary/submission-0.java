class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        for (int j = 0; j < words.length - 1; j++) {
            String one = words[j];
            String two = words[j + 1];
            if (one.length() > two.length() && one.startsWith(two))
                return "";
            int len = Math.min(one.length(), two.length());
            for (int i = 0; i < len; i++) {
                if (one.charAt(i) != two.charAt(i)) {
                    if (!graph.get(one.charAt(i)).contains(two.charAt(i))) {
                        graph.get(one.charAt(i)).add(two.charAt(i));
                        indegree.put(two.charAt(i), indegree.get(two.charAt(i)) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0)
                q.offer(ch);
        }
        StringBuilder str = new StringBuilder();
        while(!q.isEmpty()){
            char ch=q.poll();
            str.append(ch);
            for(char s:graph.get(ch)){
                indegree.put(s,indegree.get(s)-1);
                if(indegree.get(s)==0)q.offer(s);
            }
        }
        if(str.length()!=indegree.size())return ""; 
        return str.toString();
    }
}
