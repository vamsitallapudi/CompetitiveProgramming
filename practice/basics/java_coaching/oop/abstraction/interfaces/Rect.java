package interfaces;

public class Rect implements Shape {

    @Override
    public int area(int a, int b) {
        return a * b;
    }

    @Override
    public void name() {
        System.out.println("Rectangle");
    }

}
