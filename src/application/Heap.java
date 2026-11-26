
package project1;

public class Heap<E> {

    private Node<E> heapArray[];
    private int size;

    public Heap(int mx) {
        size = 0;
        heapArray = new Node[mx];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    
    public boolean isFull() {
    	return size==heapArray.length;
    }

    private void upheap(int i) {

        int parent = (i - 1) / 2;
        Node<E> bottom = heapArray[i];

        while (i > 0 && heapArray[parent].key < bottom.key) {
            heapArray[i] = heapArray[parent];
            i = parent;
            parent = (i - 1) / 2;
        }

        heapArray[i] = bottom;
    }

    public void insert(long k, E d) {
        if (size == heapArray.length)
            throw new IllegalStateException("Heap is full");

        Node<E> newNode = new Node<>(k, d);
        heapArray[size] = newNode;
        upheap(size);
        size++;
    }

    private boolean hasLeftChild(int i) {
        return (2 * i + 1) < size;
    }

    private boolean hasRightChild(int i) {
        return (2 * i + 2) < size;
    }

    public void downHeap(int i) {

        Node<E> top = heapArray[i];

        while (hasLeftChild(i)) {

            int leftChild = 2 * i + 1;
            int largerChild = leftChild;

            if (hasRightChild(i)) {
                int rightChild = 2 * i + 2;

                if (heapArray[rightChild].key >
                    heapArray[leftChild].key)
                    largerChild = rightChild;
            }

            if (top.key >= heapArray[largerChild].key)
                break;

            heapArray[i] = heapArray[largerChild];
            i = largerChild;
        }

        heapArray[i] = top;
    }

    public Node<E> removeMax() {

        if (isEmpty())
            return null;

        Node<E> tmp = heapArray[0];

        heapArray[0] = heapArray[--size];
        heapArray[size] = null;

        if (size > 0)
            downHeap(0);

        return tmp;
    }

    public Node<E> max() {
        if (isEmpty())
            return null;

        return heapArray[0];
    }

}
