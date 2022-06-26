public class MySolution {

    // Working only for 71 out of 76 test cases

    int[] memo;

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        memo = new int[heights.length];
        Arrays.fill(memo, -1);
        return rec(0, heights, bricks, ladders);
    }

    private int rec(int i, int[] h, int b, int l) {
        if (memo[i] != -1) {
            return memo[i];
        }
        if (i == h.length - 1) {
            return i;
        }
        if (b <= 0 && l <= 0 && h[i + 1] > h[i]) {
            return i;
        }
        if (h[i + 1] < h[i]) {
            return rec(i + 1, h, b, l);
        }
        int diff = h[i + 1] - h[i];
        if (l == 0 && b < diff) {
            return i;
        }
        // option 1 -> use ladder
        int op1 = 0;
        if (l > 0) {
            op1 = rec(i + 1, h, b, l - 1);
        }
        // option 2 -> use bricks
        int op2 = 0;
        if (b >= diff) {
            op2 = rec(i + 1, h, b - diff, l);
        }
        memo[i] = Math.max(op1, op2);
        return memo[i];
    }
}
