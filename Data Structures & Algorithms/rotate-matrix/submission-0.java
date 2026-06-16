class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length,top=0,bottom=n-1;
        while(top<=bottom){
            int[] row=matrix[top];
            matrix[top]=matrix[bottom];
            matrix[bottom]=row;
            top++;
            bottom--;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=a;
            }
        }
    }
}
