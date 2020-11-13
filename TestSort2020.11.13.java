import java.util.Arrays;
import java.util.Random;


public class TestSort {

    /**
     * 稳定性：稳定
     * 时间复杂度：
     *          最好情况下：O(n)      数组中的数据是有序的
     *          最坏情况下：O(n^2)   数组中的数据是无序的
     * 空间复杂度：O(1)
     * 特点：越有序  越快
     * @param array
     */
    public static void insertSort(int[] array) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    //
    public static void shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i=i+1) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0 ; j=j-gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     * 稳定性：不稳定的排序
     * 时间复杂度：O(n^1.3)  -  O(n^1.5)
     * 空间复杂度：O(1)
     * @param array
     */
    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length ; i++) {
            shell(array,drr[i]);
        }
    }

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void selectSort(int[] array) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void adjustDown(int[] array,int parent,int len) {
        int child = 2*parent+1;
        while (child < len) {

            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }

            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }

    /**
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void heapSort(int[] array) {
        long start = System.currentTimeMillis();
        createHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-start);
    }
    //划分函数
    public static int partion(int[] array,int start,int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end--;
            }
            if(start >= end) {
                //array[start] = tmp;
                break;
            }else {
                array[start] = array[end];
            }

            while (start < end && array[start] <= tmp) {
                start++;
            }
            if(start >= end) {
                //array[start] = tmp;
                break;
            }else {
                array[end] = array[start];
            }

        }
        array[start] = tmp;
        return start;
    }

    /**
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(logn)
     * 稳定性：不稳定的排序
     * @param array
     * @param low
     * @param high
     */
    public static void quick(int[] array,int low,int high) {
        if(low >= high) {
            return;
        }
        int par = partion(array,low,high);
        quick(array,low,par-1);
        quick(array,par+1,high);
    }

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void main1(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            //array[i] = i;
            array[i] = random.nextInt(10_0000);
        }
        heapSort(array);
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));


    }
}
