import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main7576 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];

        int numOfNotGoodTomato = 0; // 정답 확인용 덜익은 토마토의 개수 저장
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int c = 0 ; c < H ; c++) {
            st = new StringTokenizer(br.readLine());
            for(int r = 0 ; r < W ; r++) {
                map[c][r] = Integer.parseInt(st.nextToken());
                if(map[c][r] == 1) q.offer(new int[] {c,r});
                if(map[c][r] == 0) numOfNotGoodTomato++;
            }
        }


        int[] dc = {-1, 0, 1 ,0};
        int[] dr = {0, 1, 0, -1};
        int time = 0;
        while(true) {
            int len = q.size();
            for(int i = 0 ; i < len ; i++) {
                int[] cur = q.poll();
                for(int j = 0 ; j < 4 ; j++) {
                    int n_c = cur[0] + dc[j];
                    int n_r = cur[1] + dr[j];
                    if(n_c < 0 || n_c >= H || n_r < 0 || n_r >= W) continue;
                    if(map[n_c][n_r] == 0) {
                        numOfNotGoodTomato--;
                        map[n_c][n_r] = 1;
                        q.offer(new int[] {n_c, n_r});
                    }
                }
            }
            if(q.isEmpty()) {
                break;
            }
            time++;
        }

        if(numOfNotGoodTomato == 0) {
            System.out.println(time);
        }else {
            System.out.println("-1");
        }

    }

}
