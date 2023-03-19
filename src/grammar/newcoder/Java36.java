package grammar.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Java36 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputContent = reader.readLine();
        String[] inputArray = inputContent.split(" ");
        if (inputArray.length != 6) {
            System.out.println("您输入的数据不合理");
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = inputArray[0] + "-" + inputArray[1] + "-" + inputArray[2] + " "
                                + inputArray[3] + ":" + inputArray[4] + ":" + inputArray[5];
            Date beijingDate = dateFormat.parse(dateStr);
            Date newyorkDate = new Date(beijingDate.getTime() - 12 * 60 * 60 * 1000);
            System.out.println("北京时间为：" + dateFormat.format(beijingDate));
            System.out.println("纽约时间为：" + dateFormat.format(newyorkDate));
        }
    }

}
