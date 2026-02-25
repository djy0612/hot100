package main.java.mid;

public class exist {
    public boolean exist(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word,int i,int j,int count){
        int m = board.length;
        int n = board[0].length;
        if(i<0||j<0||i>=m||j>=n) return false;
        if(board[i][j]!=word.charAt(count)) return false;
        if(count==word.length()-1)
            return true;
        char tmp = board[i][j];
        board[i][j] ='#';
        count++;
        boolean flag =  dfs(board,word,i+1,j,count)
                ||dfs(board,word,i-1,j,count)
                ||dfs(board,word,i,j+1,count)
                ||dfs(board,word,i,j-1,count);
        board[i][j] = tmp;
        return flag;
    }
}
