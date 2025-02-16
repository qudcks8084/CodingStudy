import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main17071 {
    static final int MAX = 500_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 홀수/짝수 시간대별 방문 체크를 위한 2차원 배열
        boolean[][] visited = new boolean[2][MAX + 1];

        if (N == K) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[0][N] = true;

        int time = 0;
        while (!q.isEmpty()) {
            time++;
            K += time;

            // 동생이 범위를 벗어난 경우
            if (K > MAX) {
                System.out.println(-1);
                return;
            }

            int len = q.size();
            int parity = time % 2; // 현재 시간의 홀짝 여부

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                    if (next < 0 || next > MAX || visited[parity][next]) continue;

                    if(next == K){
                        System.out.println(time);
                        return;
                    }
                    visited[parity][next] = true;
                    q.offer(next);
                }
            }
        }

        System.out.println(-1);
    }
}