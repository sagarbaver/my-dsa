import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DigitSum {
  public static int computeDigitSum(int num) {
    int digitSum = 0;

    while (num > 0) {
      digitSum += num % 10;
      num /= 10;
    }

    return digitSum;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    int n;
    n = sc.nextInt();
    out.println(computeDigitSum(n));

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
  }
  // --------------------------------------------------------
}
