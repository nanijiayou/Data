/* Stack 栈
 * ================================================================
 * 描述
 * ----------------------------------------------------------------
 * 下压栈（简称栈）是一种基于后进先出（LIFO）策略的集合类型
 * 理解：电子邮件
 * 
 * ----------------------------------------------------------------
 */


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
	private Node<Item> first;
	private int N;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Stack() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Item item : this) {
			s.append(item + " ");
		}
		return s.toString();
	}

	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
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
