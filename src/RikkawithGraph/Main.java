import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNextInt()){
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();

    }
    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] edges = new boolean[n][n];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a-1][b-1] = true;
            edges[b-1][a-1] = true;
        }
        pw.print(1 + " ");
        if(edges[0][n-1]){
            pw.println(n * (n-1) / 2);
        }else{
            pw.println(1);
        }
    }
}