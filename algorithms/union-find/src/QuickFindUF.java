import static java.lang.String.format;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
    MyScanner scanner = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

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
        System.out.println(
            format("Are %s and %s connected: %s", P, Q, quickFindUF.isConnected(P, Q)));
      }
    }
    out.close();
  }
  // -----------PrintWriter for faster output---------------------------------
  public static PrintWriter out;

  // -----------MyScanner class for faster input----------
  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
  // --------------------------------------------------------

}
