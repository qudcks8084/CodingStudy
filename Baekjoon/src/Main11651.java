import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SimpleTimeZone;

public class Main11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String[] input = br.readLine().split(" ");
            arr.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Node node : arr) {
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }

        System.out.println(sb);
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(o.y == this.y) return this.x - o.x;
            return this.y - o.y;
        }
    }
}
