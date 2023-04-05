package grammar.nowcoder;

import java.util.Scanner;

public class Java20 {

    public static void main(String[] args) {
        Java20Person p = new Java20Person();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int age = scanner.nextInt();
            p.setAge(age);
            System.out.println(p.getAge());
        }
    }

}

class Java20Person {

    private int age;

    //write your code here......
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        if (age < 0) {
            return 0;
        } else
            return Math.min(age, 200);
    }

}
