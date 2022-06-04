import java.util.*;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int pos = 0;
        Stack<Integer> s = new Stack<>();
        s.push(nums[pos++]);
        while (pos < nums.length) {
            while (!s.isEmpty() && nums[pos] <= s.peek()) {
                s.pop();
            }
            s.push(nums[pos++]);
        }
        return s.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
    }
}
