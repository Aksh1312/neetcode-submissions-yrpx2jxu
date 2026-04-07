class Solution {
    private void number(char[][] grid,int row,int col){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]=='0')return;
        grid[row][col]='0';
        number(grid,row+1,col);
        number(grid,row,col+1);
        number(grid,row-1,col);
        number(grid,row,col-1);
        return;
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    number(grid,i,j);
                }
            }
        }
        return count;
    }
}
