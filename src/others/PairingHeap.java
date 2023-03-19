package others;

public class PairingHeap <AnyType extends Comparable<? super AnyType>> {

    public Node insert(Node node) {
        if (root == null) {
            root = node;
        } else {
            root = linkPair(node, root);
        }
        return root;
    }

    public void updateKey(Node x, AnyType key) throws Exception {
        if (x.key.compareTo(key) < 0) {
            throw new Exception("Key is not decreased!");
        }
        x.key = key;
        if (x != root) {
            Node xLeft = x.left;
            if(xLeft.child == x) {
                xLeft.child = x.sibling;
            } else {
                xLeft.sibling = x.sibling;
            }
            if (x.sibling != null) {
                x.sibling.left = xLeft;
            }

            x.left = null;
            x.sibling = null;
            root = this.linkPair(x, root);
        }
    }

    public void merge(Node rhs) {
        if (this.root == null) {
            this.root = rhs;
            return;
        }
        if (rhs == null) return;
        this.root = this.linkPair(root, rhs);
    }

    public Node findMin() {
        return this.root;
    }

    public Node extractMin() {
        Node node = this.root;
        if (node != null) {
            if (node.child == null) {
                root = null;
            } else {
                Node firstSibling = node.child;
                firstSibling.left = null;
                root = mergeSubHeaps(firstSibling);
            }
        }
        return node;
    }

    private Node mergeSubHeaps(Node firstSibling) {
        Node first = firstSibling;
        Node second = first.sibling;

        Node tail = first;
        if (second != null) {
            tail = this.linkPair(first, second);
            first = tail.sibling;
            if (first != null) {
                second = first.sibling;
            } else {
                second = null;
            }
        }

        while (first != null && second != null) {
            tail = this.linkPair(first, second);
            first = tail.sibling;
            if (first != null) {
                second = first.sibling;
            } else {
                second = null;
            }
        }

        //从右往左
        if (first != null) {
            tail = first;
        }

        Node prev = tail.left;
        while (prev != null) {
            tail = this.linkPair(prev, tail);
            prev = tail.left;
        }
        return tail;
    }

    private static class Node<AnyType extends Comparable<? super AnyType>> {
        private AnyType key;
        private Node left;
        private Node child;
        private Node sibling;
        public Node(AnyType key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.valueOf(this.key);
        }
    }

    private Node root;

    private Node linkPair(Node first, Node second) {
        if (second == null) return first;
        if (first == null) return second;

        if (first.key.compareTo(second.key) <= 0) {
            first.sibling = second.sibling;
            if (second.sibling != null) {
                second.sibling.left = first;
            }
            Node firstChild = first.child;
            first.child = second;
            second.left = first;
            second.sibling = firstChild;
            if (firstChild != null) {
                firstChild.left = second;
            }
            return first;
        } else {
            Node firstLeft = first.left;
            second.left = firstLeft;
            if (firstLeft != null) {
                if (firstLeft.child == first) {
                    firstLeft.child = second;
                } else {
                    firstLeft.sibling = second;
                }
            }

            Node secondChild = second.child;
            second.child = first;
            first.left = second;
            first.sibling = secondChild;
            if (secondChild != null) {
                secondChild.left = first;
            }
            return second;
        }
    }

    public void print() {
        System.out.println("Pairing Heap");
        this.print(0, this.root);
    }

    private void print(int level, Node node) {
        for (int i = 0; i < level; i++) {
            System.out.format(" ");
        }
        System.out.format("|");
        for (int i = 0; i < level; i++) {
            System.out.format("-");
        }
        System.out.format("%d%n", node.key);

        Node child = node.child;
        while (child != null) {
            print(level + 1, child);
            child = child.sibling;
        }
    }

    public static void main(String[] args) {
        PairingHeap<Integer> pairingHeap = new PairingHeap<>();
        pairingHeap.insert(new Node(3));
        pairingHeap.insert(new Node(4));
        pairingHeap.insert(new Node(2));
        pairingHeap.insert(new Node(8));
        pairingHeap.insert(new Node(1));
        pairingHeap.insert(new Node(0));
        pairingHeap.insert(new Node(2));
        pairingHeap.insert(new Node(3));
        pairingHeap.insert(new Node(4));
        pairingHeap.insert(new Node(2));
        pairingHeap.print();
        pairingHeap.extractMin();
        pairingHeap.extractMin();
        pairingHeap.print();
    }
}
