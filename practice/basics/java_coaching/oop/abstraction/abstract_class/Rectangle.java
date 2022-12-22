package abstract_class;

public class Rectangle extends Shape {

    public Rectangle() {

    }

    @Override
    public int area(int l, int b) {
        return l * b;
    }

    public String hello() {
        return "Hello";
    }

}
