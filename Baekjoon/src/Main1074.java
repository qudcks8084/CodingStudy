import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1074 {

    static int num, fx, fy;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] info = bf.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        fx = Integer.parseInt(info[1]);
        fy = Integer.parseInt(info[2]);

        num = 0;

        visit(0,0,n);

    }

    public static void visit(int x, int y, int L){
        if(L == 1){
            for(int i = 0 ; i < 2; i++){
                if(x == fx && y+i == fy){
                    System.out.println(num);
                    return;
                }
                else num++;
            }
            for(int i = 0 ; i < 2; i++){
                if(x+i == fx && y+i == fy){
                    System.out.println(num);
                    return;
                }
                else num++;
            }
        }else{  
            int add = (int)Math.pow(2,L-1);
            visit(x,y,L-1);
            visit(x,y+add,L-1);
            visit(x+add,y,L-1);
            visit(x+add,y+add,L-1);
        }
    }
}
