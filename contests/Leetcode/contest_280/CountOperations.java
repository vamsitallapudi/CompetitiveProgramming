public class CountOperations {
    public int countOperations(int num1, int num2) {
        int op = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            op += 1;
        }
        return op;
    }
}
