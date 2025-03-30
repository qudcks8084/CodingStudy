import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 이미 해당 숫자가 사용되고 있는지 저장
        boolean[] rank = new boolean[N + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            int tmp = Integer.parseInt(br.readLine()) ;
            if(!rank[tmp]){
                rank[tmp] = true;
            }else{
                pq.add(tmp);
            }
        }


        int sum = 0;
        for(int i = 1 ; i <= N ; i++){
            if(rank[i]) continue;
            int gap = Math.abs(pq.poll() - i);
            sum += gap;
        }

        System.out.println(sum);
    }
}
