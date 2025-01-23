import java.util.Arrays;
import java.util.Scanner;

public class Main2448 {

    static char[][] map;
    static char[][] tri = {
            {'*','*','*','*','*',' '},
            {' ','*',' ','*',' ',' '},
            {' ',' ','*',' ',' ',' '}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        map = new char[n][2*n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 2*n ; j++){
                map[i][j] = ' ';
            }
        }

        draw(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0; j < 2*n ; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void draw(int x, int y, int n) {
        if(n == 3){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < 2*n ; j++){
                    map[x+i][y+j] = tri[i][j];
                }
            }
        }else{
            draw(x, y, n / 2);
            draw(x, y+n, n / 2);
            draw(x+n/2, y+n/2, n/2);
        }
    }
}
