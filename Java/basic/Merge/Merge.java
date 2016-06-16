/*归并排序*/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {

	private Merge() {}

	/*归并算法核心实现*/
	/*合并*/
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		for(int k = lo, k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo; j = mid+1;
		for(int k = lo; k <= hi; k++){
			if(i > mid) a[k] = aux[j++];
			if(j > hi)  a[k] = aux[i++];
			else if(less(a[i], a[j])) a[k] = [i++];
			else a[k] = aux[j++];
		}
	}
	/*递归分解*/
	private static void sort(Comparable[] a, Comparable[], aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - ho) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length - 1];
		sort(a, aux, 0, a.length - 1);
		assert isSorted(a);
	}


	/*helper functions*/
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void exch(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}
	private static boolean isSorted(Comparable[], int lo, int hi) {
		for(int k = lo; k <= hi; k++)		
			if(less(a[k], a[k-1])) return false;
		return true;
	}
	private static void show(Comparable[] a) {
		for(int i = 0; i < a.lenght; i++)
			StdOut.println(a[i]);
	} 

	/*main函数*/

}
