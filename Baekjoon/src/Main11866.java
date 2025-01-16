import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> Q = new ArrayDeque<>();

        // 사람 입력하기
        for(int i = 0 ; i < n ;i++){
            Q.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!Q.isEmpty()) {
            for(int i = 0 ; i< k ; i++){
                if(i == k-1){
                    if(Q.size() == 1) sb.append(Q.poll());
                    else sb.append(Q.poll()).append(", ");
                }else{
                    Q.offer(Q.poll());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
