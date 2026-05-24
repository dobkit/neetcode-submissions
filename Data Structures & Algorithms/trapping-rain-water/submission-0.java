class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;
        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];
            if (hLeft < hRight) {
                maxLeft = Math.max(maxLeft, hLeft);
                totalWater = totalWater + maxLeft - hLeft;
                left++;
            } else {
                maxRight = Math.max(maxRight, hRight);
                totalWater = totalWater + maxRight - hRight;
                right--;
            }
        }
        return totalWater;
    }
}
