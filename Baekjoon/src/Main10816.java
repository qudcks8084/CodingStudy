import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        HashMap<Integer, Integer> countMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            result.append(countMap.getOrDefault(num, 0)).append(" ");
        }

        bw.write(result.toString());
        bw.flush();
    }
}
