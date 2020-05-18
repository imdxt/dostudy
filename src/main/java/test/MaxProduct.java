package test;

/**
 *          乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 *      输入: [2,3,-2,4]
 *      输出: 6
 *      解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *      输入: [-2,0,-1]
 *      输出: 0
 *      解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *      思路
 * 标签：动态规划
 * 遍历数组时计算当前最大值，不断更新
 * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
 * 当负数出现时则imax与imin进行交换再进行下一步计算
 */
public class MaxProduct {
    public static void main(String[] args){
//        int[] data = {2,3,-1,4};
        int[] data = {-1,-2,-9,-6};
        System.out.println("result ="+maxProduct(data));

    }
    private static int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        int curMax = 1;
        int curMin = 1;
        for (int num: nums) {
            //如果负数，则最大值变最小值，最小值变最大值
            if(num < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num,num);

            max = Math.max(max,curMax);
            System.out.println(" ### num="+num+"/ max="+max+"/ curMax ="+curMax+"/ curMin ="+curMin);
        }
        return max;
    }
}
