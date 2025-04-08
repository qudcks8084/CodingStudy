
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2568_2 {
    static final int max = 500_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] paper = new int[max];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            paper[idx] = value;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        ArrayList<Integer> lis = new ArrayList<>();

        int index = -1;

        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < max ; i++) {

            if (paper[i] == 0)  continue;

            int idx = Collections.binarySearch(lis, paper[i]);

            if (idx < 0) {
                idx = -1 * (idx + 1);
            }


            if (idx == lis.size()) {
                lis.add(paper[i]);
                dp.add(index);
            }else{
                result.add(dp.get(idx));
                lis.set(idx, paper[i]);
                dp.set(idx, index);
            }

            // System.out.println();
            // for (Integer integer : dp) {
            // System.out.print(integer + " ");
            // }
            // System.out.println();
            // for (Integer integer : lis) {
            // System.out.print(integer + " ");
            // }
            // System.out.println();
        }
        Collections.sort(result);
        // System.out.println(n - lis.size());
        sb.append(n - lis.size()).append("\n");

        for (Integer integer : result) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
        // System.out.println(Arrays.toString(paper));
    }
}
