import java.util.Arrays;

public class ReversedArray {
    //reverse using helper array;
    public static void reverse(int[] arr) {
        System.out.println("Array before reverse(): " + Arrays.toString(arr));

        int[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[temp.length-i-1];
        }

        System.out.println("Array after reverse(): " + Arrays.toString(arr) + "\n");
    }

    //reverse by swap (using helper int variable, don't need additional array)
    public static void reverseSwap(int[] arr) {
        System.out.println("Array before reverseSwap(): " + Arrays.toString(arr));

        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        
        System.out.println("Array after reverseSwap(): " + Arrays.toString(arr) + "\n");
    }

    // Less steps. (how is this algo called?)
    // Use recursion (arr.length = arr.length/2)
    // Swap halves until arr.length < 2;
    public static void reverseOtherSort(int[] arr, int length) {
        System.out.println("Array before reverseOtherSort(): " + Arrays.toString(arr));
        int[] temp = new int[length];
        int tempInt = 0;
        int counter;
        if (arr.length < 2) {
            System.out.println("Arr.length < 2: " + arr.length);
            if(arr.length == 1) {
                tempInt = arr[length-1];
                return;
            }
            return;
        }
        else {
            temp = new int[length];
            reverseOtherSort(temp, length / 2);
            //swap halves (arr.length/2)
            //swap halves (arr.length/2 /2)
            //swap halves (arr.length/2 /2 /2)
            //until arr.length < 2;
        }

        System.out.println("Array after reverseOtherSort(): " + Arrays.toString(arr) + "\n");
    }

    public static void main(String[] args) {
        //reverse(new int[] {7, 6, 5, 4, 3, 2, 1});
        //reverseSwap(new int[] {7, 6, 5, 4, 3, 2, 1});
        reverseOtherSort(new int[] {7, 6, 5, 4, 3, 2, 1, 0}, 8);
    }
}
