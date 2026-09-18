import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/** Each exercise is launched in a fresh JVM with deterministic locale and explicit stdin. */
public final class GrammarTest {
    private static int cases;
    private static int failures;

    public static void main(String[] args) throws Exception {
        expect(1, "3.9", "3");
        expect(2, "2 5", "7 3 10 2 1");
        expect(3, "-1.5", "-1");
        expect(4, "4 8", "8 4");
        expect(5, "500", "400");
        expect(6, "1.8 70", "适中");
        expect(7, "A", "优秀");
        expect(8, "abc@def.com", "邮箱格式合法");
        expect(9, "", "11111111100");
        expect(10, "1 2 0", "2");
        expect(11, "6 8", "24");
        expect(12, "100 2", "25.000 200.000");
        expect(13, "1 2 3 0", "2.00");
        expect(14, "7", "true");
        expect(15, "12345", "5");
        expect(16, "2 6 3 1 8 4", "8 1");
        expect(17, "1 2 3 4 5 6", "[1, 2, 3, 4, 5, 6]\n[6, 5, 4, 3, 2, 1]");
        expect(18, "", "5180");
        expect(19, "2 3\n-1 5", "5\n4");
        expect(20, "-1 201 18", "0\n200\n18");
        expect(21, "2 3 4", "24");
        expect(22, "8 2\n4 0", "4\nError");
        expect(23, "grammar.nowcoder.Java23First\ngrammar.nowcoder.Java23Third", "First\nThird");
        expect(24, "grammar.nowcoder.Java24Sub1\ngrammar.nowcoder.Java24Sub2", "Java24Sub1\nJava24Sub2");
        expect(25, "2 4", "2");
        expect(26, "1 9\n-3 -2", "9\n-2");
        expect(27, "2 3", "23");
        expect(28, "", "true");
        expect(29, "1234567", "1,234,567");
        expect(30, "o", "3");
        expect(31, "10", "1010");
        expect(33, "42", "3");
        expect(34, "0", "0.0\n0.0\n-Infinity\n0.0");
        StringBuilder months = new StringBuilder();
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < days.length; i++) months.append("2024年").append(i + 1).append("月：").append(days[i]).append("天\n");
        expect(35, "2024", months.toString());
        expect(36, "2024 7 1 12 0 0", "北京时间为：2024-07-01 12:00:00\n纽约时间为：2024-07-01 00:00:00");
        expect(37, "101", "分数不合法");
        expect(38, "aabb", "ab");
        expect(39, "1 2 3 4 5", "普通for循环:1 2 3 4 5 \n增强for循环:1 2 3 4 5 \n迭代器遍历:1 2 3 4 5");
        expect(40, "", "[小红, 小明, 小军]");
        expect(41, "A B C D E", "A\nE\nB\nD\nC");
        expect(42, "a1!aB b", "a:2\nB:1\nb:1");
        expect(43, "Li", "1:Amy\n2:Joe\n3:Tom\n4:Susan\n\n1:Amy\n2:Joe\n3:Tommy\n5:Li");
        expect(44, "10 30 20", "[Customer{name='小军', consumption=30}, Customer{name='小红', consumption=20}, Customer{name='小明', consumption=10}]");
        expect(45, "Ab 3!中", "英文字母2数字1空格1其他2");
        expect(46, "", "小明应该缴纳的个人所得税是：0.0\n小军应该缴纳的个人所得税是：345.0\n小红应该缴纳的个人所得税是：29920.0");
        expect(47, "A B A C", "[B, C]");
        expect(48, "121", "true");
        expect(49, "10 2", "2到10之间有3个大于2的素数");
        expect(50, "4", "1.273\n1.000");
        expect(51, "7 2 5 3 1 4 6", "1 2 3 4 5 6 7");
        expect(7, "", "未知错误");
        expect(10, "1 2 3", "3");
        expect(11, "0 5", "0");
        expect(11, "-6 8", "24");
        expect(12, "100 0", "100.000 0.000");
        expect(13, "0", "0.00");
        expect(13, "1 3", "2.00");
        expect(14, "1", "false");
        expect(15, "0", "1");
        expect(15, "-2147483648", "10");
        expect(29, "-123", "-123");
        expect(29, "+123456", "+123,456");
        expect(31, "-1", "11111111111111111111111111111111");
        expect(36, "2024 1 1 12 0 0", "北京时间为：2024-01-01 12:00:00\n纽约时间为：2023-12-31 23:00:00");
        expect(36, "2023 2 29 0 0 0", "您输入的数据不合理");
        expect(38, "😀中😀ab中", "😀中ab");
        expect(44, "-2147483648 2147483647 0", "[Customer{name='小军', consumption=2147483647}, Customer{name='小红', consumption=0}, Customer{name='小明', consumption=-2147483648}]");
        expect(47, " A  B A ", "[B]");
        if (args.length == 0) {
            expect(49, "2147483647 2147483647", "2147483647到2147483647之间有1个大于2的素数");
            reject(11, "2147483647 2");
            reject(12, "100 2.5");
            reject(23, "java.lang.String");
            reject(24, "java.lang.String");
        }
        if (failures != 0) throw new AssertionError(failures + "/" + cases + " CLI checks failed");
        System.out.println("GrammarTest: " + cases + " CLI checks passed (all 50 exercises)");
    }

    private static void expect(int exercise, String input, String expected) throws Exception {
        Result actual = run(exercise, input);
        cases++;
        if (actual.code != 0 || !actual.output.strip().equals(expected.strip())) {
            failures++;
            System.err.println("Java" + exercise + ": expected=" + expected.replace('\n', '|') + "; actual=" + actual);
        }
    }

    private static void reject(int exercise, String input) throws Exception {
        cases++;
        if (run(exercise, input).code == 0) { failures++; System.err.println("Java" + exercise + " accepted invalid input"); }
    }

    private record Result(int code, String output) { }

    private static Result run(int exercise, String input) throws Exception {
        String java = Path.of(System.getProperty("java.home"), "bin", "java").toString();
        Process process = new ProcessBuilder(java, "-Dfile.encoding=UTF-8", "-Dstdout.encoding=UTF-8",
                "-Duser.language=en", "-Duser.country=US", "-Duser.timezone=UTC", "-cp",
                System.getProperty("java.class.path"), "grammar.nowcoder.Java" + exercise).redirectErrorStream(true).start();
        try {
            process.getOutputStream().write((input + "\n").getBytes(StandardCharsets.UTF_8));
            process.getOutputStream().close();
            if (!process.waitFor(3, TimeUnit.SECONDS)) {
                process.destroyForcibly().waitFor();
                return new Result(-1, "timeout");
            }
            return new Result(process.exitValue(), new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8).replace("\r\n", "\n"));
        } finally {
            if (process.isAlive()) process.destroyForcibly().waitFor();
            process.getInputStream().close();
            process.getErrorStream().close();
        }
    }
}
