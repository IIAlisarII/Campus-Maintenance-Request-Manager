package application;

import java.io.Serializable;

public class Entry<E> implements Serializable{
	// node for hash
	int key;
	E data;
	public Entry(int k, E d)
	{
		key=k;
		data=d;
		
	}
	public void diplay()
	{
		 System.out.print(key+":");
		 System.out.println(data);
	}
}
