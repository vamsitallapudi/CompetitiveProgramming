import java.util.*;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            curr = heights[i];
            next = heights[i + 1];
            diff = next - curr;
            if (diff <= 0)
                continue;
            if (ladders > 0) {
                pq.add(diff);
                ladders--;
                continue;
            }
            // No ladders remaining
            if (diff <= pq.peek()) {
                bricks -= diff;
            } else {
                int val = pq.poll();
                pq.add(diff);
                bricks -= val;
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}
