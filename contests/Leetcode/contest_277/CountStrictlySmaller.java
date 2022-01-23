import java.util.Arrays;

public class CountStrictlySmaller {

    public int countElements(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int i = 1, j = n - 2, count = 0;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] > nums[0] && nums[j] < nums[n - 1]) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        CountStrictlySmaller smaller = new CountStrictlySmaller();
        System.out.println(smaller.countElements(new int[] { 1, 2, 3, 4 }));
    }
}