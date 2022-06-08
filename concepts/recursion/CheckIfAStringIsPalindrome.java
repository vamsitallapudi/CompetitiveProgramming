public class CheckIfAStringIsPalindrome {
    public boolean checkPalindrome(String s) {
        return recHelper(s.toCharArray(), 0);
    }

    public boolean recHelper(char[] a, int l) {
        int r = a.length - l - 1;
        if (l >= a.length / 2) {
            return true;
        }
        if (a[l] != a[r]) {
            return false;
        } else {
            return recHelper(a, l + 1);
        }
    }

    public static void main(String[] args) {
        boolean ans = new CheckIfAStringIsPalindrome().checkPalindrome("sabas");
        System.out.println(ans);
    }
}
