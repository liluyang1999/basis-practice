package pattern.behavioral_pattern;

import java.util.Objects;
import java.util.Optional;

/** Immutable links; the first capable approver handles a nonnegative request. */
public class ChainOfResponsibility {
    public static final class Approver {
        private final String name;
        private final int limit;
        private final Approver next;
        public Approver(String name, int limit, Approver next) {
            this.name = Objects.requireNonNull(name);
            if (limit < 0) throw new IllegalArgumentException("nonnegative limit required");
            this.limit = limit;
            this.next = next;
        }
        public Optional<String> approve(int amount) {
            if (amount < 0) throw new IllegalArgumentException("nonnegative amount required");
            for (Approver current = this; current != null; current = current.next) {
                if (amount <= current.limit) return Optional.of(current.name);
            }
            return Optional.empty();
        }
    }
    public static void main(String[] args) {
        Approver chain = new Approver("team", 100, new Approver("department", 1000, null));
        System.out.println(chain.approve(50).orElse("unhandled"));
        System.out.println(chain.approve(500).orElse("unhandled"));
        System.out.println(chain.approve(5000).orElse("unhandled"));
    }
}
