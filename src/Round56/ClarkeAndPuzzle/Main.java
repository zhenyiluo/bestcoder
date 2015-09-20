import java.util.*;
import java.io.*;
public class Main {

    static int[][] sum;
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
            int m = sc.nextInt();
            sum = new int[n+1][m+1];
            int q = sc.nextInt();
            int[][] a = new int[n][m];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    a[j][k] = sc.nextInt();
                }
            }
            for(int j = 0; j< q; j++){
                int num = sc.nextInt();
                if(num == 1){
                    int x1 = sc.nextInt();
                    int y1 = sc.nextInt();
                    int x2 = sc.nextInt();
                    int y2 = sc.nextInt();
                    if(solve(x1, y1, x2, y2, a)){
                        pw.println("Yes");
                    }else{
                        pw.println("No");
                    }
                }else{
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int val = sc.nextInt();
                    a[x][y] = val;
                }
            }
        }
    }
    private static boolean solve(int x1, int y1, int x2, int y2, int[][] a){
        int ret = 0;
        ret = getSum(x1, y1, x2, y2);
        if(ret != 0){
            return true;
        }else{
            return false;
        }
    }
    public static int getSum(int x1, int y1, int x2, int y2){
        return sum[x2][y2] ^ sum[x1-1][y2] ^ sum[x2][y1-1] ^ sum[x1-1][y1-1];
    }
}