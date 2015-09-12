import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNextInt()) {
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();

    }

    private static void solve(Scanner sc, PrintWriter pw) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            char[][] map = new char[n][m];
            for (int j = 0; j < n; j++) {
                map[j] = sc.next().toCharArray();
            }
            int startx = sc.nextInt() - 1;
            int starty = sc.nextInt() - 1;
            int endx = sc.nextInt() - 1;
            int endy = sc.nextInt() - 1;
            hashmap = new HashMap<Pair, Double>();
            solve(sc, pw, n, m, k, map, startx, starty, endx, endy);
        }
    }

    private static void solve(Scanner sc, PrintWriter pw, int n, int m, int k,
            char[][] map, int startx, int starty, int endx, int endy) {
        visited = new boolean[n][m];
        visited[startx][starty] = true;
        double ret = dfs(n, m, k, map, startx, starty, endx, endy, 0);
        if (ret == Integer.MAX_VALUE) {
            pw.println("No Answer");
        } else {
            pw.format("%.2f\n", ret);
        }
    }

    public static HashMap<Pair, Double> hashmap;

    static class Pair {
        int x;
        int y;
        int k;

        public Pair(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        @Override
        public boolean equals(Object pair) {
            Pair p = (Pair) pair;
            if (this.x == p.x && this.y == p.y && this.k == p.k) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.x * 99 + this.y * 9 + this.k;
        }
    }

    public static final int[] dx = { -1, 1, 0, 0 };
    public static final int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] visited;

    private static double dfs(int n, int m, int k, char[][] map, int startx,
            int starty, int endx, int endy, double cost) {
        if (k <= 0) {
            return Integer.MAX_VALUE;
        }
        Pair pair = new Pair(startx, starty, k);
        if (!hashmap.containsKey(pair)) {
            if (startx == endx && starty == endy) {
                if (!hashmap.containsKey(pair)) {
                    hashmap.put(pair, cost);
                } else {
                    hashmap.put(pair, Math.min(hashmap.get(pair), cost));
                }

            } else {
                double ret = Integer.MAX_VALUE;
                for (int i = 0; i < 4; i++) {
                    int nx = startx + dx[i];
                    int ny = starty + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m
                            && map[nx][ny] != '#' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        ret = Math.min(
                                ret,
                                dfs(n,
                                        m,
                                        k - 1,
                                        map,
                                        nx,
                                        ny,
                                        endx,
                                        endy,
                                        cost
                                                + (double) Math.abs(map[nx][ny]
                                                        - map[startx][starty])
                                                / k));
                        visited[nx][ny] = false;
                    }
                }
                hashmap.put(pair, ret);
            }
        }
        return hashmap.get(pair);
    }
}