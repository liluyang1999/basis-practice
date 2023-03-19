package others;

public class TreapNode {

    private int elem;
    private int priority;

    TreapNode lchild;
    TreapNode rchild;

    TreapNode(int elem, int priority) {
        //优先级，体现堆的特性
        this.lchild = this.rchild = null;
    }

    public void left_rotate(TreapNode node) {
        TreapNode temp = node.rchild;
        node.rchild = temp.lchild;
        temp.lchild = node;
        node = temp; //binded with the current node
    }

    public void right_rotate(TreapNode node) {
        TreapNode temp = node.lchild;
        node.lchild = temp.rchild;
        temp.rchild = node;
        node = temp; //now the ancestor of the node becomes the temporary element 'temp'
    }

}

