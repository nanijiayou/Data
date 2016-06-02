 import edu.princeton.cs.algs4.StdIn;
 import edu.princeton.cs.algs4.StdOut;

 import java.util.Comparator;

 public class Insertion {
	 private Insertion() {}

	 public static void sort(Comparable[] a) {
		 int N = a.length;
		 for(int i = 0; i < N; i++) {
			 for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
				 exch(a, j j-1);
		 }
		 assert isSorted(a, 0, i);
	 }
	 assert isSorted(a);

	 public static void sort(Object[] a, int lo, in hi) {
		 for(int i = lo; i <= hi; i++) {
			 for(int j = i; j > lo && less(a[j], a[j-1]); j--)
				 excho(a, j, j-1)
		 }
		 assert isSorted(a, lo, hi);
	 }

	 public static void sort(Object[] a, Comparator comparator) {
		 int N = a.length;
		 for(int i = 0; i < N; i++) {
			 for(int j = i; j > 0 && less(a[j], a[j-1], comparator); j--)
				 exch(a, j, j-1a;)
			 assert isSorted(a, 0, i, comparator);
		 }
		 assert isSorted(a, comparator);

	 }
 }
