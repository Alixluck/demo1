package com.alix.orm.demo1.suanfa;

/**
 * @author 杨安星(Alix)
 * @create 2019-12-19 16:19
 */
public class No1 {

    /**
     *
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
     *
     * 示例 1:
     *
     * 输入: [4,2,3]
     * 输出: True
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     *
     * 输入: [4,2,1]
     * 输出: False
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     * 说明:  n 的范围为 [1, 10,000]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-decreasing-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public boolean checkPossibility(int[] nums) {
        boolean result = false;
        int count =0;
        for (int i=1;i<nums.length;i++){
            for (int k=0;k<i;k++){
                if (nums[k]<nums[i]){
                    count++;
                }
            }
        }
        if (count==0 || count>1){
            result = true;
        }
        return result;
    }
}
