/* API
 * ================================================================
 * public class Stack<Item> implements Stack<Item>
 *                      Stack()                 创建一个空栈
 *        void          push(Item item)         添加一个元素 
 *        Item          pop()                   删除最近添加的元素              
 *        boolean		isEmpty()               栈是否为空
 *        int           size()                  栈中的元素数量
 * ----------------------------------------------------------------
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
	private Item[] a;
	private int N;

	public Stack() {
		a = (Item[]) new Object[2];
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int capacity) {
		assert capacity >= N;
		Item[] temp = (Item[]) new Object[capacity];
		for(int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if(N == a.length) resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = a[N-1];
		a[N-1] = null;
		N--;
		if(N > 0 && N == a.length / 4) resize(a.length/2);
		return item;
	}

	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return a[N-1];
	}

	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {
		private int i;

		public StackIterator() {
			i = N -1;
		}

		public boolean hasNext() {
			return i >= 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			return a[i--];
		}
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) s.push(item);
			else if(!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on Stack)");
	}
}
