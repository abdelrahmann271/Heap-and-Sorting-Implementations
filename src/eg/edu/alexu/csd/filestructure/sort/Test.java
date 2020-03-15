package eg.edu.alexu.csd.filestructure.sort;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		
		long start,end,elapsedTimeFast,elapsedTimeSlow,start2,end2;
		Random rand = new Random();
		Sort sort = new Sort<>();
		ArrayList<Integer> test = new ArrayList<Integer>();
		ArrayList<Integer> test2 = new ArrayList<Integer>();
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("testout.xls");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		for(int i = 1 ; i<6; i++)
		{
			//int sizeOfArrayList = rand.nextInt(10^i);
			int sizeOfArrayList = (int) Math.pow(10, i);
			System.out.println("N is " + sizeOfArrayList);
			test.clear();
			test2.clear();
			for(int j = 0 ; j < sizeOfArrayList ; j++)
			{
				int k =  rand.nextInt(100000000);
				test.add(k);
				test2.add(k);
			}		
			
			 //Fast Sort
			
			 start = System.nanoTime();
			// System.out.println(start);
			 // some time passes
			 //sort.sortFast(test);
			 sort.heapSort(test);
			 end = System.nanoTime();
			// System.out.println(end);
			 elapsedTimeFast = (end - start); 
			 
			 
//			 //Slow Sort
//			 start2 = System.nanoTime();
//			 //System.out.println(start);
//			 // some time passes
//			 sort.sortSlow(test2);
//			 end2 = System.nanoTime();
//			 //System.out.println(end);
//			 elapsedTimeSlow = (end2 - start2); 
			 
			 
			 
			 System.out.println(elapsedTimeFast);
				try {	
				    fileWriter.write(Integer.toString(sizeOfArrayList)+"	");
				    //fileWriter.write(Long.toString(elapsedTimeSlow)+"	");
				    fileWriter.write(Long.toString(elapsedTimeFast)+"	");
				    fileWriter.write("\n");
				    
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Vector<Integer> v = new Vector<Integer>();
//		v.add(5);
//		v.add(2);
//		v.add(3);
//		v.add(8);
//		v.add(1);

//		System.out.println(v.get(0));
		
//		ArrayList<Integer> v = new ArrayList<Integer>();
//		v.add(6);
//		v.add(5);
//		v.add(3);
//		v.add(8);
//		v.add(2);
//		v.add(1);
//		v.add(-4);
//		v.add(8);
//		v.add(3);
//		v.add(-42);
//		v.add(0);
//		v.add(21);
//	
//		for(int i = 0 ; i < v.size() ; i++)
//		{
//			System.out.print(v.get(i)+" ");
//		}
//
//		Heap<Integer> h = new Heap<>();
		
		
//		h.build(v);
		
//		h.insert(4);
//		System.out.println();
//		for(int i = 1; i < h.size()+1 ; i++)
//		{
//			System.out.print(h.heap[i].getValue()+" ");
//		}
//		
		


//		System.out.println();
//		System.out.println("The collection after heap building");
//		for(int i = 0 ; i < v.size() ; i++)
//		{
//			System.out.print(v.get(i)+" ");
//		}
//		System.out.println();
//		System.out.println("Root is "+h.getRoot().getValue());
//		System.out.println("test extract");
//		System.out.println(h.extract());
//		System.out.println("THE heap after extraction");
//		for(int i = 1; i < h.size()+1 ; i++)
//		{
//			System.out.print(h.heap[i].getValue()+" ");
//		}
//		h.insert(10);
//		System.out.println("Test insertion");
//		System.out.println("the inserted value is 10");
//		System.out.println("the heap after insertion");
//		for(int i = 1; i < h.size()+1 ; i++)
//		{
//			System.out.print(h.heap[i].getValue()+" ");
//		}
//		h.insert(100);
//		System.out.println("the heap after insertion");
//		for(int i = 1; i < h.size()+1 ; i++)
//		{
//			System.out.print(h.heap[i].getValue()+" ");
//		}
	}

}
