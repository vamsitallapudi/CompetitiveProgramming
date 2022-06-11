import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int x) {
        int l = 0;
        int curr = 0;
        int maxLength = -1;
        int n = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (currTotal, ele) -> currTotal + ele);
        for (int r = 0; r < n; r++) {
            curr += nums[r];
            while (curr > sum - x && l <= r) {
                curr -= nums[l];
                l++;
            }
            if (curr == sum - x) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength != -1 ? n - maxLength : -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 20, 1, 1, 3 };
        int a = new Solution().minOperations(nums, 10);
        System.out.println(a);
    }
}