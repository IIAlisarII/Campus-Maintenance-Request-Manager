package application;

import java.io.Serializable;

public class DoubleHashTable<E> implements Serializable {
	Entry[] hashArray;
	Entry defunct;
	private int size; // number of entries

	public DoubleHashTable(int s) {
		hashArray = new Entry[s];
		defunct = new Entry(-1, null);
		size = 0;
	}

	public void displayTable() {
		for (int j = 0; j < hashArray.length; j++)
			if (hashArray[j] != null)
				hashArray[j].diplay();
			else
				System.out.println("** ");
	}

	// --------------------------------------------------
	public boolean isFull() {
		for (int i = 0; i < hashArray.length; i++)
			if (hashArray[i] == null || hashArray[i] == defunct)
				return false;
		return true;

	}

	// -------------------------------------------------------------
	public int hashFunc(int key) // original index
	{
		return key % hashArray.length;
	}

	public int hashFunc2(int key) // steps
	{
		return 9 - (key % 9);
	}

	public void insert(int k, E d) {
		if (!isFull()) {

			int hk1 = hashFunc(k); // 5
			int hk2 = hashFunc2(k); // 2
			while (hashArray[hk1] != null && hashArray[hk1] != defunct) { // collision
				hk1 = hk1 + hk2; // 7
				hk1 %= hashArray.length;
			}
			hashArray[hk1] = new Entry<E>(k, d);
			size++;
		}
	}

	public E delete(int k) {
		int hashVal = hashFunc(k);
		int start = hashVal;
		boolean checkAll = false;
		int hk2 = hashFunc2(k);
		while (hashArray[hashVal] != null && !checkAll) {
			if (hashArray[hashVal].key == k) {
				E temp = (E) hashArray[hashVal].data;
				size--;
				return temp;
			}
			hashVal = hashVal + hk2;
			hashVal %= hashArray.length;

			if (hashVal == start)
				checkAll = true;
		}
		return null;
	}

	public E find(int k) {
		int hashVal = hashFunc(k);
		int start = hashVal;
		boolean checkAll = false;
		int hk2 = hashFunc2(k);
		while (hashArray[hashVal] != null && !checkAll) {
			if (hashArray[hashVal].key == k)
				return (E) hashArray[hashVal].data;
			hashVal = hashVal + hk2;
			hashVal %= hashArray.length;
			if (hashVal == start)
				checkAll = true;
		}
		return null;
	}

}
