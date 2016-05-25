/* 描述
 * ===================================================================================
 * 背包
 * -----------------------------------------------------------------------------------
 *
 * 背包是一种不支持从中删除元素的集合数据类型
 * 它的目的就是帮助用例收集元素并迭代遍历所搜集的元素
 * 用例也可以检查背包是否为空或者获取背包中元素的数量
 * 理解：可以想象一个非常喜欢收集弹子球的人，他将所有的弹子球都放在一个背包里，一次一个
 *		并且会不时在所有的弹子球中寻找某一颗拥有某种特点的弹子球。
 *
 * ------------------------------------------------------------------------------------
 */

/*API
 * =============================================================
 * 背包
 * -------------------------------------------------------------
 * public class Bag<Item> implements Iterable<Item>
 * 
 *				        Bag()				创建一个空背包
 *		  void			add(Item item)		添加一个元素 
 *        boolean		isEmpty()			背包是否为空
 *        int           size()              背包中的元素数量
 * -------------------------------------------------------------
 */
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int N;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Bag() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
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
		Bag<Double> numbers = new Bag<Double>();

		while(!StdIn.isEmpty()) {
			numbers.add(StdIn.readDouble());
		}
		int N = numbers.size();

		double sum = 0.0;
		for(double x : numbers) {
			sum += x;
		}
		double mean = sum / N;
	
		sum = 0.0;
		for(double x : numbers) {
			sum += (x - mean) * (x -mean);
		}
		double std = Math.sqrt(sum / (N -1));

		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
	}
}

