public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int n = s.length();
        int left = 0, right = 0;
        int currMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left += 1;
            } else {
                right += 1;
                if (right - left == 0) {

                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()(())"));
    }
}
