package pattern.behavioral_pattern;

public record RecordTest(int var1, String var2) {
    public static void main(String[] args) {
        RecordTest value = new RecordTest(1, "record");
        System.out.println(value);
        System.out.println(value.equals(new RecordTest(1, "record")));
    }

    public void testMethod() {
        System.out.println("TEST METHOD");
    }

    public static void testStaticMethod() {
        testPrivateMethod();
        System.out.println("Test static method");
    }

    private static void testPrivateMethod() {
        System.out.println("Test private method");
    }

}
