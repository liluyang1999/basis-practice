package pattern.creational_pattern;

/** Related products are supplied by the same family factory. */
public class AbstractFactory {
    public interface Button { String label(); }
    public interface Checkbox { String label(); }
    public interface ThemeFactory { Button button(); Checkbox checkbox(); }
    public static final class LightFactory implements ThemeFactory {
        @Override public Button button() { return () -> "light button"; }
        @Override public Checkbox checkbox() { return () -> "light checkbox"; }
    }
    public static final class DarkFactory implements ThemeFactory {
        @Override public Button button() { return () -> "dark button"; }
        @Override public Checkbox checkbox() { return () -> "dark checkbox"; }
    }
    public static String render(ThemeFactory factory) {
        java.util.Objects.requireNonNull(factory);
        return factory.button().label() + " / " + factory.checkbox().label();
    }
    public static void main(String[] args) {
        System.out.println(render(new LightFactory()));
        System.out.println(render(new DarkFactory()));
    }
}
