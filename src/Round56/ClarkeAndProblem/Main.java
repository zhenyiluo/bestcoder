import java.util.*;
import java.io.*;
public class Main {
    public static final int MOD = (int)(1e9 + 7);
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNext()){
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();

    }

    private static void solve(Scanner sc, PrintWriter pw){
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            pw.println(solve(n, a, p));
        }
    }
    private static int solve(int n, int[] a, int p){
        int[] dp = new int[p];
        dp[0] = 1;
        for(int i = 0; i <n; i++){
            int v = a[i]% p;
            if(v < 0){
                v += p;
            }
            int[] tmp = dp;
            dp = new int[p];
            for(int j = 0; j < p; j++){
                dp[(j+v) % p] = (tmp[(j+v) % p] + tmp[j]) % MOD;
            }
        }
        return dp[0];
    }
}