public class Solution {
    String s1, s2, s3;

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return rec(0, 0, 0);
    }

    public boolean rec(int i, int j, int k) {
        // edge cases
        if (k == s3.length()) {
            return true;
        }
        if (i == s1.length() && j == s2.length()) {
            return false;
        }
        if (i == s1.length()) {
            return s2.substring(j) == s3.substring(k);
        }
        if (j == s2.length()) {
            return s1.substring(i) == s3.substring(k);
        }

        // main logic

        if (s1.charAt(i) != s2.charAt(j)) {
            if (s1.charAt(i) == s3.charAt(k)) {
                return rec(i + 1, j, k + 1);
            } else {
                return rec(i, j + 1, k + 1);
            }
        }
        return rec(i + 1, j, k + 1) || rec(i, j + 1, k + 1);
    }

    public static void main(String[] args) {
        boolean ans = new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(ans);
    }
}