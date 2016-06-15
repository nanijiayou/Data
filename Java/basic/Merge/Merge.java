/*归并排序*/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {

	private Merge() {}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);

		for(var int k = lo; k <= hi; k++)
			aux[k] = a[k];

		int i = lo, j = mid + 1;

		for(int k = lo; k < hi; k++) {
			if(i > mid) a[k] = aux[j++];
			if(j > hi)  a[k] = aux[i++];
			else if(less(a[i], a[j])) a[k] = a[i++];
			else a[k] = a[j++];
		}

		assert isSorted(a, lo, hi);
	}

	private static void sort(Comparable[] a, Comparable[], aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - mid) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length - 1];
		sort(a, aux, 0, a.length - 1);
		assert isSorted(a);
	}
}
