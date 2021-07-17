/*
Sample input:
10
12
U 4 3
U 3 8
U 6 5
U 9 4
U 2 1
U 5 0
U 7 2
U 6 1
U 7 3
F 6 1
F 5 7
F 9 2
 */
public class UnionFind {
  private final int[] id;
  private final int[] size;

  public UnionFind(int N) {
    id = new int[N];
    size = new int[N];

    for (int i = 0; i < N; i += 1) {
      id[i] = i;
      size[i] = 1;
    }
  }

  private int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]]; // Path compression - flattens the tree further
      i = id[i];
    }

    return i;
  }

  // Proportional to the depth of p and q which is log base2 N O(lg N)
  public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  // log base2 N O(lg N)
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);

    if (i == j) {
      return;
    }

    if (size[i] < size[j]) {
      id[i] = j;
      size[j] += size[i];
    } else {
      id[j] = i;
      size[i] += size[j];
    }
  }

  public static void main(String[] args) {
    InputOutput scanner = new InputOutput();

    int T, N, P, Q;
    String operation;

    System.out.println("Enter the total number of integers");
    N = scanner.nextInt();

    System.out.println("Enter the total number of operations");
    T = scanner.nextInt();

    System.out.println(
        "Enter either a Union operation (U P Q) or a Find operation (F P Q) for each test case");
    UnionFind unionFind = new UnionFind(N);

    while (T-- > 0) {
      operation = scanner.nextLine();

      P = Integer.parseInt(operation.split(" ")[1]);
      Q = Integer.parseInt(operation.split(" ")[2]);

      if (operation.split(" ")[0].equalsIgnoreCase("u")) {
        unionFind.union(P, Q);
      } else {
        System.out.println();
        System.out.printf("Are %s and %s connected: %s", P, Q, unionFind.isConnected(P, Q));
      }
    }
  }
}
