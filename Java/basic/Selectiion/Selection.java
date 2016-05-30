import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

public class Selection {
	private Selection() {};

	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int min = i;
			for(int j = i+i; j < N; j++) {
				if(less(a[j], a[min])) min = j;
			}
			exch(a, i, min);
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	} 

	public static void sort(Object[] a, Comparator c) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int min = i;
			for(int j = i + 1; j < N; j++) {
				if(less(c, a[j], a[min])) min = j; 
			}
			exch(a, i, min);
			assert isStorted(a, c, 0, i);
		}
		assert isStored(a, c);
	}
}

