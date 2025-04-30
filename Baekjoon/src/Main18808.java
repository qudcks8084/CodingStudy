import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18808 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[H][W];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int PH = Integer.parseInt(st.nextToken());
            int PW = Integer.parseInt(st.nextToken());

            boolean[][] sticker = new boolean[H][W];
            for(int c = 0 ; c < PH ; c++){
                st = new StringTokenizer(br.readLine());
                for(int r = 0 ; r < PW ; r++){
                    sticker[c][r] = st.nextToken().equals("1");
                }
            }

        }
    }
}

