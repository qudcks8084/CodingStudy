import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;


public class Main1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfWords = Integer.parseInt(sc.nextLine());
        String[] array = new String[numOfWords];
        for(int i = 0 ; i < numOfWords ; i++){
            array[i] = sc.nextLine();
        }
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(array));
        String[] resultArr = hashSet.toArray(new String[0]);

        quickSort(resultArr, 0, resultArr.length -1);

        for (String result : resultArr) {
            System.out.println(result);
        }
    }

    static void quickSort(String[] data, int left, int right) {
        int pl = left;
        int pr = right;
        String pivot = data[(pl + pr) / 2];

        do {
            while (compareFunction(data[pl],pivot) == 0) {
                pl++;
            }
            while (compareFunction(data[pr],pivot) == 1) {
                pr--;
            }
            if (pl <= pr) { // pl보다 pr이 크면 교환(오름차순)
                swap(data, pl++, pr--);
            }
        } while (pl <= pr);

        // 정렬 끝난 후 나누어진 두개의 그룹에 데이터 수를 체크
        if (left < pr)
            quickSort(data, left, pr); // left가 pr보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
        if (pl < right)
            quickSort(data, pl, right); // pl이 right보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
    }
    public static void swap(String[] array, int pl, int pr){
        String temp = array[pl];
        array[pl] = array[pr];
        array[pr] = temp;
    }
    public static int compareFunction(String a, String b){
        if(a.length() == b.length()){
            for(int i = 0 ; i < a.length() ; i++){
                if(a.charAt(i) > b.charAt(i)){
                    return 1;
                }else if(a.charAt(i) < b.charAt(i))
                    return 0;
            }
            return -1;
        }else if(a.length() > b.length())
            return 1;
        else
            return 0;
    }
}
