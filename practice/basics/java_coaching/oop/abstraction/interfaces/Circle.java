package interfaces;

public class Circle implements Shape {

    @Override
    public int area(int a, int b) {
        return 3 * a * a;
    }

    @Override
    public void name() {
        System.out.println("Circle");
    }
}
