public class GlobalVariable {
    int x = 10; // global variable

    public static void main(String[] args) {
        GlobalVariable g = new GlobalVariable();
        g.m();
        g.y();
    }

    public void m() {
        int c = 20; // local variable
        // which belongs only to the method where it is declared
        System.out.println(c); // 20
        System.out.println(x); // 10
        x = 1;
    }

    public void y() {
        System.out.println(c);
    }
}
