import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] arr = new int[k];
        long max = 0; // 최대 길이를 저장할 변수

        // 랜선 길이 입력받기
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]); // 최대 길이 갱신
        }

        long min = 1; // 최소 길이 (0은 나눗셈에서 에러가 발생하므로 1로 설정)
        long result = 0;

        // 이진 탐색
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            // mid 길이로 자른 랜선 개수 계산
            for (int j = 0; j < k; j++) {
                count += arr[j] / mid;
            }

            // 랜선 개수가 충분한 경우 더 긴 길이를 시도
            if (count >= n) {
                result = mid; // 가능한 최대 길이를 저장
                min = mid + 1;
            } else { // 랜선 개수가 부족한 경우 더 짧은 길이를 시도
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}
