package algo.sorting;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] list = new int[100000];
        initialize(list);
//        heapSort(list);
        System.out.println(isSorted(list));
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    swap(list, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[index]) {
                    index = j;
                }
            }
            swap(list, i, index);
        }
    }

    public static void mergeSort(int[] list) {
        mergeSort(list, 0, list.length - 1);
    }

    private static void mergeSort(int[] list, int low, int high) {
        if (low == high) {
            return;
        }

        int middle = (low + high) / 2;
        // Sort left
        mergeSort(list, low, middle);
        //Sort right
        mergeSort(list, middle + 1, high);
        merge(list, low, middle, high);

    }

    public static void mergeSortIterative(int[] list) {
        int length = list.length;
        for (int i = 1; i < length; i = i * 2) {
            for (int low = 0; low < length; low += i * 2) {
                int mid = Math.min(low + i - 1, length - 1);
                int high = Math.min(low + 2 * i - 1, length - 1);
                merge(list, low, mid, high);
            }
        }
    }

    private static void merge(int[] list, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= high) {
            if (list[i] > list[j]) {
                temp[k] = list[j];
                j++;
            } else {
                temp[k] = list[i];
                i++;
            }
            k++;
        }

        while (i <= middle) {
            temp[k] = list[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = list[j];
            j++;
            k++;
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, list, low, temp.length);
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }

    private static int partition(int[] list, int low, int high) {
        randomPivot(list, low, high);

        int pivot = low - 1;
        for (int i = low; i <= high; i++) {
            if (list[i] <= list[high]) {
                pivot++;
                swap(list, pivot, i);
            }
        }
        return pivot;

    }

    private static void randomPivot(int[] list, int low, int high) {
        int rand = returnRandom(low, high);
        swap(list, rand, high);
    }

    public static void heapSort(int[] list) {
        // Converting array to maxHeap
        for (int i = list.length - 1; i >= 0; i--) {
            heapify(list, i, list.length - 1);
        }

        // Sorting array
        for (int i = list.length - 1; i > 0; i--) {
            swap(list, i, 0);
            heapify(list, 0, i - 1);
        }
    }

    // Performing heapify on the node at given nodeIndex till the array index of rightBound (inclusive)
    private static void heapify(int[] list, int nodeIndex, int rightBound) {

        while (nodeIndex * 2 + 1 <= rightBound) { // Checking if left child exists
            int leftChild = nodeIndex * 2 + 1; // Getting index of left child
            int rightChild = nodeIndex * 2 + 2; // Getting index of right child

            // Checking if right child exists and if so checking if it is higher than left child
            if (rightChild <= rightBound && list[rightChild] > list[leftChild]) {
                // Checking if right child is greater than current node
                if (list[rightChild] > list[nodeIndex]) {
                    swap(list, rightChild, nodeIndex);
                    nodeIndex = rightChild;
                } else {
                    // if right child is not greater than current node exiting the loop
                    break;
                }
            }
            // If right child does not exist or right child is not greater than current node then comparing current node and left child
            else if (list[leftChild] > list[nodeIndex]) {
                swap(list, leftChild, nodeIndex);
                nodeIndex = leftChild;
            } else {
                break;
            }
        }
    }

    // Initializing list with random values between 0 and 1,000,000
    private static void initialize(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int temp = returnRandom(0, 1000000);
            list[i] = temp;
        }
    }

    // Swapping values
    private static void swap(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    // Checks if array is sorted
    public static boolean isSorted(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i - 1] > list[i]) {
                return false;
            }
        }
        return true;
    }

    // Returns random values between lowerBound (inclusive) and upperBound (inclusive)
    public static int returnRandom(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
    }
}
