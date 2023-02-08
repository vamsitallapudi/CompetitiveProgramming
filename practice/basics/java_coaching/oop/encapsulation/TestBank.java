package oop.encapsulation;

public class TestBank {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.setAccNumber(1234);
        System.out.println(b.getAccNumber());
        b.setAccNumber(2345);
        System.out.println(b.getAccNumber());
    }
}
