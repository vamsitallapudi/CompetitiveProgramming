package interfaces;

public class ShapeEg {
    public static void main(String[] args) {
        Shape s = getShape(3);
        System.out.println(s.area(3, 4));
        s.name();
        Shape.color();
    }

    public static Shape getShape(int i) {
        if (i == 1) {
            return new Circle();
        } else if (i == 2) {
            return new Rect();
        } else {
            return new Square();
        }
    }
}
