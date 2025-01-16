import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String[] tmp = bf.readLine().split(" ");
            arr.add(new Node(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Node node : arr) {
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }

        System.out.println(sb);
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x)
                return this.y - o.y;
            else
                return this.x - o.x;
        }
    }
}
