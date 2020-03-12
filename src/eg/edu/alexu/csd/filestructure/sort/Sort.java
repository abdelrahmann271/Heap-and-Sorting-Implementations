package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Vector;

public class Sort<T extends Comparable<T>> implements ISort<T> {
	  ArrayList list;
		@Override
		public IHeap heapSort(ArrayList unordered) {
			// TODO Auto-generated method stub
			Heap<T> h = new Heap<>();
			if(unordered == null)
				return h;
			list=unordered;			
		    h.build(list);
		    int n=list.size();
		    for(int i=(n-1)/2;i>=0;i--) {
		    	heapify(i,n);
		    }
		    for(int i=n-1;i>0;i--) {
		    	Object temp=list.get(0);
		    	list.set(0, list.get(i));
		    	list.set(i, temp);
		    	heapify(0,i);
		    }
		    h.construct(unordered);
			return h;
		}

		@Override
		public void sortFast(ArrayList unordered) {
			// TODO Auto-generated method stub
			if(unordered ==null)
				return;
			list=unordered;
			 div(0,unordered.size()-1);
			
		}

		@Override
		public void sortSlow(ArrayList unordered) {
			if(unordered == null)
				return;
			int n=unordered.size();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-1-i;j++) {
					Comparable<T> x=(Comparable<T>)unordered.get(j);
					Comparable<T> y=(Comparable<T>)unordered.get(j+1);
							if(x.compareTo((T)y)>0) {
						Object temp=unordered.get(j);
						unordered.set(j,unordered.get(j+1));
						unordered.set(j+1,temp);
					}
				}
			}
			
		}

		public void div(int l,int r) {
			
			if(l<r) 
			{
			int p=Quicksort(l,r);
			div(l,p-1);
			div(p+1,r);
			}
		}
	
	    public int Quicksort(int l,int r) {
	    	
	    	int last=l,it=l+1;
	    	Comparable<T> x=(Comparable<T>)list.get(l);
	    	while(it<=r) {
	    		
	    		Comparable<T> y=(Comparable<T>)list.get(it);
	    		if(x.compareTo((T)y)>=0) {
	    			last++;
	    			Object temp=list.get(last);
	    			list.set(last, list.get(it));
	    			list.set(it,temp);
	    		}
	    		it++;
	    	}
	    	Object temp=list.get(last);
			list.set(last, list.get(l));
			list.set(l,temp);
	    	return last;
	    	
	    }
	    public void heapify(int i,int n) {
	    	
	    	int max=i;
	    	Comparable<T> l=null,r=null;
	    	if(2*i+1<n) {l=(Comparable<T>)list.get(2*i+1);}
	    	if(2*i+2<n) {r=(Comparable<T>)list.get(2*i+2);}
	    	if(2*i+1<n&&l.compareTo((T)list.get(max))>0){
	    		max=2*i+1;
	    	}
	    	if(2*i+2<n&&r.compareTo((T)list.get(max))>0){
	    		max=2*i+2;
	    	}
	    	if(max!=i) {
	    		Object temp=list.get(i);
	    		list.set(i, list.get(max));
	    		list.set(max, temp);
	    		heapify(max,n);
	    	}
	    }
	
	    
}
