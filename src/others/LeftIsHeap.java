package others;

import java.util.NoSuchElementException;
import java.util.Objects;

/** A leftist min-heap; merge transfers ownership and empties its argument. Not thread safe. */
public class LeftIsHeap<T extends Comparable<? super T>> {
    private Node<T> root;
    private int size;

    public void merge(LeftIsHeap<T> rhs) {
        Objects.requireNonNull(rhs);
        if (rhs == this) return;
        root = mergeNodes(root, rhs.root);
        size += rhs.size;
        rhs.makeEmpty();
    }

    public void insert(T value) {
        root = mergeNodes(root, new Node<>(Objects.requireNonNull(value)));
        size++;
    }

    public T findMin() {
        if (isEmpty()) throw new NoSuchElementException("empty heap");
        return root.value;
    }

    public T deleteMin() {
        T minimum = findMin();
        root = mergeNodes(root.left, root.right);
        size--;
        return minimum;
    }

    public void makeEmpty() { root = null; size = 0; }
    public boolean isEmpty() { return root == null; }
    public int size() { return size; }

    private Node<T> mergeNodes(Node<T> a, Node<T> b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.value.compareTo(b.value) > 0) { Node<T> temp = a; a = b; b = temp; }
        a.right = mergeNodes(a.right, b);
        if (rank(a.left) < rank(a.right)) {
            Node<T> temp = a.left; a.left = a.right; a.right = temp;
        }
        a.rank = rank(a.right) + 1;
        return a;
    }

    private static int rank(Node<?> node) { return node == null ? -1 : node.rank; }

    private static final class Node<T> {
        private final T value;
        private Node<T> left, right;
        private int rank;
        private Node(T value) { this.value = value; }
    }
}
