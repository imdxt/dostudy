package search;

public class BinarySearchTest {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        int index = binarySearch(arr,10);
        System.out.println(index);

    }

    /**
     * 二分查找算法
     * @param arr 有序数组
     * @param data 查找的数据
     * @return index 下标，未查找到时候返回-1
     */
    public static int binarySearch(int[] arr,int data){
        int low = 0;
        int height = arr.length -1;

        while (low <= height){

            int mid = low + (height - low)/2;

            if(arr[mid] < data){
                low = mid + 1;
            }else if(arr[mid] == data){
                return mid;
            }else {
                height = mid -1;
            }
        }

        return -1;
    }

    private static int binary(int[] arr,int data){

        return -1;
    }
}
