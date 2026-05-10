class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i<9; i++) {
            for (int j = 0; j<9; j++){
                if ('.' == board[i][j]) continue;

                int value = board[i][j] - '1';
                int bit = 1 << value;
                if (rows[i] != 0 && (rows[i] & bit) != 0) return false;
                else rows[i] |= bit;

                if (cols[j] != 0 && (cols[j] & bit) != 0) return false;
                else cols[j] |= bit;

                int box = (i / 3) * 3 + (j / 3);
                if (boxes[box] != 0 && (boxes[box] & bit) != 0) return false;
                else boxes[box] |= bit;
            }
        }
        return true;
    }
}
