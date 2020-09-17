package Time_Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Days {
	
	protected String name;
	protected ArrayList <String>subjects=new ArrayList<>();
	protected Set<String>s = new Set<String>() {
		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Iterator<String> iterator() {
			return null;
		}

		@Override
		public Object[] toArray() {
			return new Object[0];
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return null;
		}

		@Override
		public boolean add(String s) {
			return false;
		}

		@Override
		public boolean remove(Object o) {
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends String> c) {
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return false;
		}

		@Override
		public void clear() {

		}

		@Override
		public boolean equals(Object o) {
			return false;
		}

		@Override
		public int hashCode() {
			return 0;
		}
	};

	Days(int i){
		setName(i);
		for(int j=0;j<10;j++)
			subjects.add("");
	}
	
	public void setName(int i) {
		switch(i) {
		case 1:name="Monday";
		break;
		case 2:name="Tuesday";
		break;
		case 3:name="Wednesday";
		break;
		case 4:name="Thursday";
		break;
		case 5:name="Friday";
		break;
		}
	}
	
	public ArrayList<String> getSubjects(){
		return subjects;
	}
	
	public String getName() {
		return name;
	}
}
