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
 * 解题思路：
 *      1、如果不考虑时间复杂度和额外空间的话 使用集合存储遍历的数字，如果集合中没有则添加，如果集合中有则删除，最后集合中只剩下一个只出现一次的数字
 *      2、位运算-（看了答案才明白的）
 *  正确解法是使用异或运算
 *      1、任何数和0做异或运算，结果仍然是原来的数，即 a⊕0=a。5^0 = 5
 *      2、任何数和自身异或运算，结果是0。 5^5 = 0
 *      3、异或运算满足交换定律和结合定律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 *        5^3^5^6^7^6^7 = 3
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
