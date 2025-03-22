import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13460_2 {

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



        System.out.println("B " + Arrays.toString(B));
        System.out.println("R " + Arrays.toString(R));
        System.out.println("O " + Arrays.toString(O));
    }

    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};
    public static boolean move(int[] Ball, int d){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        return true;
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
