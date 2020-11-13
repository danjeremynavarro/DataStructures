package sort;

class QuickSort {

    public static void main (String[] args){
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
        Sorter.quickSort(arr, 0, arr.length-1);
        System.out.println("Done");
    }
}

class Sorter {
    public static void quickSort (int[] arr, int left, int right){
        if (left < right){
            int pivot = part(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, left + 1, right);
        }
    }

    private static int part (int[] arr, int left, int right){

        int pivot = arr[right];
        int leftPointer = (left - 1);

        for (int i = left; i < right; i++){
            if (arr[i] < pivot){
                leftPointer++;

                int dataTemp = arr[leftPointer];
                arr[leftPointer] = arr[i];
                arr[i] = dataTemp;
            }
        }

        int dataTemp = arr[leftPointer + 1];
        arr[leftPointer + 1] = arr[right];
        arr[right] = dataTemp;
        return leftPointer+1;
    }
}
