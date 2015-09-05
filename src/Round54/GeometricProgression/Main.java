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
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            solve1(sc, pw);
        }
    }
    
    private static void solve1(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        double[] a = new double[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextDouble();
        }
        if(n == 1){
            pw.println("Yes");
            return;
        }
        if(Double.compare(a[0], 0)==0){
            for(int i = 1; i < n; i++){
                if(Double.compare(a[i], 0)!= 0){
                    pw.println("No");
                    return;
                }
            }
            pw.println("Yes");
            return;
        }
        
        for(int i = 1; i < n; i++){
            if(a[i] == 0){
                pw.println("No");
                return;
            }
        }
        
        if(n ==2){
            pw.println("Yes");
            return;
        }
        
        for(int i = 1; i < n-1; i++){
            double d1 = (double)a[i] / a[i-1];
            double d2 = (double)a[i+1]/ a[i];
            if(Double.compare(d1, d2) != 0){
                pw.println("No");
                return;
            }
        }
        pw.println("Yes");
    }
    
}