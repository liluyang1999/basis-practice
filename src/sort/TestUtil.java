package sort;

import java.util.Random;

public class TestUtil {

    private static int[] testArr = new int[10000];

    static {
        Random random = new Random();
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = random.nextInt(10000);
        }
    }

    public static int[] getTestArr() {
        return testArr;
    }

    public static void setTestArr(int[] testArr) {
        TestUtil.testArr = testArr;
    }

    public static void main(String[] args) {
        String str1 = "joker";
        String str2 = "joker";
        String a = str2 + str1;
        String b = str1 + str2;
        System.out.println(a == b);
        

    }

}


