
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_프로세서 {

    static int N;
    static int[][] cpu;
    static int[][] map;
    static int[] dc = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dr = {0, 0, -1, 1};
    static int max_cpu, min_len;
    static int total_cpu;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            total_cpu = 0;

            // 먼저 전체 맵을 읽고 CPU 개수 파악
            StringTokenizer st;
            for(int c = 0; c < N; c++) {
                st = new StringTokenizer(br.readLine());
                for(int r = 0; r < N; r++) {
                    int input = Integer.parseInt(st.nextToken());
                    if(input > 0) {
                        map[c][r] = input;
                        total_cpu++;
                    }
                }
            }

            // CPU 좌표만 따로 저장
            cpu = new int[total_cpu][2];
            int index = 0;
            for(int c = 0; c < N; c++) {
                for(int r = 0; r < N; r++) {
                    if(map[c][r] > 0) {
                        cpu[index][0] = c;
                        cpu[index][1] = r;
                        index++;
                    }
                }
            }

            max_cpu = 0;
            min_len = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append("#").append(testcase).append(" ").append(min_len).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int numOfCore, int lenOfLine) {
        // 남은 코어를 모두 연결해도 현재 최대 연결 코어수보다 작다면 탐색 중단
        if(total_cpu - depth + numOfCore < max_cpu) return;

        if(depth == total_cpu) { // 모든 코어를 고려했을 때
            if(numOfCore > max_cpu) { // 코어수가 더 많으면 무조건 갱신
                max_cpu = numOfCore;
                min_len = lenOfLine;
            } else if(numOfCore == max_cpu && lenOfLine < min_len) { // 코어수 같으면 길이가 짧은 것 선택
                min_len = lenOfLine;
            }
            return;
        }

        int c = cpu[depth][0];
        int r = cpu[depth][1];

        // 가장자리에 있는 코어는 이미 연결된 것으로 처리
        if(c == 0 || c == N-1 || r == 0 || r == N-1) {
            dfs(depth + 1, numOfCore + 1, lenOfLine);
            return;
        }

        // 각 방향으로 연결 시도
        for(int i = 0; i < 4; i++) {
            int numOfLine = checkDirection(c, r, i);
            if(numOfLine >= 0) { // 연결 가능한 경우
                dfs(depth + 1, numOfCore + 1, lenOfLine + numOfLine);

                // 복구 작업
                int nc = c;
                int nr = r;
                for(int j = 0; j < numOfLine; j++) {
                    nc += dc[i];
                    nr += dr[i];
                    map[nc][nr] = 0;
                }
            }
        }

        // 현재 코어를 연결하지 않는 경우
        dfs(depth + 1, numOfCore, lenOfLine);
    }

    public static int checkDirection(int c, int r, int direction) {
        int originValue = map[c][r];
        int line = 0;

        int nc = c;
        int nr = r;

        while(true) {
            nc += dc[direction];
            nr += dr[direction];

            // 맵 끝에 도달한 경우 성공
            if(nc < 0 || nc >= N || nr < 0 || nr >= N) {
                return line;
            }

            // 다른 코어나 선과 충돌한 경우 실패
            if(map[nc][nr] > 0) {
                // 복구 작업
                int restore_c = c;
                int restore_r = r;

                for(int i = 0; i < line; i++) {
                    restore_c += dc[direction];
                    restore_r += dr[direction];
                    map[restore_c][restore_r] = 0;
                }

                return -1;
            }

            // 성공적으로 진행
            map[nc][nr] = originValue;
            line++;
        }
    }

}

