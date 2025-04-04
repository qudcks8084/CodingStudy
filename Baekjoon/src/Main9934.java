import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9934 {

    static byte N;
    static short[] num;
    static StringBuilder[] sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Byte.parseByte(br.readLine());
        short size = (short)((1 << N) - 1);

        num = new short[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < size ; i++){
            num[i] = Short.parseShort(st.nextToken());
        }

        sb = new StringBuilder[N];
        for(int i = 0 ; i < N ; i++){
            sb[i] = new StringBuilder();
        }

        find(0, 0, size - 1);

        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            answer.append(sb[i].toString()).append("\n");
        }
        System.out.println(answer);

    }

    public static void find(int depth, int start, int end){
        if(depth == N) return;
        int mid = (start + end) / 2;
        sb[depth].append(num[mid]).append(" ");

        find(depth + 1, start, mid - 1);
        find(depth + 1, mid + 1, end);
    }
}
