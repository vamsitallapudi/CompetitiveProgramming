import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

class MyStack {
    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.pollLast();
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}
