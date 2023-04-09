package grammar.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Java44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Java44Customer customer1 = new Java44Customer("小明",scanner.nextInt());
        Java44Customer customer2 = new Java44Customer("小军",scanner.nextInt());
        Java44Customer customer3 = new Java44Customer("小红",scanner.nextInt());
        List<Java44Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        //write your code here......
//        customers = customers.stream().sorted().collect(Collectors.toList());
        Collections.sort(customers);

        System.out.println(customers);

    }
}

class Java44Customer implements Comparable<Java44Customer>{

    private String name;

    private int consumption;

    public Java44Customer(String name, int consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                '}';
    }

    //write your code here......
    @Override
    public int compareTo(Java44Customer compared) {
        return compared.consumption - this.consumption;
    }

}
