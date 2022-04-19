import java.util.*;

// My first approach to this problem
// It executed but there's another better solution which 
// we implemented in Solution.java

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

public class SolutionOther {
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> nodes = new ArrayList<>();
        if (head == null)
            return head;
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int temp = nodes.get(k - 1);
        nodes.set(k - 1, nodes.get(nodes.size() - (k - 1) - 1));
        nodes.set(nodes.size() - (k - 1) - 1, temp);
        ListNode ans = new ListNode(); // -> Dummy node
        ListNode n = ans;
        for (Integer node : nodes) {
            n.next = new ListNode(node);
            n = n.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        SolutionOther s = new SolutionOther();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        ListNode node = s.swapNodes(n, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}