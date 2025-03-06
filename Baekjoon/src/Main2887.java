import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2887 {

    static class P implements Comparable<P>{
        long v, w;

        public P(long v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(P o) {
            return Long.compare(this.w, o.w);
        }
    }

    static int N;
    static long[][] planet;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        planet = new long[N][3];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            planet[i][0] = Long.parseLong(st.nextToken());
            planet[i][1] = Long.parseLong(st.nextToken());
            planet[i][2] = Long.parseLong(st.nextToken());
        }

        long min = prim();
        System.out.println(min);
    }

    public static long prim() {
        long min = 0;
        boolean[] visited = new boolean[N];
        ArrayDeque<P> pq = new ArrayDeque<>();

        // 시작 노드 방문 표시
        pq.offer(new P(0, 0)); // 시작 노드의 가중치는 0

        int cnt = 0;
        while (!pq.isEmpty() && cnt < N) {
            P cur = pq.poll();
            int v = (int)cur.v;

            // 이미 방문한 노드라면 스킵
            if(visited[v]) continue;

            // 노드 방문 처리
            visited[v] = true;
            min += cur.w;
            cnt++;

            // 현재 노드에서 모든 미방문 노드들과의 간선 중 최소 비용 간선 추가
            long n_v = 0;
            long w = Integer.MAX_VALUE;
            for(int n_i = 0; n_i < N; n_i++) {
                if(visited[n_i]) continue;
                long dist = getDistance(planet[v], planet[n_i]);
                if(w > dist){
                    w = dist;
                    n_v = n_i;
                }
            }
            pq.offer(new P(n_v, w));
        }
        return min;
    }

    public static long getDistance(long[] first, long[] next){
        long x = Math.abs(first[0] - next[0]);
        long y = Math.abs(first[1] - next[1]);
        long z = Math.abs(first[2] - next[2]);
        return Math.min(x, Math.min(y, z));
    }
}
