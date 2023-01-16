import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Java35 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent = reader.readLine();
        int year = Integer.parseInt(inputContent);
        Calendar calendar = Calendar.getInstance();
        for (int month = 1; month <= 12; month++) {
            calendar.set(year, month, 0);
            System.out.println(year + "年" + month + "月：" +
                    calendar.get(Calendar.DAY_OF_MONTH) + "天");
        }
    }

}
