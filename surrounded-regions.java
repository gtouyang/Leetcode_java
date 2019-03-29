/*
Question:

Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
A region is captured by flipping all'O's into'X's in that surrounded region .

*/
public class Solution {

    public void solve(char[][] board) {
        
        if (board.length <= 1 || board[0].length <= 1){
            return;
        }

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++){
            if (board[i][0] == 'O'){
                target(i, 0, board);
            }
            if (board[i][col-1] == 'O'){
                target(i, col-1, board);
            }
        }

        for (int j = 0; j < col; j++){
            if(board[0][j] == 'O'){
                target(0, j, board);
            }
            if(board[row-1][j] == 'O'){
                target(row-1, j, board);
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void target(int x, int y, char[][] board) {
        int row = board.length;
        int col = board[0].length;

        board[x][y] = 'T';

        if(x > 0 && board[x-1][y] == 'O'){
            target(x-1, y, board);
        }
        if(x < row-1 && board[x+1][y] == 'O'){
            target(x+1, y, board);
        }
        if(y > 0 && board[x][y-1] == 'O'){
            target(x, y-1, board);
        }
        if(y < col-1 && board[x][y+1] == 'O'){
            target(x, y+1, board);
        }
    }
}