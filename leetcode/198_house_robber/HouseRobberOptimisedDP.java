public class HouseRobberOptimisedDP {

    public static void main(String[] args) {
        HouseRobberOptimisedDP dp = new HouseRobberOptimisedDP();
        System.out.println(dp.rob(new int[] { 1, 2, 3, 1 }));
    }

    public int rob(int[] nums) {
        int size = nums.length;

        if (size == 0) {
            return 0;
        }
        int[] maxRobbedAmount = new int[nums.length + 1];
        int nextNext = 0;
        int next = nums[size - 1];

        for (int i = size - 2; i >= 0; i--) {
            int current = Math.max(next, nextNext + nums[i]);
            nextNext = next;
            next = current;
        }
        return next;
    }
}
