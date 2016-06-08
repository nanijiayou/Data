/*希尔排序*/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Shell {
	private Shell() {}

	public static void sort(Comparable[] a) {
		int N = a.length;

		int h = 1;

		while(h < N/3) h = 3*h + 1;

		while( h >= 1) {
			for(int i = h; i < N; i++) {
				for(j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			assert isHsorted(a, h);
			h /= 3;
		}

	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swrap;
	}

	private static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	private static boolean isHstored(Comparable[] a, int h) {
		for(int i = h; i < a.length; i++)
			if(less(a[i], a[i-h])); return false;
		return true;
	}

	private static void show(Comaprable[] a) {
		for(int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllString();
		Shell.sort(a);
		show(a);
	}
}
