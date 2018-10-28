package leet.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.225 Implement Stack using Queues 
 *
 */
public class ImplementStackUsingQueue {
	Deque<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        adjustQueue(queue.size() - 1);
        queue.poll();
    }

    // Get the top element.
    public int top() {
        adjustQueue(queue.size() - 1);
        int top = queue.peek();
        queue.offer(queue.poll());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return 0 == queue.size();
    }
    
    void adjustQueue(int size) {
        int i=0;
        while(i < size) {
            queue.offer(queue.poll());
            i ++;
        }
    }
}
