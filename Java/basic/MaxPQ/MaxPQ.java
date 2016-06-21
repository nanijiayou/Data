/*API
* =============================================================
* 优先队列（堆实现）
* -------------------------------------------------------------
* public class MaxPQ<key extends Comparable<key>>
* 
*						MaxPQ()				创建一个优先队列
*						MaxPQ(int max)		添加一个最大容量为max的优先队列
*						MaxPQ(Key[] a)		用a[]中的元素创建一个优先队列	
*		void			Insert(Key v)		向优先队列中插入一个元素
*		Key				mak()				返回最大元素
*		Key				delMax()			删除并返回最大元素
*		boolean			isEmpty()			返回队列是否为空
*		int				size()				返回队列中元素的个数
* -------------------------------------------------------------
*/

public class MaxPQ<Key extends Comparable<key>> {

	private Key[] pq;
	private int N = 0;

	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[MaxN + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink[1];
		return max;
	}


	public boolean less(int i; int j) {
	}

	public void exch(int i, int j) {
	}

	public void swim(int k) {
	}

	public void sink(int k) {
	}
}

