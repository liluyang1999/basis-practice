package grammar.nowcoder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Java40 {

    public static void main(String[] args) {
        Java40Guest guest1 = new Java40Guest("小明",false);
        Java40Guest guest2 = new Java40Guest("小军",false);
        Java40Guest vipGuest = new Java40Guest("小红",true);
        Deque<Java40Guest> deque = new ArrayDeque<>();
        deque.add(guest1);
        deque.add(guest2);

        //write your code here......
        if (vipGuest.vip) {
            deque.addFirst(vipGuest);
        }

        System.out.println(deque);
    }

}

class Java40Guest{

    String name;
    Boolean vip;

    @Override
    public String toString() {
        return name;
    }

    public Java40Guest(String name, Boolean vip) {
        this.name = name;
        this.vip = vip;
    }

}
