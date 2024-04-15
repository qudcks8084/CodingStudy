import java.io.*;

public class Main15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < max; i++){
            String[] a = br.readLine().split(" ");
            bw.write((Integer.parseInt(a[0]) + Integer.parseInt(a[1]) + "\n"));
        }
        bw.flush();
    }
}
