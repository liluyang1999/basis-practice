package others;

import java.util.Objects;

/** Rotation exercise only; callers must assign the returned subtree root. */
public class TreapNode {
    private final int elem;
    private final int priority;
    TreapNode lchild;
    TreapNode rchild;

    public TreapNode(int elem, int priority) { this.elem = elem; this.priority = priority; }
    public int getElem() { return elem; }
    public int getPriority() { return priority; }

    public TreapNode left_rotate(TreapNode node) {
        Objects.requireNonNull(node);
        if (node.rchild == null) throw new IllegalArgumentException("right child required");
        TreapNode next = node.rchild;
        node.rchild = next.lchild;
        next.lchild = node;
        return next;
    }

    public TreapNode right_rotate(TreapNode node) {
        Objects.requireNonNull(node);
        if (node.lchild == null) throw new IllegalArgumentException("left child required");
        TreapNode next = node.lchild;
        node.lchild = next.rchild;
        next.rchild = node;
        return next;
    }
}
