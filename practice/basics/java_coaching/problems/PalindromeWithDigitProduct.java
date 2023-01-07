package problems;

// Write a program to print the palindrome numbers from 1 to 300
//  whose digits product is less than 99
public class PalindromeWithDigitProduct {
    public static void main(String[] args) {
        for (int i = 1; i <= 3000; i++) {
            int n = i;
            int temp = n;
            int rev = 0;
            while (temp != 0) {
                int rem = temp % 10;
                rev = rev * 10 + rem;
                temp = temp / 10;
            }
            if (n == rev) {
                // this is a palindrome
                // check if digit product is less than 99
                int dp = 1;
                while (n != 0) {
                    int rem = n % 10;
                    dp = dp * rem;
                    n = n / 10;
                }
                if (dp < 999) {
                    System.out.println(rev);
                }
            }
        }
    }
}
