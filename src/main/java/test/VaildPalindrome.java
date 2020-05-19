package test;

/**
 * 验证回文字符串 Ⅱ
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 *
     * 输入: "aba"
     * 输出: True
 * 示例 2:
     * 输入: "abca"
     * 输出: True
 * 解释: 你可以删除c字符。
 */
public class VaildPalindrome {
    public static void main(String[] args){
        System.out.println(" result ="+vaildPalindrome("abc"));

    }
    private static boolean vaildPalindrome(String s){
        int low = 0;
        int high = s.length() -1;
        while (low < high){
            System.out.println("vaildPalindrome ==low ="+low+"/ high="+high);
            if(s.charAt(low) != s.charAt(high)){
                return isPalindromeRange(s,low,high);
            }

            low++;
            high--;

        }

        return true;
    }
    private static boolean isPalindromeRange(String s,int low,int high){
        boolean flag1 = true, flag2 = true;
        System.out.println("isPalindromeRange ==start ="+low+"/ end="+high);
        for (int i = low, j = high - 1; i < j; i++, j--) {
            char c3 = s.charAt(i), c4 = s.charAt(j);
            if (c3 != c4) {
                flag1 = false;
                break;
            }
        }
        for (int i = low + 1, j = high; i < j; i++, j--) {
            char c3 = s.charAt(i), c4 = s.charAt(j);
            if (c3 != c4) {
                flag2 = false;
                break;
            }
        }
        return flag1 || flag2;



        //时间复杂度为o(n2)
//        for (int i = low; i <= low + (high -low)/2 ; i++) {
//            System.out.println("isPalindromeRange ==start ="+low+"/ end="+high+"/ "+i);
//            if(s.charAt(i) != s.charAt(high - i +low)){
//                return false;
//            }
//        }
//        return true;
    }
}
