package interfaces;

public class Square implements Shape {

    @Override
    public int area(int a, int b) {
        return a * a;
    }

    @Override
    public void name() {
        System.out.println("Square");
    }

    public void hello() {
        System.out.println("hello");
    }

}
