import java.util.Deque;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(9);
        stack.push(8);
        stack.push(3);
        System.out.println(stack.peek());
    }
}
