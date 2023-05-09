package pattern.behavioral_pattern;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        RecordTest recordTest = new RecordTest(3, "string1");
        System.out.println(recordTest.var1());
        System.out.println(recordTest.var2());
        System.out.println(recordTest.equals(new RecordTest(3, "string1")));
        System.out.println(recordTest.equals(new RecordTest(3, "string1")));
        System.out.println(recordTest);
        recordTest.testMethod();
        RecordTest.testStaticMethod();
    }

}
