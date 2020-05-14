package test;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 */
public class SingleNumber {
    public static void main(String[] args){

        int[] num = {2,2,1};
//        System.out.println(" result ="+singleNumber(num));
        System.out.println(" result1 ="+singleNumber1(num));

    }
    private static int singleNumber1(int[] nums){
        int single = 0;
        for (int num:nums) {
            single ^=num;
        }

        ArrayList
        return single;
    }
    private static int singleNumber(int[] num){
        int size = num.length;
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int cur = num[i];
            System.out.println(" cur "+cur);
            if(data.contains(cur)){
                data.remove(cur);
            }else {
                data.add(cur);

            }
        }
        return data.iterator().next();
    }
}
