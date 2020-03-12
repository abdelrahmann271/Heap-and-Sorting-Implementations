package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Vector;

public class Sort<T extends Comparable<T>> implements ISort<T> {
	  ArrayList list;
		@Override
		public IHeap heapSort(ArrayList unordered) {
			// TODO Auto-generated method stub
			list=unordered;
			Heap<T> h = new Heap<>();
		    h.build(list);
		    int n=list.size();
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
			list=unordered;
			part(0,unordered.size()-1);
			
		}

		@Override
		public void sortSlow(ArrayList unordered) {

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
		public void part(int l,int r) {
			if(l<r) {
				part(l,(l+r)/2);
				part((l+r)/2+1,r);
				mergesort(l,r);
			}
			
			
		}
	    public void mergesort(int l,int r)	{
	    	
	    	int mid=(l+r)/2+1,i=l,j=mid;
	    	Vector<Object> temp=new Vector();
	    	while(i<mid&&j<=r) {
	    		
	    		Comparable<T> x=(Comparable<T>)list.get(i);
				Comparable<T> y=(Comparable<T>)list.get(j);
				if(x.compareTo((T)y)<0) {
					temp.add(list.get(i++));
				}
				else {
					temp.add(list.get(j++));
				}
	    		
	    	}
	    	while(i<mid) {
	    		temp.add(list.get(i++));
	    	}
	    	while(j<=r) {
	    		temp.add(list.get(j++));
	    	}
	    	j=0;
	    	for(i=l;i<=r;i++) {
	    		list.set(i, temp.get(j++));
	    	}
	    	
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

