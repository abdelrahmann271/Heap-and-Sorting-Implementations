package eg.edu.alexu.csd.filestructure.sort;

public class Node<T extends Comparable<T>> implements INode<T>  {
	
	private int index;
	private INode<T> leftChild;
	private INode<T> rightChild;
	private T value;
	private INode<T> parent;
	
	@Override
	public INode<T> getLeftChild() {
		// TODO Auto-generated method stub
		return leftChild;
	}

	@Override
	public INode<T> getRightChild() {
		// TODO Auto-generated method stub
		return rightChild;
	}

	@Override
	public INode<T> getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public void setValue(T value) {
		// TODO Auto-generated method stub
		this.value= value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setLeftChild(INode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(INode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public void setParent(INode<T> parent) {
		this.parent = parent;
	}
	
	

}
