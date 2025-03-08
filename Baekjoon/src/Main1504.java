import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {

    static class Vertex implements Comparable<Vertex>{
        int v, w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int N, E;
    static int A, B;
    static ArrayList<Vertex>[] adjList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 간선 정보를 저장할 adjList를 생성 및 초기화
        adjList = new ArrayList[N];
        for(int i = 0 ; i < N ; i++){
            adjList[i] = new ArrayList<>();
        }

        // 간선 정보를 저장
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            adjList[s].add(new Vertex(e, w));
            adjList[e].add(new Vertex(s, w));
        }

        // 거쳐야 하는 2 정점을 입력받는다.
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;

        // 총 3번의 다익스트라를 실행
        // 시작점 1번 노드에서의 각 노드별 최단거리
        // 중간점 A에서의 각 노드별 최단거리
        // 중간점 B에서의 각 노드별 최단거리
        int[] start_node = {0, A, B};
        int[][] dp = new int[3][N];
        for(int i = 0 ; i < 3 ; i ++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < 3 ; i++){
            int start = start_node[i];

            // 최종 경로 확정 관리를 위한 visited
            boolean[] visited = new boolean[N];

            PriorityQueue<Vertex> pq = new PriorityQueue<>();
            pq.offer(new Vertex(start, 0));

            while (!pq.isEmpty()) {
                Vertex cur = pq.poll();
                int v = cur.v;
                int w = cur.w;
                if(visited[v]) continue;
                visited[v] = true;
                dp[i][v] = w;
                for(Vertex next : adjList[v]){
                    int n_v = next.v;
                    int n_w = next.w;
                    if(dp[i][n_v] > w + n_w){
                        dp[i][n_v] = w + n_w;
                        pq.offer(new Vertex(n_v, w + n_w));
                    }
                }
            }

        }

        // 기본 경로 2가지 계산
        int path1 = dp[0][A] + dp[1][B] + dp[2][3]; // 0 -> A -> B -> N
        int path2 = dp[0][B] + dp[2][A] + dp[1][3]; // 0 -> B -> A -> N

        // 추가 경로: 0 -> A -> B -> A -> N
        int path3 = dp[0][A] + dp[1][B] + dp[2][A] + dp[1][3];

        // 추가 경로: 0 -> B -> A -> B -> N
        int path4 = dp[0][B] + dp[2][A] + dp[1][B] + dp[2][3];

        // 최소값 계산
        int min_distance = Math.min(Math.min(path1, path2), Math.min(path3, path4));

        // 모든 경로가 불가능한 경우 확인
        if (min_distance >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min_distance);
        }

    }

}
