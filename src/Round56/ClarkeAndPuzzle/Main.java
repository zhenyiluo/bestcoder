import java.util.*;
import java.io.*;
public class Main {

    static int[][] bit;
    static int n;
    static int m;
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
            n = sc.nextInt();
            m = sc.nextInt();
            bit = new int[n+1][m+1];
            int q = sc.nextInt();
            int[][] a = new int[n+1][m+1];
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    a[j][k] = sc.nextInt();
                    modify(j, k, a[j][k]);
                }
            }
            for(int j = 0; j< q; j++){
                int num = sc.nextInt();
                if(num == 1){
                    int x1 = sc.nextInt();
                    int y1 = sc.nextInt();
                    int x2 = sc.nextInt();
                    int y2 = sc.nextInt();
                    if(solve(x1, y1, x2, y2)){
                        pw.println("Yes");
                    }else{
                        pw.println("No");
                    }
                }else{
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int val = sc.nextInt();
                    modify(x, y, a[x][y] ^ val);
                    a[x][y] = val;
                }
            }
        }
    }
    public static boolean solve(int x1, int y1, int x2, int y2){
        int ret = getSum(x1, y1, x2, y2);
        if(ret != 0){
            return true;
        }else{
            return false;
        }
    }
    public static int getSum(int x1, int y1, int x2, int y2){
        return sum(x2,y2) ^ sum(x1-1, y2) ^ sum(x2, y1-1) ^ sum(x1-1, y1-1);
    }

    public static int sum(int x, int y){
        int ans = 0;
        for(int i = x; i > 0; i -= lowBit(i)){
            for(int j = y; j > 0; j-= lowBit(j)){
                ans ^= bit[i][j];
            }
        }
        return ans;
    }

    public static void modify(int x, int y, int val){
        for(int i = x; i <= n; i += lowBit(i)){
            for(int j = y; j <= m; j+= lowBit(j)){
                bit[i][j] ^= val;
            }
        }
    }

    public static int lowBit(int x){
        return x & (-x);
    }
}