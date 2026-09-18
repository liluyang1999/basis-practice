package others;

public final class TreeTest {
    public static void main(String[] args) {
        TreapNode node = new TreapNode(2, 9);
        node.lchild = new TreapNode(1, 10);
        node.rchild = new TreapNode(4, 1);
        node.rchild.lchild = new TreapNode(3, 8);
        TreapNode root = node.left_rotate(node);
        require(root.getElem() == 4 && root.getPriority() == 1 && root.lchild == node);
        require(node.rchild.getElem() == 3 && node.lchild.getElem() == 1);
        root = root.right_rotate(root);
        require(root == node && root.rchild.getElem() == 4 && root.rchild.lchild.getElem() == 3);
        try { new TreapNode(1, 1).left_rotate(new TreapNode(1, 1)); throw new AssertionError(); }
        catch (IllegalArgumentException expected) { }
        require(AjaxResult.success("ok").get("code").equals(1));
        System.out.println("TreeTest: rotations preserve subtrees; result wrapper passed");
    }
    private static void require(boolean condition) { if (!condition) throw new AssertionError(); }
}
