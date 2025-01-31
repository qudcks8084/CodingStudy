import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class Point {
        int x, y, distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[j][i] = line[j] - '0';
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx == M-1 && ny == N-1) {
                    System.out.println(current.distance + 1);
                    return;
                }

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, current.distance + 1));
                }
            }
        }
    }

}