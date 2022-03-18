package lab;

public class Main {
    public static int random() { //Generate random number from 100 to 1000
        return (int) (Math.random() * 900) + 100;
    }

    public static void printArray(String text, int[] arr) {
        System.out.print(text + "[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i + 1 != arr.length ? ", " : "]\n"));
        }
    }

    public static void swap(int[] arr, int idA, int idB){
        int buff = arr[idA];
        arr[idA] = arr[idB];
        arr[idB] = buff;
    }

    public static void sortArray(int[] arr){ //bubble sorting function
        boolean isSorted;
        for(int i = 0; i < arr.length; i++){
            isSorted = true;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                    isSorted = false;
                }
            }
            if(isSorted) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) { //fill array
            arr[i] = random();
        }
        printArray("Generated array: ", arr);
        sortArray(arr);
        printArray("Sorted array: ", arr);
    }
}
