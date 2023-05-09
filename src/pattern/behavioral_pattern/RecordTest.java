package pattern.behavioral_pattern;

record RecordTest(int var1, String var2) {

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
