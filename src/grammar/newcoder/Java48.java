package grammar.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java48 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent = reader.readLine();
        int inputNumber = Integer.parseInt(inputContent);
        System.out.println(palindromeNumber(inputNumber));
    }

    public static Boolean palindromeNumber(int number) {
        String numStr = String.valueOf(number);
        char[] charArray = numStr.toCharArray();
        boolean flag;
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
