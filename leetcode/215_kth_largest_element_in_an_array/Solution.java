import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);
        for (Integer integer : nums) {
            pq.add(integer);
        }
        while (--k > 0) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution()
                .findKthLargest(new int[] { 1, 2, 3, 4, 5, 6 }, 3));
    }
}