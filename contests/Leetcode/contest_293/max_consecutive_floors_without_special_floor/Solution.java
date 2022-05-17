public class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        Arrays.sort(special);
        for (int f : special) {
            if (f - bottom > max) {

            }
        }
        return max;
    }
}
