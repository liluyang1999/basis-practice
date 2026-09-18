package pattern.structural_pattern;

// Participant classes intentionally remain colocated with the original lesson.
@SuppressWarnings("auxiliaryclass")
public final class StructuralTest {
    public static void main(String[] args) {
        Employee parent = new Employee("a", "a", 1), child = new Employee("b", "b", 2);
        parent.add(child);
        var snapshot = parent.getSubordinates();
        try { child.add(parent); throw new AssertionError(); } catch (IllegalArgumentException expected) { }
        try { parent.add(child); throw new AssertionError(); } catch (IllegalArgumentException expected) { }
        try { snapshot.clear(); throw new AssertionError(); } catch (UnsupportedOperationException expected) { }
        parent.remove(child);
        if (snapshot.size() != 1 || !parent.getSubordinates().isEmpty()) throw new AssertionError();
        double[] radius = {0};
        CircleShape shape = new CircleShape(10, 20, 30, (x, y, r) -> radius[0] = r);
        shape.resizeByPercentage(2.5); shape.draw();
        if (radius[0] != 75) throw new AssertionError();
        System.out.println("StructuralTest: hierarchy invariants, snapshots and bridge delegation passed");
    }
}
