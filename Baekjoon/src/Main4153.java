import java.io.*;


public class Main4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] target = bf.readLine().split(" ");
            int a = Integer.parseInt(target[0]);
            int b = Integer.parseInt(target[1]);
            int c = Integer.parseInt(target[2]);
            if(a == 0 && b == 0 && c == 0)
                break;
            else{
                if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a )
                    bw.write("right\n");
                else
                    bw.write("wrong\n");
            }
        }
        bw.flush();
    }
}
