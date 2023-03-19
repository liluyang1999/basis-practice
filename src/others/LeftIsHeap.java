package others;

public class LeftIsHeap<AnyType extends Comparable<? super AnyType>> {

    AnyType root;

    public LeftIsHeap() {
        root = null;
    }

    public void merge(LeftIsHeap<AnyType> rhs) {  }

    public void insert(AnyType x) {  }

    public AnyType findMin() {
        return null;
    }

    public AnyType deleteMin() { return null;}

    public void makeEmpty() {}

    public boolean isEmpty() {return true;}

    private static class Node<AnyType> {

        Node(AnyType theElement) {
            this(theElement, null, null);
        };

        Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> nt) {
            element = theElement;
            leftChild = lt;
            nextSibling = nt;
        }

        AnyType element;
        Node<AnyType> leftChild;
        Node<AnyType> nextSibling;

    }

    public static final int DEFAULT_TRESS = 1;
    private int currentSize;
    private Node<AnyType>[] theTrees;
    private Node<AnyType>[] theTreeRoots;

    private Node<AnyType> combineTrees(Node<AnyType> t1, Node<AnyType> t2) {
        if(t1.element.compareTo(t2.element) > 0) {
            return combineTrees(t2, t1);
        } else {
            t2.nextSibling = t1.leftChild;
            t1.leftChild = t2;
            return t1;
        }
    }


}
