package week1;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public void printConnected(int p, int q) {
        System.out.println("connected " + p + " " + q + " " + connected(p, q));
    }

    public static void main(String[] args) {
        QuickFindUF f = new QuickFindUF(10);

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
