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
        ArrayList<Long> list = new ArrayList<Long>();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            ArrayList<Long> ret = findPrimes(a[i]);
            if(ret.size() >0){
                list.addAll(ret);
            }
        }
        if(list.size() <2){
            pw.println(-1);
        }else{
            Collections.sort(list);
            pw.println((long)list.get(0) * list.get(1));
        }
    }
    
    private static ArrayList<Long> findPrimes(long n){
        ArrayList<Long> ret = new ArrayList<Long>();
        if(n == 1){
            return ret;
        }
        while(n % 2 == 0){
            ret.add(2l);
            n = n/2;
        }
        if(ret.size() > 1){
            return ret;
        }
        for(long i = 3; i * i <= n; i+=2){
            if(n % i == 0){
                ret.add(i);
                n = n/i;
            }
            if(ret.size() > 1){
                return ret;
            }
        }
        if(ret.size() > 1){
            return ret;
        }
        if(n > 2){
            ret.add(n);
        }
        return ret;
    }
}