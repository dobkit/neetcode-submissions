class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int m = piles.length;
        int n = 0;

        for (int pile : piles) {
            n = Math.max(n, pile);
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int totalH = 0;

            for (int i = 0; i< m; i++) {
                totalH += (piles[i] + mid -1)/mid;
            }
            
            if (totalH > h) left = mid +1;
            else right = mid -1;
        }

        return left;
    }
}
