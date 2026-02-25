package main.java.mid;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min_stack;
    public MinStack() {
        stack = new ArrayDeque<>();
        min_stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty())
            min_stack.push(val);
        else{
            min_stack.push(Math.min(min_stack.peek(),val));
        }
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
