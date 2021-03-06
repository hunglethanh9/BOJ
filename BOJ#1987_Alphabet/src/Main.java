import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ#1987 알파벳
 * https://www.acmicpc.net/problem/1987
 */

public class Main {

    static int R, C;
    static int[][] map = new int[21][21];

    static final int[] dRow = {0, -1, 0, 1};
    static final int[] dCol = {-1, 0, 1, 0};
    static boolean[] visited = new boolean[26];
    static int maxStep = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 1; i < R + 1; i++) {

            String s = br.readLine();
            for (int j = 1; j < C + 1; j++) {

                map[i][j] = s.charAt(j - 1) - 'A';
            }
        }

        visited[map[1][1]] = true;
        solve(1, 1, 1);

        System.out.println(maxStep);

    } // main

    static void solve(int row, int col, int step) {

        maxStep = maxStep < step ? step : maxStep;

        for (int i = 0; i < 4; i++) {

            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if (nextRow <= 0 || nextRow > R || nextCol <= 0 || nextCol > C) continue;
            if (visited[map[nextRow][nextCol]]) continue;

            visited[map[nextRow][nextCol]] = true;
            solve(nextRow, nextCol, step + 1);
            visited[map[nextRow][nextCol]] = false;
        }
    }
}
