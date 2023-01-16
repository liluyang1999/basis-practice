import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java45 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent = reader.readLine();
        int alphaCount, numCount, blankCount, otherCount;
        alphaCount = numCount = blankCount = otherCount = 0;
        for (char index : inputContent.toCharArray()) {
            if ((index >= 65 && index <= 90)
                    || (index >= 97 && index <= 122)) {
                alphaCount++;
            } else if (index >= 48 && index <= 57) {
                numCount++;
            } else if (index == ' ') {
                blankCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("英文字母" + alphaCount + "数字" + numCount + "空格"
                + blankCount + "其他" + otherCount);
    }

}
