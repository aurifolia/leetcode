import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No155_最小栈 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(1);
        System.out.println(queue.size());
        queue.remove(1);
        System.out.println(queue.size());
        queue.remove(1);
        System.out.println(queue.size());
    }
}

class MinStack1 {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private Stack<Integer> stack = new Stack<>();

    public MinStack1() {

    }

    public void push(int val) {
        stack.push(val);
        priorityQueue.add(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        priorityQueue.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
