class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        int idx = 0;
        for (int right = 0; right < n; right++) {
            int left = right - k + 1;
            // remove expired
            if (!q.isEmpty() && q.peekFirst() < left) q.removeFirst();

            // remove back
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[right]) q.removeLast();

            // add new queue element
            q.addLast(right);

            // update answer
            if (left >= 0) {
                answer[idx] = nums[q.peekFirst()];
                idx++;
            }
        }
        return answer;
    }
}
