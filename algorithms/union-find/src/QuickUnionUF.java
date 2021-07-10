public class QuickUnionUF {
  private final int[] id;

  public QuickUnionUF(int N) {
    id = new int[N];

    for (int i = 0; i < N; i += 1) {
      id[i] = i;
    }
  }

  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }

    return i;
  }

  // O(N)
  public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  // O(N)
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);

    id[i] = j;
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
    QuickUnionUF quickUnionUF = new QuickUnionUF(N);

    while (T-- > 0) {
      operation = scanner.nextLine();

      P = Integer.parseInt(operation.split(" ")[1]);
      Q = Integer.parseInt(operation.split(" ")[2]);

      if (operation.split(" ")[0].equalsIgnoreCase("u")) {
        quickUnionUF.union(P, Q);
      } else {
        System.out.println();
        System.out.printf("Are %s and %s connected: %s", P, Q, quickUnionUF.isConnected(P, Q));
      }
    }
  }
}
