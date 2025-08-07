package RecursionPatternWise.GetAStrongHold;

import java.util.Stack;

public class ReverseStack {
    public void reverseStack(Stack<Integer> st) {
        if(st.empty())
            return;
        int top = st.pop();
        reverseStack(st);
        insertInStack(st, top);
    }

    public void insertInStack(Stack<Integer> st, int element){
        if(st.empty()){
            st.push(element);
            return;
        }
        int top = st.pop();
        insertInStack(st, element);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        ReverseStack sol = new ReverseStack();
        sol.reverseStack(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}