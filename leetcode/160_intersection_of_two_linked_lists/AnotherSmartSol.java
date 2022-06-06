public class AnotherSmartSol {
    // Faster than 99 percent solution
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (headA != headB) {
            headA = headA == null ? b : headA.next;
            headB = headB == null ? a : headB.next;
        }
        return headA;
    }
}
