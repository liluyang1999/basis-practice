package sort;

import java.util.Random;

public class TestUtil {

//    private static int[] testArr = {1,5,2,6,2,8,3,6};

    private static int[] testArr = new int[100000];

    static {
        Random random = new Random();
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = random.nextInt(100000);
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
        String b = "joker" + "joker";
        System.out.println(a == b);
    }
}


