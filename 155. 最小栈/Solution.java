import java.util.Arrays;

class MinStack {
    private int[] stack;

    private int pointer;

    private int size;

    private int minIndex;

    public MinStack() {
        size = 10;
        stack = new int[size];
        pointer = 0;
        minIndex = 0;
    }

    public void push(int val) {
        if (pointer >= size){
            size *= 2;
            int[] newStack = new int[size];

            System.arraycopy(stack, 0, newStack, 0, stack.length);

            stack = newStack;
        }

        stack[pointer++] = val;

        if (val < stack[minIndex]){
            minIndex = pointer - 1;
        }
    }

    public void pop() {
        pointer--;

        if (minIndex >= pointer){
            minIndex = 0;
            for (int i = 0; i < pointer; ++i) {
                if (stack[i] < stack[minIndex]){
                    minIndex = i;
                }
            }
        }
    }

    public int top() {
        return stack[pointer-1];
    }

    public int getMin() {
        return stack[minIndex];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */