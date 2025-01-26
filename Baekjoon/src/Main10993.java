import java.util.Scanner;

public class Main10993 {

    static char[][] map;
    static int[] size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        size = new int[n];
        size[0] = 1;
        for(int i = 1 ; i < n ; i++){
            size[i] = 2 * (size[i-1] + 1) + 1;
        }

        map = new char[size[n-1]/2+1][size[n-1]];

        for (int i = 0; i < size[n - 1] / 2 + 1; i++) {
            for (int j = 0; j < size[n - 1]; j++) {
                map[i][j] = ' ';
            }
        }

        Triangle(n, 0, size[n - 1] / 2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size[n - 1] / 2 + 1; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < size[n - 1]; j++) {
                line.append(map[i][j]);
            }
            sb.append(line.toString().stripTrailing()).append("\n"); // 오른쪽 공백 제거
        }

        System.out.println(sb);

    }

    public static void Triangle(int depth, int x, int mid){
        if(depth == 1){
            map[x][mid] = '*';
            return;
        }
        if(depth % 2 == 1){
            map[x][mid] = '*';
            for(int i = 1 ; i < size[depth-1]/2 ; i++){
                map[x + i][mid - i] = '*';
                map[x + i][mid + i] = '*';
            }
            for(int i = 0 ; i < size[depth-1] ; i++){
                map[(size[depth - 1]) / 2 + x][mid-size[depth-1]/2+i] = '*';
            }

            Triangle(depth-1,x + size[depth-1]/4, mid);

        }else {
            int bottom = size[depth - 1] / 2;
            map[x + bottom][mid] = '*';
            for(int i = 0 ; i < size[depth-1] ; i++){
                map[x][mid - bottom + i] = '*';
            }
            for(int i = 1 ; i < bottom ; i++){
                map[x + i][mid + bottom - i] = '*';
                map[x + i][mid - bottom + i] = '*';
            }

            Triangle(depth - 1, x+1, mid);
        }
    }
}
