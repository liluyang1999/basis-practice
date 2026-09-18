package pattern.creational_pattern;

/** A creator fixes the workflow; subclasses choose which product to create. */
public class FactoryMethod {
    public interface Formatter { String format(String text); }
    public abstract static class Document {
        protected abstract Formatter createFormatter();
        public final String render(String text) {
            return createFormatter().format(java.util.Objects.requireNonNull(text));
        }
    }
    public static final class PlainDocument extends Document {
        @Override protected Formatter createFormatter() { return text -> text; }
    }
    public static final class UpperDocument extends Document {
        @Override protected Formatter createFormatter() { return text -> text.toUpperCase(java.util.Locale.ROOT); }
    }
    public static void main(String[] args) {
        System.out.println(new PlainDocument().render("Hello"));
        System.out.println(new UpperDocument().render("Hello"));
    }
}
