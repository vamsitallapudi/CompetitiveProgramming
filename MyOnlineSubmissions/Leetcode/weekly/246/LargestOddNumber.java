import java.util.Scanner;

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 == 1)
                return num.substring(0, i + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        LargestOddNumber sol = new LargestOddNumber();
        System.out.println(sol.largestOddNumber(num));
        sc.close();
    }
}
