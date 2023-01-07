package problems;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {

        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int rev = 0;
        while (temp != 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        if (n == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
        sc.close();
    }
}
