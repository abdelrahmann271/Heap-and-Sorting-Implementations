package eg.edu.alexu.csd.filestructure.sort;

import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		
//		Vector<Integer> v = new Vector<Integer>();
//		v.add(1);
//		System.out.println(v.get(0));
		
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(6);
		v.add(5);
		v.add(3);
		v.add(8);
		v.add(2);
		v.add(1);
		v.add(-4);
		v.add(8);
		v.add(3);
		v.add(-42);
		v.add(0);
		v.add(21);
	
		for(int i = 0 ; i < v.size() ; i++)
		{
			System.out.print(v.get(i)+" ");
		}
		Heap<Integer> h = new Heap<>();
		h.build(v);
		System.out.println();
		for(int i = 0 ; i < v.size() ; i++)
		{
			System.out.print(v.get(i)+" ");
		}
		System.out.println();
		System.out.println("Root is "+h.getRoot().getValue());
		System.out.println();
		System.out.println(h.extract());
		System.out.println("THE heap after extraction");
		for(int i = 1; i < h.heap.length-1 ; i++)
		{
			//System.out.print(v.get(i)+" ");
			System.out.print(h.heap[i].getValue()+" ");
		}
	}

}
