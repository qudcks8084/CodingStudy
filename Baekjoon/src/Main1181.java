import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;


public class Main1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfWords = Integer.parseInt(sc.nextLine());
        String[] array = new String[numOfWords];
        String temp ;
        for(int i = 0 ; i < numOfWords ; i++){
            array[i] = sc.nextLine();
        }
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(array));
        String[] resultArr = hashSet.toArray(new String[0]);

        boolean swapped = false;
        for (int i = 0; i < resultArr.length - 1; i++) {
            for (int j = 0; j < resultArr.length - 1 ; j++) {
                if (compareFunction(resultArr[j],resultArr[j+1]) == 1) {
                    temp = resultArr[j];
                    resultArr[j] = resultArr[j+1];
                    resultArr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }



        for (String result : resultArr) {
            System.out.println(result);
        }

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
