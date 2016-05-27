import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;
	private int count;

	public UF(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		validate(p);
		return(id[p]);
	}

	public void validate(int p) {
		int N = id.length;
		if(p < 0 || p >= N) {
			throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N - 1));
		}
	}

	public boolean connected(int p, int q) {
		validate(p);
		validate(q);
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		validate(p);
		validate(q);

		int pID = id[p];
		int qID = id[q];

		if(pID == qID) return;

		for(int i = 0; i < id.length; i++) {
			if(id[i] == pID) id[i] = qID;
		}
		count--;	
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			if(uf.connected(p,q)) continue;
			uf.union(p,q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " 个分量");
	}
}
