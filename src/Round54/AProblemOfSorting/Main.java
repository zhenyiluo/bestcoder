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
    static class Pair{
        String name;
        int age;
        public Pair(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
    private static void solve1(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        sc.nextLine();
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            String name = s.substring(0, s.length() - 5);
            int age = Integer.valueOf(s.substring(s.length()-4));
            pairs[i] = new Pair(name, age);
        }
        Arrays.sort(pairs, new Comparator<Pair>(){
            @Override 
            public int compare(Pair p1, Pair p2){
                return p2.age - p1.age;
            }
        });
        
        for(int i = 0; i < n; i++){
            pw.println(pairs[i].name);
        }
    }
}