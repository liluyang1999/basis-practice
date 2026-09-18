package grammar.nowcoder;

import java.util.Scanner;

public class Java36 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        try {
            String[] parts = input.trim().split("\\s+");
            if (parts.length != 6) throw new IllegalArgumentException();
            int[] values = java.util.Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
            java.time.LocalDateTime date = java.time.LocalDateTime.of(values[0], values[1], values[2], values[3], values[4], values[5]);
            java.time.ZonedDateTime beijing = date.atZone(java.time.ZoneId.of("Asia/Shanghai"));
            java.time.ZonedDateTime newYork = beijing.withZoneSameInstant(java.time.ZoneId.of("America/New_York"));
            java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
            System.out.println("北京时间为：" + beijing.format(format));
            System.out.println("纽约时间为：" + newYork.format(format));
        } catch (java.time.DateTimeException | IllegalArgumentException error) {
            System.out.println("您输入的数据不合理");
        }
    }
}
