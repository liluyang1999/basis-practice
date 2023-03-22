package grammar.nowcoder;

public class Java9 {

    public static void main(String[] args) {
        long number = 9;
        long sum = 0;
        while (number <= 9999999999L) {
            sum = sum + number;
            number = number * 10 + 9;
        }
        System.out.println(sum);
    }

}
