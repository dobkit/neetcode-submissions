class Solution {
    public boolean isPalindrome(String s) {
        int size = s.length();
        if (size == 0) return true;

        int leftPointer = 0;
        int rightPointer = size - 1;
        while (leftPointer < rightPointer) {
            if(!Character.isLetterOrDigit(s.charAt(leftPointer))) {
                leftPointer++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(rightPointer))) {
                rightPointer--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))) return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
