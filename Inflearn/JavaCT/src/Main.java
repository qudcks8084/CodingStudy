
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
class Main {
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dy = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        dy[0] = 1;
        for(int i = 1 ; i < n ; i++){
            int cnt = 0;
            for(int j = i-1 ; j >= 0 ; j--){
                if(arr[i] > arr[j]){
                    cnt = Math.max(cnt, dy[j]);
                }
            }
            if(cnt == 0) dy[i] = 1;
            else dy[i] = cnt + 1;
        }

        System.out.println(Arrays.stream(dy).max().getAsInt());
    }
}