/* 队列
 * ======================================================================================================
 * 描述
 * ------------------------------------------------------------------------------------------------------
 *
 * 先进先出队列（简称队列）是一种基于先进先出（FIFO）策略的集合类型。按照任务产生的顺序完成它们的策略。
 * 任何服务性策略的基本原则都是公平，在提到公平时大多数人的第一个想法就是应该优先服务等待最久的人，这就
 * 是先进先出策略的准则。
 * 队列是许多日常现象的自然模型，它也是无数应用程序的核心。
 * 在应用程序中使用队列的主要原因是在用集合保存元素是同时保存它们的相对顺序：使它们入列顺序和出列顺序相同。
 * 理解：平时生活极其常见，各种排队。
 *
 * -------------------------------------------------------------------------------------------------------
 */


 /*API
 * ================================================================
 * 先进先出队列（FIFO）队列
 * ----------------------------------------------------------------
 * public class Queue<Item> implements Iterable<Item>
 *						Queue()                 创建一个空背包
 *        void          enqueue(Item item)      添加一个元素 
 *        Item          dequeue()               删除最近添加的元素              
 *        boolean       isEmpty()               队列是否为空
 *        int           size()                  队列中的元素数量
 * ----------------------------------------------------------------
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int N;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * 初始化一个空队列
	 */
	public Queue() {
		first = null;
		last = null;
		N = 0;
	}
	
	/**
	 * 如果队列为空返回true
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 *返回队列中元素的个数
	 */
	public int size() {
		return N;
	}

	/**
	 * 返回最近新添加的元素
	 *
	 * @return 最近新添加的元素
	 * @throw NoSuchElementException if this queue is empty
	 */
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Queue underfow");
		return first.item;
	}

	/**
	 * 添加新的元素到队列中
	 *
	 * @param item 被添加的元素
	 */
	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}

	/**
	 * 删除并返回队列中最近新添加的元素
	 * 
	 * @return 最近新添加的元素
	 * @throws NoSuchElementException if this queue is empty
	 */
	 public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if(isEmpty()) last = null;
		return item;
	 }

	 /**
	  * 返回队列的String 表示
	  *
	  * @return 按照FIFO的顺序 将队列中的元素组成一个String 并且用空格进行分隔
	  */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Item item : this) {
			s.append(item + " ");
		}
		return s.toString();
	}

	/**
	 * 返回一个能够按照FIFO顺序遍历队列中的元素的迭代器
	 *
	 * @return an iterator that iterates over the items in this queue in FIFO order
	 */
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}
	
	//一个迭代器，但没有实现remove()方法，因为它是可选的
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {return current != null;}

		public void remove() {throw new UnsupportedOperationException();};

		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	//Queue 用例
	public static void main(String[] name) {
		Queue<String> q = new Queue<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) q.enqueue(item);
			else if(!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue" + ")");
	}

}
