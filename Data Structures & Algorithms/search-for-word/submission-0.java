class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(verify(board,i,j,0,word))return true;
            }
        }
        return false;
    }
    private boolean verify(char[][] board,int row,int col,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(row<0||row>=board.length||col<0||col>=board[0].length||word.charAt(index)!=board[row][col]){
            return false;
        }
        char a=board[row][col];
        board[row][col]='#';
        boolean bool=verify(board,row+1,col,index+1,word)||
                verify(board,row-1,col,index+1,word)||
                verify(board,row,col+1,index+1,word)||
                verify(board,row,col-1,index+1,word);
        board[row][col]=a;
        return bool;
    }
}
