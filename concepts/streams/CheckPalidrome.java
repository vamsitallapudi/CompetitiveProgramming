public class CheckPalidrome {
    public static void main(String args[]) {
        int x = 121;
        int i = 0, j = 2;
        while (i <= j) {
            i += 1;
            j -= 1;
            int a = x % (i * 10 + 1);
            int b = x % (j * 10 + 1);
            if (a == b) {
                continue;
            } else {
                System.out.println("not palindrome");
            }
        }
    }
}
