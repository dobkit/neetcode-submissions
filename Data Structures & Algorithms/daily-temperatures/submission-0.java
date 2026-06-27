class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> tempQ = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = n-1; i>=0; i--){
            while (!tempQ.isEmpty() && temperatures[tempQ.peek()] <= temperatures[i]) {
                tempQ.pop();
            }
            if (!tempQ.isEmpty()) ans[i] = tempQ.peek() - i;
            else ans[i] = 0;
            tempQ.push(i);
        }
        return ans;
    }
}
