class Solution {
    public int largestRectangleArea(int[] heights) {
        // One pass solution
        int n = heights.length;
        Deque<Integer> leftStack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i<n; i++) {
            while (!leftStack.isEmpty() && heights[leftStack.peek()] > heights[i]) {
                int curBar = leftStack.pop();
                int leftSmaller = leftStack.isEmpty() ? -1 : leftStack.peek();
                int curArea = heights[curBar] * (i - leftSmaller - 1);
                maxArea = (maxArea > curArea) ? maxArea : curArea;
            }
            leftStack.push(i);
        } 

        while (!leftStack.isEmpty()) {
            int curBar = leftStack.pop();
            int leftSmaller = leftStack.isEmpty() ? -1 : leftStack.peek();
            int curArea = heights[curBar] * (n - leftSmaller - 1);
            maxArea = (maxArea > curArea) ? maxArea : curArea;
        }

        return maxArea;
    }
}
