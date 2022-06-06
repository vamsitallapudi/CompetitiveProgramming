public class BruteforceSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode b = headB;
            while (b != null) {
                if (headA == b) {
                    return headA;
                }
            }
            headA = headA.next;
        }
        return null;
    }
}

private class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
