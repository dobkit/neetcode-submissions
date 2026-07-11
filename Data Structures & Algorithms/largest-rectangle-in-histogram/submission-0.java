class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        int maxArea = -1;

        // Compute leftSmaller
        Deque<Integer> leftStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]) {
                leftStack.pop();
            }
            if (leftStack.isEmpty()) {
                leftSmaller[i] = -1;
            }
            else {
                leftSmaller[i] = leftStack.peek();
            }
            leftStack.push(i);
        }

        // Compute rightSmaller
        Deque<Integer> rightStack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]) {
                rightStack.pop();
            }
            if (rightStack.isEmpty()) {
                rightSmaller[i] = n;
            }
            else {
                rightSmaller[i] = rightStack.peek();
            }
            rightStack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int curArea = heights[i] * (rightSmaller[i] - leftSmaller[i] - 1);
            if (maxArea < curArea) maxArea = curArea;
        }

        return maxArea;
    }
}
