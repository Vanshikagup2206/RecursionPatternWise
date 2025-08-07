package RecursionPatternWise.GetAStrongHold;

import java.util.Stack;

public class SortStack {

    // Function to sort the stack
    public void sortStack(Stack<Integer> st) {
        // Base case: if stack is empty, nothing to sort
        if (st.isEmpty()) {
            return;
        }

        // Step 1: Remove the top element
        int top = st.pop();

        // Step 2: Sort the remaining stack recursively
        sortStack(st);

        // Step 3: Insert the top element back at the right place
        insertInSortedOrder(st, top);
    }

    // Helper function to insert element into sorted stack (descending)
    private void insertInSortedOrder(Stack<Integer> st, int element) {
        // If stack is empty OR top element is smaller than current element
        // push the element directly
        if (st.isEmpty() || st.peek() < element) {
            st.push(element);
            return;
        }

        // Otherwise, pop the top element and recursively insert
        int top = st.pop();
        insertInSortedOrder(st, element);

        // Push the top back after inserting element
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        SortStack sol = new SortStack();
        sol.sortStack(st);

        System.out.println("Stack in descending order (top is greatest):");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}