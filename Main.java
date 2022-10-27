import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

/*

goal is to make every gcd(a[i-1], a[i]) = 1 where 2 <= i <= N

choose prime numbers (when replacing)

min(a[i], a[j]) = min(x, y)

(9, 15) = (11, 9)
(6, 9) = (7, 6)
(3, 6) = (5, 3)

9 6 3 11 15 (original)
11 6 3 11 9
11 7 5 11 3

edge-case:
11 7 5 11 8
11 7 8 11 5
11 7 13 11 5

(5, 8) = (8, 5)
(8, 5) = (13, 5)

we need to make elements in even positions prime
-> also, shouldn't be equal to its adjacent elements

a[i] is only up to 10^9
let p = prime number > a[i],
1. p > a[i] (to make this always true, assign p = 1_000_000_007)
2. a[j] > a[i]

(a[i], a[j]) = (p, a[i])

7 7 8 16 2 10 8
(7, 8) = ((10^9+7), 7)

7 (10^9+7) 8 16 2 10 7
(16, 2) = ((10^9+7), 2)

7 (10^9+7) 8 (10^9+7) 2 10 7
(10, 2) = ((10^9+7), 2)

7 (10^9+7) 8 (10^9+7) 2 (10^9+7) 7
relatively prime

search for elements that are greater or smaller than a[i]
cannot be O(n)

 */

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			int temp = 1_000_000_007;
			System.out.println(n / 2);
			for (int i = 1; i < n; i += 2) {
				System.out.println((i+1) + " " + i + " " + temp + " " + Math.min(a[i-1], a[i]));
			}
		}
		out.close();
	}
		
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
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
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
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
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
