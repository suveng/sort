/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/3/31
 * description:排序类
 **/
public class SortUtils {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};
        System.out.println("原数组");
        for (int i : arr) {
            System.out.print(i + ",");
        }

        SortUtils.sort(arr);

        System.out.print("\n排序后的\n");
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    /**
     * 排序逻辑
     * @param arr 原数组
     */
    private static void sort(int[] arr) {
        //    冒泡排序
        //    Sort.bubbleSort(arr);
        //    简单选择排序
        //Sort.simpleSelect(arr);
        //    简单插入排序
        //    Sort.simpleInsert(arr);
        //    快速排序
        //SortUtils.quickSort(arr);
        //    希尔排序
        //    SortUtils.shellSort(arr);
        //    堆排序
        //SortUtils.heapSort(arr);
        //    归并排序
        SortUtils.mergeSort(arr);
    }

    /**
     * 归并排序
     *
     * @param arr 原数组
     */
    private static void mergeSort(int[] arr) {
        mergeSort(arr,0, arr.length-1);
    }

    /**
     * 递归归并
     * @param arr 原数组
     * @param start 开始位置
     * @param end 结束位置
     */
    private static void mergeSort(int[] arr, int start, int end) {
        if (start<end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    /**
     * 归并排序 合并操作
     * @param arr 原数组
     * @param start 开始位置
     * @param mid 中间位置
     * @param end 结束位置
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr= new int[arr.length];
        int i = start;
        int j=mid+1;
        int k=i;
        while (i<=mid&&j<=end){
            if (arr[i]<=arr[j]){
                tempArr[k++]=arr[i++];
            }else {
                tempArr[k++]=arr[j++];
            }
        }
        while (i<=mid){
            tempArr[k++]=arr[i++];
        }
        while (j<=end){
            tempArr[k++]=arr[j++];
        }
        for (int n = start;n<=end;n++){
            arr[n]=tempArr[n];
        }
    }

    /**
     * 堆排序
     *
     * @param arr 原数组
     */
    private static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            SortUtils.buildMaxHeap(arr, arr.length - i - 1);
            int temp = arr[0];
            arr[0] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
            System.out.println();
        }
    }

    /**
     * 构建大根堆
     *
     * @param arr       原数组
     * @param lastIndex 最后的位置
     */
    private static void buildMaxHeap(int[] arr, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int bigChild = i * 2 + 1;
            if (bigChild + 1 <= lastIndex && arr[bigChild] < arr[bigChild + 1]) {
                bigChild++;
            }
            if (arr[bigChild] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[bigChild];
                arr[bigChild] = temp;
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param arr 原数组
     */
    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j - gap >= 0 && arr[j] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr 原数组
     */
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排递归逻辑
     * @param arr 原数组
     * @param low 低位
     * @param high 高位
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * 排序逻辑
     * @param arr 原数组
     * @param low 低位
     * @param high 高位
     * @return 中间位置
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    /**
     * 简单插入排序
     *
     * @param arr 原数组
     */
    private static void simpleInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * 简单选择排序
     *
     * @param arr 原数组
     */
    private static void simpleSelect(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

    }

    /**
     * 冒泡排序
     *
     * @param arr 原数组
     */
    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        int flag = len;
        while (flag > 0) {
            flag = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    flag = i;
                }
            }
            len = flag;
        }
    }

}
