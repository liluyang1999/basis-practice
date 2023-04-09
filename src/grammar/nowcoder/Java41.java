package grammar.nowcoder;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Java41 {

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String name = scanner.next();
            // 初始化队列中的数据
            deque.offerLast(name);
        }

        // write your code here......
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                System.out.println(deque.pollFirst());
            } else {
                System.out.println(deque.pollLast());
            }
        }
    }

}
