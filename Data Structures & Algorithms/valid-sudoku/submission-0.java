class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i<9; i++) {
            for (int j = 0; j<9; j++){
                if ('.' == board[i][j]) continue;

                int value = board[i][j] - '1';
                if (rows[i][value]) return false;
                else rows[i][value] = true;

                if (cols[j][value]) return false;
                else cols[j][value] = true;

                int box = (i / 3) * 3 + (j / 3);
                if (boxes[box][value]) return false;
                else boxes[box][value] = true;
            }
        }
        return true;
    }
}
