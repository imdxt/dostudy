package test;

import java.util.HashMap;

/**
 *      和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *      输入:nums = [1,1,1], k = 2
 *      输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *      数组的长度为 [1, 20,000]。
 *      数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 */
public class SubArraySum {
    public static void main(String[] args){

        int[] nums = {3,4,7,2,-3,1,4,2};
//        System.out.println(" --result ==="+subarraySum(nums,7));
        System.out.println(" --result ==="+subarraySum1(nums,7));
//        System.out.println(" --result ==="+subarraySum2(nums,7));
    }

    /**
     * 计算完包括了当前数前缀和以后，我们去查一查在当前数之前，有多少个前缀和等于 preSum - k 呢？
     * 这是因为满足 preSum - (preSum - k) == k 的区间的个数是我们所关心的。
     *
     * 对于一开始的情况，下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个，因此 preSumFreq.put(0, 1);，这一点是必要且合理的。
     * 具体的例子是：nums = [3,...], k = 3，和 nums = [1, 1, 1,...], k = 3。
     *
     */
    private static int subarraySum(int[] nums,int k){
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            System.out.println(" pre="+pre+"/ "+(pre-k));
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                System.out.println("count ="+count+" sum="+sum +"/ start "+start+"/ end "+end);   
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                System.out.println("count ="+count+" sum="+sum +"/ start "+start+"/ end "+end);
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
