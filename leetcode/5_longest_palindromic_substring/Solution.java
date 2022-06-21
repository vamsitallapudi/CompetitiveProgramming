public class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (s.length() <= 1) {
            return s;
        }
        String ans = s.substring(0, 1);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int j = s.length() - 1;
            while (j > i) {
                if (sb.charAt(i) == sb.charAt(j)) {
                    String ss = sb.substring(i, j + 1);
                    StringBuilder ssb = new StringBuilder(ss);
                    if (ss.equals(ssb.reverse().toString())) {
                        if (ssb.length() > ans.length())
                            ans = ssb.toString();
                        i++;
                    }
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = new Solution().longestPalindrome("aacabdkacaa");
        System.out.println(a);
    }
}
