package algo.code.src.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        /*
        one 队列导入到 two 队列，剩下最后一个，弹出
        */
        public Queue<T> queueOne;
        public Queue<T> queueTwo;

        public TwoQueueStack() {
            queueOne = new LinkedList<>();
            queueTwo = new LinkedList<>();
        }

        public void push(T value) {
            queueOne.offer(value);
        }

        public T poll() {
            while (queueOne.size() > 1) {
                queueTwo.offer(queueOne.poll());
            }
            T res = queueOne.poll();
            Queue<T> tmp = queueOne;
            queueOne = queueTwo;
            queueTwo = tmp;
            return res;
        }

        public T peek() {
            while (queueOne.size() > 1) {
                queueTwo.offer(queueOne.poll());
            }
            T res = queueOne.peek();
            queueTwo.offer(queueOne.poll());
            Queue<T> tmp = queueOne;
            queueOne = queueTwo;
            queueTwo = tmp;
            return res;
        }
    }

    public static void main(String[] args) {
        TwoQueueStack<String> stack = new TwoQueueStack<>();
        stack.peek();
        stack.push("123");
        stack.push("456");
        stack.push("789");
        stack.peek();
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
    }
}
