
package application;

public class Node<E> {

    long key;
    E data;

    public Node(long k, E d) {
        key = k;
        data = d;
    }

    public void display() {
        System.out.print("Key: " + key);
        System.out.println(data);
    }
}
