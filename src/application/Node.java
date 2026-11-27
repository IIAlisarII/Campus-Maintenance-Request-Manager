
package application;

import java.io.Serializable;

public class Node<E> implements Serializable{
	// for hash !

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
