class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n=triplets.length;
        int m=triplets[0].length;
        int p=target.length;
        int[] arr=new int[p];
        Arrays.fill(arr,0);
        boolean valid=true;
        for(int i=0;i<n;i++){
            valid=true;
            for(int j=0;j<m;j++){
                if(triplets[i][j]>target[j]){
                    valid=false;
                    break;
                }
            }
            if(!valid)continue;
            for(int j=0;j<m;j++){
                if(arr[j]<triplets[i][j]){
                    arr[j]=triplets[i][j];
                }
            }
        }
        for(int i=0;i<p;i++){
            if(arr[i]!=target[i])return false;
        }
        return true;
    }
}
