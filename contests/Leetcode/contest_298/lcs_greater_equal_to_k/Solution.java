import java.util.Arrays;

public class Solution {
    String[] memo;
    String s;
    int k;

    public int longestSubsequence(String s, int k) {
        int pow = 1, cnt = 0, val = 0;
        for (int i = s.length() - 1; i >= 0 && cnt + pow < =k; i++) {
            if(s.charAt(i) == '1') {
                ++cnt;
            }
        }
    }

    public static void main(String[] args) {
        int sol = new Solution().longestSubsequence("1001010", 5);
        System.out.println(sol);
    }
}
