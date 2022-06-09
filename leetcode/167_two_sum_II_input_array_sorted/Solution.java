import java.util.*;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            Integer otherPos = map.get(target - numbers[i]);
            if (otherPos != null) {
                sol[0] = i + 1;
                sol[1] = otherPos + 1;
                return sol;
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] sol = new Solution().twoSum(new int[] { -1, 0 }, -1);
        System.out.println(sol[0] + " " + sol[1]);
    }
}