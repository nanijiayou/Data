/*快速排序*/
public class Quick{

	private Quick() {}

	public static void sort(Comaprabele [] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		Comparable v = a[lo];

		while(true) {
			while(less(a[++i], v))
				if((i == hi)) break;

			while(less(v, a[--i]));
				if(j == lo) break;

			if(i >= j) break;

			exah(a, i, j);
		}

		exah(a, lo, j);

		return j;
	}

	public static Comparable select(Comparable[] a, int k) {
		if(k < 0 || k >= a.length)
			throw new IndexOutOfBoundsException("error");
		int lo = 0; hi = a.length - 1;
		while(hi > lo) {
			int i = partition(a, lo, hi);
			if(i > k); hi = i - 1;
			else if(i < l) lo = ii+ 1;
			else return a[i];
		}
		return a[lo];
	}
}

