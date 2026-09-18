package pattern.behavioral_pattern;

public final class BehavioralTest {
    public static void main(String[] args) {
        Command.Light light = new Command.Light();
        Command.Invoker invoker = new Command.Invoker();
        Command.Action turnOn = Command.switchTo(light, true);
        invoker.execute(turnOn); invoker.execute(Command.switchTo(light, false)); invoker.execute(turnOn);
        require(light.isOn()); require(invoker.undo() && !light.isOn());
        require(invoker.undo() && light.isOn()); require(invoker.undo() && !light.isOn());
        require(!invoker.undo());
        var chain = new ChainOfResponsibility.Approver("team", 100, new ChainOfResponsibility.Approver("department", 1000, null));
        require(chain.approve(100).orElseThrow().equals("team"));
        require(chain.approve(101).orElseThrow().equals("department"));
        require(chain.approve(1001).isEmpty());
        try { chain.approve(-1); throw new AssertionError(); } catch (IllegalArgumentException expected) { }
        require(new RecordTest(1, "a").equals(new RecordTest(1, "a")));
        System.out.println("BehavioralTest: command undo, chain boundaries and record values passed");
    }
    private static void require(boolean condition) { if (!condition) throw new AssertionError(); }
}
