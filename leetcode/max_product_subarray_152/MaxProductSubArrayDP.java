package leetcode.max_product_subarray_152;

public class MaxProductSubArrayDP {

    int result = 0;

    public static void main(String[] args) {
        MaxProductSubArrayDP sol = new MaxProductSubArrayDP();
        System.out.println(sol.maxProduct(new int[] { -4, -3, -2 }));

    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minTillNow = nums[0], maxTillNow = nums[0];
        int result = maxTillNow;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(maxTillNow * curr, minTillNow * curr));
            minTillNow = Math.min(curr, Math.min(maxTillNow * curr, minTillNow * curr));
            maxTillNow = temp;
            result = Math.max(result, maxTillNow);
        }
        return result;
    }
}
