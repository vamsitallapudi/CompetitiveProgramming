import java.util.*;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max = 0;
        Arrays.sort(boxTypes, (i, j) -> j[1] - i[1]);
        int i = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            int[] b = boxTypes[i];
            if (b[0] > truckSize) {
                max += truckSize * b[1];
                truckSize = 0;
            } else {
                truckSize -= b[0];
                max += b[0] * b[1];
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } };
        int truckSize = 4;
        int max = new Solution().maximumUnits(boxTypes, truckSize);
        System.out.println(max);
    }
}
