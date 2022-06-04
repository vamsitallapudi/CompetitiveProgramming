import java.util.*;

public class Solution {
    List<List<String>> sol = new ArrayList<>();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(a -> Arrays.fill(a, '.'));
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return sol;
    }

    private void backtrack(int row, Set<Integer> col, Set<Integer> d, Set<Integer> ad, char[][] board) {
        if (row == n) {
            sol.add(createBoard(board));
            return;
        }
        // trying to place the queen in any column of a row
        for (int c = 0; c < n; c++) {
            // calculating current diagonal according to their properties.
            int dia = row - c;
            int antiDia = row + c;
            if (col.contains(c) || d.contains(dia) || ad.contains(antiDia)) {
                continue;
            }
            col.add(c);
            d.add(dia);
            ad.add(antiDia);
            board[row][c] = 'Q';
            // Move on to the next row with the updated board state
            backtrack(row + 1, col, d, ad, board);
            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            col.remove(c);
            d.remove(dia);
            ad.remove(antiDia);
            board[row][c] = '.';
        }
    }

    private List<String> createBoard(char[][] board) {
        List<String> s = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            s.add(new String(board[row]));
        }
        return s;
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}
