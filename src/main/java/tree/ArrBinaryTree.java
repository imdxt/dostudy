package tree;

//第n个左子节点为2*n+1
//第n个右子节点为2*n+2
//第n个元素的父节点为(n-1)/2
class ArrBinaryDemo{
    //存储节点的数组
    private int[] arr;
    public ArrBinaryDemo(int[] arr){
        this.arr = arr;
    }
    //前序
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数字为空");
            return;
        }
        //DLR
        System.out.println(arr[index]);
        if((2 * index + 1) < arr.length){
            preOrder(2 * index +1);
        }
        if((2 * index + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }

    //中序

    //后续
}

public class ArrBinaryTree {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        ArrBinaryDemo arrBinaryDemo = new ArrBinaryDemo(arr);
        arrBinaryDemo.preOrder(0);
    }

}

