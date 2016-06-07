/*插入排序*/
 import edu.princeton.cs.algs4.StdIn;
 import edu.princeton.cs.algs4.StdOut;
 import java.util.Comparator;

 public class Insertion {
	 private Insertion() {}

	 public static void sort(Comparable[] a) {
		 int N = a.length;
		 for(int i = 1; i < N; i++) {
			 for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				 exch(a, j, j-1);
			 }
			 assert isSorted(a, 0,i);
		 }
		 assert isSorted(a);
	 }			 

	 public static void sort(Comparator[] a, int lo, int hi) {
		 int N = a.length;
		 for(int i = 0; i < N; i++) {
			 for(int j = i; j > 0 && less(a[j], j[j-1]); j--) {
				 exch(a, j, j-1);
			 }
			 assert isSorted(a, lo, hi);
		 }
		 assert isSorted(a);
	 }

	 public static void sort(Comparator[] a, int lo, int hi) {
		 for(int i = lo; i <= hi; i++) {
			 for(int j = i; j > lo && less(a[j], a[j-1]); j--) {
				 exch(a, j, j-1)
			 }
		 }
		 assert isSorted(a, lo, hi)
	 }

	 private static boolean less(Comparable v, Comparable w) {
		 return v.compareTo(w) < 0;
	 }

	 private static boolean less(Object v, Object w, Comaprator comparator) {
		 return comparator.compare(v, w) < 0;
	 }

	 private static void exch(Object[], a, int i, int j) {
		 Object swap = a[i];
		 a[i] = a[j];
		 a[j] = swap;
	 }

	 public static void exch(int[] a, int i, int j) {
		 int swap = a[i];
		 a[i] = a[j];
		 a[j] = swap;
	 }

	 private static boolean isSorted(Comparable[] a) {
		 return isSorted(a, 0, a.length -1);
	 }
	 private static boolean isSorted(Object[] a, Comaprator comparator) {
		return isSorted(a, 0, a.length -1);
	 }
	 private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
		 for(int i = lo + 1; i <= hi; i++)
			 if(less(a[i], a[i-1], comparator)) return false;
		 return true;
	 }


	 private static void show(Comparator[] a) {
		 for(int i = 0; i < a.length; i++)
			 StdOut.println(a[i]);
	 }

	 public static void main(String[], args) {
		 String[] a = StdIn.readAllStrings();
		 Insertion.sort(a);
		 show(a);
	 }
	
 }
