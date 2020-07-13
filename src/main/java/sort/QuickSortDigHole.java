package sort;

public class QuickSortDigHole {
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (arr == null || leftIndex > rightIndex || arr.length <= 1) {
            return;
        }
        int midIndex = partition(arr, leftIndex, rightIndex);
        quickSort(arr, leftIndex, midIndex);
        quickSort(arr, midIndex + 1, rightIndex);
    }

    private static int partition(int[] arr, int leftIndex, int rightIndex) {
        int temp = arr[leftIndex];
        while (rightIndex > leftIndex) {
            while (temp <= arr[rightIndex] && leftIndex < rightIndex) {
                --rightIndex;
            }
            if (leftIndex < rightIndex) {
                arr[leftIndex] = arr[rightIndex];
                ++leftIndex;
            }
            while (temp >= arr[leftIndex] && leftIndex < rightIndex) {
                ++leftIndex;
            }
            if (leftIndex < rightIndex) {
                arr[rightIndex] = arr[leftIndex];
                --rightIndex;
            }
        }
        arr[leftIndex] = temp;
        return leftIndex;
    }

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 3, 2, 5, 7, 3, 8};
        quickSort(arr, 0, 8);
        printArr(arr);
    }
}
