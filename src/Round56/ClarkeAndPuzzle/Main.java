import java.util.*;
import java.io.*;
public class Main {
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
                    int x1 = sc.nextInt()-1;
                    int y1 = sc.nextInt()-1;
                    int x2 = sc.nextInt()-1;
                    int y2 = sc.nextInt()-1;
                    if(solve(x1, y1, x2, y2, a)){
                        pw.println("Yes");
                    }else{
                        pw.println("No");
                    }
                }else{
                    int x = sc.nextInt()-1;
                    int y = sc.nextInt()-1;
                    int val = sc.nextInt();
                    a[x][y] = val;
                }
            }
        }
    }
    private static boolean solve(int x1, int y1, int x2, int y2, int[][] a){
        int ret = 0;
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                ret ^= a[i][j];
            }
        }
        if(ret != 0){
            return true;
        }else{
            return false;
        }
    }
}