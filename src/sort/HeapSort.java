package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        long timestamp1 = System.currentTimeMillis();
        HeapSort.sort(TestUtil.getTestArr());
        long timestamp2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(TestUtil.getTestArr()));
        System.out.println("数量：" + TestUtil.getTestArr().length);
        System.out.println("耗时：" + (timestamp2 - timestamp1));
    }

    public static void sort(int[] arr) {
        Heap heap = new Heap(arr);
        int pos = 0;
        while (!heap.isEmpty()) {
            arr[pos++] = heap.popElem();
        }
    }
}

class Heap {

    private HeapNode root;

    public Heap(int[] arr) {
        this.buildHeap(arr);
    }

    private void buildHeap(int[] arr) {

    }

    public void addElement(int elem) {
        this.addNode(new HeapNode());
    }

    public int popElem() {
        return this.popNode().element;
    }

    private void addNode(HeapNode node) {

    }

    private HeapNode popNode() {
        return new HeapNode();
    }

    public boolean isEmpty() {
        return root == null;
    }

    static class HeapNode {
        private int element;
        private HeapNode leftChild;
        private HeapNode rightChild;
    }
}



