import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main10773_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        LinkedList<Integer> arr = new LinkedList<>();

        int size = 0;
        for(int i = 0 ; i < k ; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                size--;
                arr.remove(size);
            }else{
                size++;
                arr.add(tmp);
            }
        }

        int answer = 0;
        for (int i : arr) {
            answer += i;
        }
        System.out.println(answer);
    }
}
