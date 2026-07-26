class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int totalSize = m + n;

        int leftSize = (totalSize + 1) / 2;

        int aLeft = 0;
        int aRight = 0;
        int bLeft = 0;
        int bRight = 0;

        int left = 0;
        int right = m;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = leftSize - i;

            aLeft  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            aRight = (i == m) ? Integer.MAX_VALUE : nums1[i];
            bLeft  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            bRight = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (aLeft > bRight) {
                right = i - 1;
            }
            else if(bLeft > aRight) {
                left = i + 1;
            }
            else {
                // return answer
                if (totalSize % 2 == 1) return Math.max(aLeft, bLeft);
                else return ((double) Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
            }
        }

        throw new IllegalArgumentException("Input arrays are invalid.");
    }
}
