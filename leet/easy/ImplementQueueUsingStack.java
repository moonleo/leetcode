package leet.easy;

import java.util.Stack;

/**
 * No.232 Implement Queue using Stacks 
 *
 */
public class ImplementQueueUsingStack {
	Stack<Integer> leftStack = new Stack<Integer>();
    Stack<Integer> rightStack = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        leftStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(rightStack.empty()) {
            while(!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
        }
        rightStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(rightStack.empty()) {
            while(!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return leftStack.empty()&&rightStack.empty();
    }
}
