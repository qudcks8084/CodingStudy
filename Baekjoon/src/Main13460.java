import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13460 {

    static int H, W;
    static int min;
    static int[] O;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];

        int[] B = new int[2];    // 파랑 구슬
        int[] R = new int[2];    // 빨간 구슬
        O = new int[2];    // 구멍
        for(int c = 0 ; c < H ; c++){
            char[] line = br.readLine().toCharArray();
            for(int r = 0 ; r < W ; r++){
                char tmp = line[r];
                if(tmp == '#'){
                    map[c][r] = true;
                }

                else if(tmp == 'B'){
                    B[0] = c;
                    B[1] = r;
                }

                else if(tmp == 'R'){
                    R[0] = c;
                    R[1] = r;
                }

                else if(tmp == 'O'){
                    O[0] = c;
                    O[1] = r;
                }
            }
        }

        min = Integer.MAX_VALUE;
        perm(0, B, R);
        System.out.println(min);
    }

    public static void perm(int depth, int[] B, int[] R){
        if(depth == 11){
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            int[] NB = Arrays.copyOf(B, 2);
            int[] NR = Arrays.copyOf(R, 2);
            move(NB, NR, i);
            // 정답 처리
            int result = check(NB, NR);
            System.out.println(result);
            if(result == 1){
                min = Math.min(min, depth);
                return;
            }else if(result == -1){
                return;
            }else{
                perm(depth + 1, NB, NR);
            }
        }
    }

    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};
    public static void move(int[] B, int[] R, int d){
        if(d == 0){ // 위로 이동
            if(B[1] == R[1]){ // 둘이 r이 같은 경우 -> 둘 중에 c가 큰거부터 이동
                if(B[0] > R[0]){
                    move(B, d);
                    move(R, d);
                }else{
                    move(R, d);
                    move(B, d);
                }

            }else{ // 둘이 r이 다른 경우 -> 그냥 따로 움직이면 댐
                move(B, d);
                move(R, d);
            }
        }

        else if(d == 1){ // 오른쪽으로 이동
            if(B[0] == R[0]){ // 둘이 c가 같은 경우 -> 둘 중에 r이 큰거부터 이동
                if(B[1] > R[1]){
                    move(B, d);
                    move(R, d);
                }else{
                    move(R, d);
                    move(B, d);
                }
            }else{
                move(R, d);
                move(B, d);
            }
        }

        else if(d == 2){ // 왼쪽으로 이동
            if(B[1] == R[1]){ // 둘이 r이 같은 경우 -> 둘 중에 c가 작은거부터 이동
                if(B[0] < R[0]){
                    move(B, d);
                    move(R, d);
                }else{
                    move(R, d);
                    move(B, d);
                }

            }else{ // 둘이 r이 다른 경우 -> 그냥 따로 움직이면 댐
                move(B, d);
                move(R, d);
            }
        }

        else if(d == 3){ // 아래쪽으로 이동
            if(B[0] == R[0]){ // 둘이 c가 같은 경우 -> 둘 중에 r이 작은거부터 이동
                if(B[1] < R[1]){
                    move(B, d);
                    move(R, d);
                }else{
                    move(R, d);
                    move(B, d);
                }
            }else{
                move(R, d);
                move(B, d);
            }
        }
    }

    public static void move(int[] node, int d){
        int c = node[0];
        int r = node[1];
        int n_c, n_r;
        while(true){
            n_c = c + dc[d];
            n_r = r + dr[d];
            if(n_c < 0 || n_c >= H || n_r < 0 || n_r >= W) break;
            if(map[n_c][n_r]) break; // 다음 위치가 벽이라면 종료
            if(n_c == O[0] && n_r == O[1]){ // 구멍에 도달한 경우
                node[0] = n_c;
                node[1] = n_r;
                break;
            }

            // 빈 공간인 경우
            c = n_c;
            r = n_r;
        }

        node[0] = c;
        node[1] = r;
    }

    public static int check(int[] B, int[] R){
        if(R[0] == O[0] && R[1] == O[1]){ // 빨간 구슬이 구멍이 들어간 경우
            if(B[0] == R[0] && B[1] == B[1]){ // 파란 구슬도 같이 들어간 경우
                return -1; // 불가능
            }else{
                return 1;// 답을 찾음, 값을 갱신
            }
        }else if(B[0] == O[0] && B[1] == O[1]){ // 파랑만 구멍엗 들어간 경우
            return -1;
        }
        return 0; // 나머지는 그냥 탐색하면 됨
    }

    public static void print(int[] B, int[] R){
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < H; c++) {
            for(int r = 0 ; r < W ; r++){
                if(B[0] == c && B[1] == r) sb.append("B ");
                else if(R[0] == c && R[1] == r) sb.append("R ");
                else if(O[0] == c && O[1] == r) sb.append("O ");
                else sb.append(map[c][r] ? "# " : "_ ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
