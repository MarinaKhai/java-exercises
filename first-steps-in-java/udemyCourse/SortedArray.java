import java.util.Scanner;
import java.util.Arrays;

public class SortedArray {
    public static int[] getIntegers(int length) {
        Scanner sc = new Scanner(System.in);
        int[] myArr = new int[length];
        for(int i = 0; i < length; i++) {
            myArr[i] = sc.nextInt();
        }
        return myArr;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element " + i + " contents " + arr[i]); 
        }
    }
    public static int[] sortIntegers(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;
            for(int i = 0; i < sortedArr.length-1; i++) {
                if (sortedArr[i] < sortedArr[i+1]) {
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i+1];
                    sortedArr[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        printArray(sortIntegers(getIntegers(5)));
    }
}