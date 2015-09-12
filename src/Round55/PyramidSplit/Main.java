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
        for(int i = 0 ; i < T; i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt(); 
            }
            for(int j = 0; j < n; j++){
                b[j] = sc.nextInt(); 
            }
          double ret = solve(n, a, b);
//          pw.println(ret);
          pw.println((int)ret);
        }
    }
    private static double solve(int n, int[] a, int[] b){
        double total = 0;
        for(int i = 0; i < n; i++){
            total += a[i] * b[i] * b[i];
        }
        double left = 1; 
        double right = 1000;
        double ret = 0;
        double best = 1e9;
        while(right - left > 0.00001){
            double mid = (left + right) / 2;
            double tmp = calc(mid, n, a, b) *2 - total;
            if(Math.abs(tmp) <best){ 
                ret = mid;
                best = Math.abs(tmp);
            }
            if(tmp < 0){
                right = mid;
            }else{
                left = mid;
            }
        }
        return ret;
    }
    private static double calc(double mid, int n, int[] a, int[] b){
        double sum = 0;
        for(int i = 0; i < n; i++){
            if(a[i] <= mid){
                continue;
            }
            sum += (double) b[i] * b[i] * (a[i] - mid) * (a[i] - mid) * (a[i] -mid)/ (a[i] * a[i]);
        }
        return sum;
    }
}