package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Heap<T extends Comparable<T>> implements IHeap<T> {
	

	//Actual size = index of last element = N
	//heap size initial capacity = 101
	public Node<T>[] heap= new Node[1000001];
	private int ActualSize = 0 ;	 
									
	@Override
	public INode<T> getRoot() {
		// TODO Auto-generated method stub
		return heap[1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.ActualSize;
	}

	@Override
	public void heapify(INode<T> node) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		INode<T> largest = node;
		if(node.getLeftChild() != null && node.getValue().compareTo(node.getLeftChild().getValue()) > 0 )
		{
			largest = node;	
		}
		else if(node.getLeftChild() != null)
		{
			largest = node.getLeftChild();
		}
		if(node.getRightChild() != null && node.getRightChild().getValue().compareTo(largest.getValue()) > 0 )
		{
			largest = node.getRightChild();
		}
		if(largest != node)
		{
			swapNodes(node, largest); //Swap the values only, not pointers 
			heapify(largest);
		}
		
	}

	@Override
	public T extract() {
		// TODO Auto-generated method stub
		if(ActualSize ==0)
			return null;
		T extractedValue;
		swapNodes(this.heap[ActualSize] , this.heap[1]);			
		if(ActualSize != 1 && heap[ActualSize/2].getRightChild() == null)
		{
			heap[ActualSize/2].setLeftChild(null);
		}
		else if (ActualSize != 1 )
		{
			heap[ActualSize/2].setRightChild(null);
		}
		this.ActualSize--;
		heapify(heap[1]);
		extractedValue = (T) heap[ActualSize+1].getValue();
		heap[ActualSize+1] = null;
		return extractedValue ;
	}

	@Override
	public void insert(T element) {
		if(element ==null)
			return;
		// TODO Auto-generated method stub
		Node<T> newElement = new Node<>();
		newElement.setValue(element);
		if(ActualSize + 1 >= heap.length)
		{
			Node<T>[] temp= new Node[heap.length*2];
			for(int i = 1 ; i < heap.length ; i++)
			{
				temp[i] = heap[i];
			}
			heap = temp;	
		}
		ActualSize++;
		heap[ActualSize] = newElement;
		heap[ActualSize].setParent(heap[ActualSize/2]);
		if ( ActualSize != 1 &&  heap[ActualSize/2].getLeftChild() != null ) {
			heap[ActualSize/2].setRightChild(heap[ActualSize]);
			heap[ActualSize].setParent(heap[ActualSize/2]);
		}
		else if( ActualSize != 1 )
		{
			heap[ActualSize/2].setLeftChild(heap[ActualSize]);
			heap[ActualSize].setParent(heap[ActualSize/2]);
		}
		int hcounter = ActualSize;
		while(hcounter != 1 && heap[hcounter].getValue().compareTo(heap[hcounter/2].getValue()) > 0) {
			swapNodes(heap[hcounter], heap[hcounter/2]);
			hcounter = hcounter/2;
		}
	}

	@Override
	public void build(Collection<T> unordered) {
		// TODO Auto-generated method stub	
		if(unordered == null)
			return;
		Iterator itr = unordered.iterator();
		int k = 1;
		int size = unordered.size();
		this.ActualSize=size;
		
		while(itr.hasNext())
		{
			Node<T> n = new Node<T>();
			n.setValue((T) itr.next());
			heap[k] = n ;
			k++;
		}

		for(int i = 1 ; i <= size ; i++)
		{	
			if(2*i <= size )
			{
				heap[i].setLeftChild(heap[2*i]);
			}
			if( 2*i + 1 <= size)
			{
				heap[i].setRightChild(heap[2*i+1]);
			}
			if( i!=1)
			{
				heap[i].setParent(heap[i/2]);
			}
		}
		//heap = heap;	
		for(int j = size/2 ; j>=1 ;j--)
		{
			heapify(heap[j]);
		}
		unordered.clear();
		for(int i = 1 ; i < size+1 ; i++)
		{
			unordered.add(heap[i].getValue());
		}
		
	}
	private void swapNodes(INode<T> node1,INode<T> node2)
	{
		T temp = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(temp);	
	}	
	
	public void construct(ArrayList unordered) {
		
		int sizeArr = unordered.size()+1;
		Node<T>[] temp = new Node[sizeArr];
		Iterator itr = unordered.iterator();
		int k = 1;
		int size = unordered.size();
		this.ActualSize=size;
		
		while(itr.hasNext())
		{
			Node<T> n = new Node<T>();
			n.setValue((T) itr.next());
			temp[k] = n ;
			k++;
		}

		for(int i = 1 ; i <= size ; i++)
		{	
			if(2*i <= size )
			{
				temp[i].setLeftChild(temp[2*i]);
			}
			if( 2*i + 1 <= size)
			{
				temp[i].setRightChild(temp[2*i+1]);
			}
			if( i!=1)
			{
				temp[i].setParent(temp[i/2]);
			}
		}
		heap = temp;
	}
}
