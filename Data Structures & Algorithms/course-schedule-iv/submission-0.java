class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] arr=new boolean[numCourses][numCourses];
        for(int[] p:prerequisites){
            arr[p[0]][p[1]]=true;
        }
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(arr[i][k]&&arr[k][j]){
                        arr[i][j]=true;
                    }
                }
            }
        }
        List<Boolean> list=new ArrayList<>();
        for(int[] q:queries){
            list.add(arr[q[0]][q[1]]);
        }
        return list;
    }
}