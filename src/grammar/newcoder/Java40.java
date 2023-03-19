package grammar.newcoder;

import java.util.ArrayDeque;
import java.util.Deque;

public class Java40 {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("小明");
        deque.addLast("小军");
        deque.addFirst("小红");
        for (String index : deque) {
            System.out.println(index);
        }
    }

}
