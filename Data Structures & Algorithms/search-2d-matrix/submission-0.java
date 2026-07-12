class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length;  // row
        int n = matrix[0].length;   //column

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rowIdx = mid / n;
            int colIdx = mid % n;

            if (matrix[rowIdx][colIdx] == target) return true;
            else if (matrix[rowIdx][colIdx] < target) {
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return false;
    }
}
