import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IsSorted {
  public static boolean isIntegerArraySorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i += 1) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    // Driver method
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    int n;
    n = sc.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i += 1) {
      arr[i] = sc.nextInt();
    }

    out.println("isIntegerArraySorted: " + isIntegerArraySorted(arr));

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

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
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
