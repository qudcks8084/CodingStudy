
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2631_2 {

    static int N, M, hour, cnt_cheese, cnt_hole;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0, }, dc = { 0, 0, -1, 1 };
    static ArrayList<Integer> nums;

    public static void function(int r, int c) { // 삭제할 치즈 3로 바꾸기
        for (int i = 0; i < 4; i++) {
            if (r + dr[i] < 0 || r + dr[i] >= N || c + dc[i] < 0 || c + dc[i] >= M)
                continue;
            if (map[r + dr[i]][c + dc[i]] == 2) {
                map[r][c] = 3;
                cnt_cheese--;
                cnt_hole++;
                break;
            }
        }
    }

    public static void check(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int z = 1;
            while (true) {
                if (r + dr[i] * z < 0 || r + dr[i] * z >= N || c + dc[i] * z < 0 || c + dc[i] * z >= M)
                    break;
                if (map[r + dr[i] * z][c + dc[i] * z] == 1) {
                    cnt++;
                    break;
                }
                z++;
            }
        }
        if (cnt < 4) {// 사라졌으면 bfs통해 0->2
            bfs(r, c);
        }
    }

    public static void bfs(int i, int j) {// 외부공기->2
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { i, j });
        boolean[][] visited = new boolean[N][M];
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            for (int k = 0; k < 4; k++) {
                if (r + dr[k] < 0 || r + dr[k] >= N || c + dc[k] < 0 || c + dc[k] >= M)
                    continue;
                if (!visited[r + dr[k]][c + dc[k]] && map[r + dr[k]][c + dc[k]] == 0) {
                    visited[r + dr[k]][c + dc[k]] = true;
                    q.add(new int[] { r + dr[k], c + dc[k] });
                    map[r + dr[k]][c + dc[k]] = 2;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    cnt_hole++;
                if (map[i][j] == 1)
                    cnt_cheese++;
            }
        }

        print();

        bfs(0, 0);

        while (N * M != cnt_hole) {

            nums.add(cnt_cheese);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        function(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 3) {
                        map[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        check(i, j);
                    }
                }
            }
            hour++;

        }

        print();
        nums.add(cnt_cheese);
        //System.out.println(nums);
        System.out.println(hour);
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) != 0) {
                System.out.println(nums.get(i));
                break;
            }
        }



    }

    public static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2) sb.append("  ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
