/*
Sample input:
10
10
U 4 3
U 3 8
U 6 5
U 9 4
U 2 1
F 8 9
F 5 0
U 5 0
U 7 2
U 6 1
 */

public class QuickFindUF {
  private final int[] id;

  public QuickFindUF(int N) {
    id = new int[N];

    for (int i = 0; i < N; i += 1) {
      id[i] = i;
    }
  }

  // Quick find O(1)
  public boolean isConnected(int p, int q) {
    return id[p] == id[q];
  }

  // O(N^2)
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];

    for (int i = 0; i < id.length; i += 1) {
      if (id[i] == pid) {
        id[i] = qid;
      }
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
    QuickFindUF quickFindUF = new QuickFindUF(N);

    while (T-- > 0) {
      operation = scanner.nextLine();

      P = Integer.parseInt(operation.split(" ")[1]);
      Q = Integer.parseInt(operation.split(" ")[2]);

      if (operation.split(" ")[0].equalsIgnoreCase("u")) {
        quickFindUF.union(P, Q);
      } else {
        System.out.println();
        System.out.printf("Are %s and %s connected: %s", P, Q, quickFindUF.isConnected(P, Q));
      }
    }
  }
}
