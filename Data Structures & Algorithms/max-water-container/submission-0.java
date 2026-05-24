class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int maxCapacity = 0;
        while (left < right) {
            int hLeft = heights[left];
            int hRight = heights[right];
            if (hLeft <= hRight) {
                maxCapacity = Math.max(maxCapacity, hLeft * (right - left));
                left++;
            }
            else {
                maxCapacity = Math.max(maxCapacity, hRight * (right - left));
                right--;
            }
        }
        return maxCapacity;
    }
}
