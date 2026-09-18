package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Two-pass pairing min-heap with owned, live decrease-key handles. Not thread safe. */
public class PairingHeap<T extends Comparable<? super T>> {
    public static final class Node<T extends Comparable<? super T>> {
        private T key;
        private Node<T> previous, child, sibling;
        private PairingHeap<T> owner;

        public Node(T key) { this.key = Objects.requireNonNull(key); }
        public T getKey() { return key; }
        @Override public String toString() { return String.valueOf(key); }
    }

    private Node<T> root;
    private int size;

    public Node<T> insert(Node<T> node) {
        Objects.requireNonNull(node);
        if (node.owner != null) throw new IllegalArgumentException("handle already belongs to a heap");
        node.owner = this;
        root = link(root, node);
        size++;
        return node;
    }

    public Node<T> insert(T key) { return insert(new Node<>(key)); }

    public void updateKey(Node<T> node, T key) {
        Objects.requireNonNull(node);
        Objects.requireNonNull(key);
        if (node.owner != this) throw new IllegalArgumentException("foreign or extracted handle");
        if (node.key.compareTo(key) < 0) throw new IllegalArgumentException("key must not increase");
        node.key = key;
        if (node == root) return;
        Node<T> previous = node.previous;
        if (previous.child == node) previous.child = node.sibling;
        else previous.sibling = node.sibling;
        if (node.sibling != null) node.sibling.previous = previous;
        node.previous = null;
        node.sibling = null;
        root = link(root, node);
    }

    /** The legacy node-based merge accepts a detached singleton, never another heap's live root. */
    public void merge(Node<T> rhs) { if (rhs != null) insert(rhs); }
    public Node<T> findMin() { return root; }
    public int size() { return size; }
    public boolean isEmpty() { return root == null; }

    public Node<T> extractMin() {
        if (root == null) return null;
        Node<T> removed = root;
        List<Node<T>> pairs = new ArrayList<>();
        Node<T> cursor = removed.child;
        while (cursor != null) {
            Node<T> first = cursor;
            Node<T> second = first.sibling;
            cursor = second == null ? null : second.sibling;
            first.previous = null;
            first.sibling = null;
            if (second != null) { second.previous = null; second.sibling = null; }
            pairs.add(link(first, second));
        }
        root = null;
        for (int i = pairs.size() - 1; i >= 0; i--) root = link(pairs.get(i), root);
        removed.child = null;
        removed.previous = null;
        removed.sibling = null;
        removed.owner = null;
        size--;
        return removed;
    }

    private Node<T> link(Node<T> a, Node<T> b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.key.compareTo(b.key) > 0) { Node<T> temp = a; a = b; b = temp; }
        b.previous = a;
        b.sibling = a.child;
        if (a.child != null) a.child.previous = b;
        a.child = b;
        return a;
    }

    public void print() {
        System.out.println("Pairing Heap (size=" + size + ")");
        if (root == null) return;
        // Iterative traversal avoids a stack overflow on a deep teaching example.
        List<Node<T>> pending = new ArrayList<>();
        pending.add(root);
        while (!pending.isEmpty()) {
            Node<T> node = pending.remove(pending.size() - 1);
            System.out.println(node.key);
            for (Node<T> child = node.child; child != null; child = child.sibling) pending.add(child);
        }
    }

    public static void main(String[] args) {
        PairingHeap<Integer> heap = new PairingHeap<>();
        heap.insert(3); Node<Integer> handle = heap.insert(8); heap.insert(1);
        heap.updateKey(handle, 0);
        while (!heap.isEmpty()) System.out.println(heap.extractMin());
    }
}
