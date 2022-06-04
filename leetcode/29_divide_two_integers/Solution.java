class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend < Integer.MIN_VALUE) {
            dividend = Integer.MIN_VALUE;
        }
        if (dividend > Integer.MAX_VALUE) {
            dividend = Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648, -1));
    }
}