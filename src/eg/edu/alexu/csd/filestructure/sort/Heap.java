package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


public class Heap<T extends Comparable<T>> implements IHeap<T> {
	
	public Node [] heap = null;
	
	private int ActualSize ;		//acutalsize = indx of last element = el 3dd N
									//heap size N+1	
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
			swapNodes(node, largest); //swap the values only, not pointers 
			heapify(largest);
		}
		
	}

	@Override
	public T extract() {
		// TODO Auto-generated method stub
		T extractedValue;
		swapNodes(this.heap[ActualSize] , this.heap[1]);			
		//How to return the updated heap ?
		if(heap[ActualSize/2].getRightChild() == null)
		{
			heap[ActualSize/2].setLeftChild(null);
		}
		else
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void build(Collection<T> unordered) {
		// TODO Auto-generated method stub	
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
		for(int j = size/2 ; j>=1 ;j--)
		{
			heapify(temp[j]);
		}
		unordered.clear();
		for(int i = 1 ; i < temp.length ; i++)
		{
			unordered.add(temp[i].getValue());
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

