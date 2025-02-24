import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11724 {

    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for(int i = 0 ; i < N ; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new boolean[N];

        int numOfGroup = 0;
        for(int i = 0 ; i < N ; i++){
            if(!visited[i]){
                numOfGroup++;
                connect(i);
            }
        }
        System.out.println(numOfGroup);
    }

    public static void connect(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adjList[cur]) {
                if(visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}
