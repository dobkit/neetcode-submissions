class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> rpnStack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int right = rpnStack.pop();
                int left = rpnStack.pop();
                rpnStack.push(calculate(left, right, token));
            } else rpnStack.push(Integer.parseInt(token));
        }
        return rpnStack.pop();
    }

    public boolean isOperator(String s) {
        return "+-*/".contains(s);
    }

    public int calculate(int left, int right, String op) {
        switch(op) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
            default: return 0;
        }
    }
}
