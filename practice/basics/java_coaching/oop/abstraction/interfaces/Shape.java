package interfaces;

public interface Shape {
    int area(int a, int b);

    default void name() {
        System.out.println("Generic shape");
    }

    static void color() {
        System.out.println("Blue");
    }

}
