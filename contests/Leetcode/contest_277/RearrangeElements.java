public class RearrangeElements {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int[] sol = new int[n];
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];
        for (int num : nums) {
            if (num > 0) {
                pos[i] = num;
                i++;
            } else {
                neg[j] = num;
                j++;
            }
        }
        i = 0;
        j = 0;
        int index = 0;
        boolean posi = true;
        while (index < n) {
            if (posi) {
                sol[index] = pos[i];
                i++;
                posi = false;
            } else {
                sol[index] = neg[j];
                j++;
                posi = true;
            }
            index++;
        }
        return sol;
    }

    public static void main(String[] args) {
        RearrangeElements s = new RearrangeElements();
        int[] a = new int[] { 3, 1, -2, -5, 2, -4 };
        int[] sol = s.rearrangeArray(a);
        System.out.println("ANS -> ");
        for (int i : sol) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("-------");
    }
}
