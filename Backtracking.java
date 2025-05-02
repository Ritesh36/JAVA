public class Backtracking {
    public static void findSubset(String str, int i, String ans) {
        //Base Case
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        //Recursion
        //Yes Choice
        findSubset(str, i+1, ans+str.charAt(i));
        //No choice
        findSubset(str, i+1, ans);
    }

    public static void findPermmutation(String str, String ans) {
        //Base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        //recursion
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i + 1);
            findPermmutation(newString, ans+curr);
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {

        //vertical check
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //left diagnoal check
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        //right diagonal check
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++ ){
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        if(row == board.length) {
            // printBoard(board);
            count++;
            return;
        }

        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1); //function call
                board[row][j] = 'X'; //backtracking step
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("-------Chess Board ----------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;
    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
        System.out.println("Total number of ways to place queens: " + count);

        // String str = "abc";
        // findPermmutation(str, "");
    }
}
