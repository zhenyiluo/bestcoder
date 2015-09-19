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
            int[] a = new int[n];
            int[] b = new int[n];
            for(int j = 0; j < n; j ++){
                a[j] = sc.nextInt();
                b[j] = sc.nextInt();
            }
            int ret = solve(n, a, b);;
            pw.println(ret);
        }
    }

    private static int solve(int n, int[] a, int[] b){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            if(hm.containsKey(a[i])){
                hm.put(a[i], hm.get(a[i]) + b[i]);
            }else{
                hm.put(a[i], b[i]);
            }
        }
        int count = 0;
        for(int val : hm.values()){
            count += Math.ceil((double)val / 64);
        }
        return (int)Math.ceil((double)count / 36);
    }
}