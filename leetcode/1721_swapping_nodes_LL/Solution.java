import java.util.*;

public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null;
        // using two pointers
        for (ListNode t = head; t != null; t = t.next) {
            n2 = (n2 != null) ? n2.next : n2;
            if (--k == 0) {
                n1 = t;
                n2 = head;
            }
        }
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        ListNode node = s.swapNodes(n, 2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
