package pattern.behavioral_pattern;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** Commands return their inverse action; the invoker owns a LIFO undo history. */
public class Command {
    public static final class Light {
        private boolean on;
        public boolean isOn() { return on; }
    }
    @FunctionalInterface public interface Action { Runnable execute(); }
    public static Action switchTo(Light light, boolean on) {
        Objects.requireNonNull(light);
        return () -> {
            boolean previous = light.on;
            light.on = on;
            return () -> light.on = previous;
        };
    }
    public static final class Invoker {
        private final Deque<Runnable> history = new ArrayDeque<>();
        public void execute(Action action) { history.push(Objects.requireNonNull(action).execute()); }
        public boolean undo() {
            if (history.isEmpty()) return false;
            history.peek().run();
            history.pop();
            return true;
        }
    }
    public static void main(String[] args) {
        Light light = new Light();
        Invoker invoker = new Invoker();
        invoker.execute(switchTo(light, true));
        System.out.println(light.isOn());
        invoker.undo();
        System.out.println(light.isOn());
    }
}
