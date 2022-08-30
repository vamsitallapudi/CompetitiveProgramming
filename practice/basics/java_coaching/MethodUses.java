public class MethodUses {
    public static void main(String[] args) {
        int c1 = add(5, 5);
        int c2 = add(10, 50);
        System.out.println(c1);
        System.out.println(c2);
    }

    public static int add(int a, int b) {
        int gst = ((a + b) * 20) / 100;
        int pc = 5;
        int rc = 10;
        return a + b + gst + pc + rc;
    }
}
