class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        for(int i=0;i<n;i++){
            HashSet<Character> set=new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[i][j]=='.')continue;
                if(set.contains(board[i][j]))return false;
                set.add(board[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            HashSet<Character> set1=new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[j][i]=='.')continue;
                if(set1.contains(board[j][i]))return false;
                set1.add(board[j][i]);
            }
        }
        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                HashSet<Character> set2=new HashSet<>();
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(board[row+i][col+j]=='.')continue;
                        if(set2.contains(board[row+i][col+j]))return false;
                        set2.add(board[row+i][col+j]);
                    }
                }
            }
        }
        return true;
    }
}
