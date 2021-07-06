import java.util.*;
import javafx.util.Pair;

public class FindLeavesOfBinaryTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Pair<Integer, Integer>> pairs;

    public List<List<Integer>> findLeaves(TreeNode root) {

        // Using DFS with Height Sorting

        pairs = new ArrayList<>();
        getHeight(root);

        Collections.sort(pairs, Comparator.comparing(it -> it.getKey()));
        List<List<Integer>> sol = new ArrayList<>();

        int n = pairs.size(), height = 0, i = 0;

        while (i < n) {
            List<Integer> currHeightItems = new ArrayList<>();
            while (i < n && pairs.get(i).getKey() == height) {
                currHeightItems.add(pairs.get(i).getValue());
                i++;
            }
            sol.add(currHeightItems);
            height++;
        }

        return sol;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int currHeight = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        pairs.add(new Pair<Integer, Integer>(currHeight, node.val));
        return currHeight;
    }

    public static void main(String[] args) {

        FindLeavesOfBinaryTree sol = new FindLeavesOfBinaryTree();
        FindLeavesOfBinaryTree.TreeNode node4 = sol.new TreeNode(4);
        FindLeavesOfBinaryTree.TreeNode node5 = sol.new TreeNode(5);
        FindLeavesOfBinaryTree.TreeNode node3 = sol.new TreeNode(3);
        FindLeavesOfBinaryTree.TreeNode node2 = sol.new TreeNode(2, node4, node5);
        FindLeavesOfBinaryTree.TreeNode node1 = sol.new TreeNode(1, node2, node3);
        List<List<Integer>> myList = sol.findLeaves(node1);
        for (List<Integer> i : myList) {
            System.out.println(i);
        }
    }
}
