public class ArraysEg {
    private static void printMyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        int[] a = new int[5];
        a[0] = 2;
        a[1] = 4;
        a[4] = 3;
        printMyArray(a);
        System.out.println("######################");

        int[] b = { 1, 2, 3, 4, 5 };
        printMyArray(b);
        System.out.println("######################");
        b[2] = 10;
        printMyArray(b);
        b[6] = 20;
    }
}
