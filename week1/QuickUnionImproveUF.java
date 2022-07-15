package week1;

class QuickUnionImproveUF {
    private int[] id;
    private int[] sz;

    QuickUnionImproveUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];

        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else { id[j] = i; sz[i] += sz[j]; }
    }

    public void printConnected(int p, int q) {
        System.out.println("connected " + p + " " + q + " " + connected(p, q));
    }

    public static void main(String[] args) {
        QuickUnionImproveUF f = new QuickUnionImproveUF(10);

        f.printConnected(8, 9);

        f.union(4, 3);
        f.union(3, 8);
        f.union(6, 5);
        f.union(9, 4);
        f.union(2, 1);

        f.printConnected(8, 9);
        f.printConnected(7, 0);

        f.union(5, 0);
        f.union(7, 2);
        f.union(6, 1);

        f.printConnected(7, 0);
    }
}
