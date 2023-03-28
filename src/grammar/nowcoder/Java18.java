package grammar.nowcoder;

public class Java18 {

    public static void main(String[] args) {
        int[][]  arr = {{11,33,55},{22,44,66,88},{131,214,315,146},{928,827,726,625},{424,525}};
        int sum = add(arr);
        System.out.println(sum);
    }

    public static int add(int[][] arr) {
        int sum=0;

        //write your code here......
        for (int[] eachArr : arr) {
            for (int each : eachArr) {
                sum = sum + each;
            }
        }

        return sum;
    }

}
