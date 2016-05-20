/**
 * 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * empty() -- Return whether the stack is empty.
**/

class MyStack {
    private LinkedList<Integer> s = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        LinkedList<Integer> temp = new LinkedList<Integer>();
        while (this.s.peekFirst() != null) {
            temp.add(s.remove());
        }
        s.add(x);
        while (temp.peekFirst() != null) {
            s.add(temp.remove());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        s.remove();
    }

    // Get the top element.
    public int top() {
        return s.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (s.peekFirst() == null);
    }
}
