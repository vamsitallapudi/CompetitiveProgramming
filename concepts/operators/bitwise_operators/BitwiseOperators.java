public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 8; //   Binary -> 1000
        // Left shift demo
        int b  = a << 3; 
        // Left shift By 1 -> 10000 -> 16
        // Left Shift by 1 -> 100000 -> 32
        // Left shift by 1 -> 1000000 -> 64
        System.out.println(b); // 64
        int c = a >> 3; // 010 --> Right shift by 1
        // Right shift by 1 -> 100 -> 4
        // Right Shift by 1 -> 10 -> 2
        // Right Shift by 1 -> 1 -> 1
        System.out.println(c); // 1
    }
}
