public class Fibonacci {

    // program to print fibonacci of a given number

    public int fibo(int n) {
        return recHelper(n);
    }

    public int recHelper(int n) {
        if (n <= 1) {
            return n;
        }
        return recHelper(n - 1) + recHelper(n - 2);
    }

    public static void main(String[] args) {
        int ans = new Fibonacci().fibo(6);
        System.out.println(ans);
    }

}
