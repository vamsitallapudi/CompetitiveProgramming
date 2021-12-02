class HouseRobberUsingDP {

    public static void main(String[] args) {
        HouseRobberUsingDP dp = new HouseRobberUsingDP();
        System.out.println(dp.rob(new int[] { 1, 2, 3, 1 }));
    }

    public int rob(int[] nums) {
        int size = nums.length;

        if (size == 0) {
            return 0;
        }
        int[] maxRobbedAmount = new int[nums.length + 1];
        maxRobbedAmount[size] = 0;
        maxRobbedAmount[size - 1] = nums[size - 1];

        for (int i = size - 2; i >= 0; i--) {
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }
        return maxRobbedAmount[0];
    }
}